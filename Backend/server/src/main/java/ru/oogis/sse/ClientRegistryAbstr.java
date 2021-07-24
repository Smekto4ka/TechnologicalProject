package ru.oogis.sse;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Log4j2
public abstract class ClientRegistryAbstr<T> {

    private final Map<String, SseClient> clients = new ConcurrentHashMap<>();

    public SseEmitter registerClientToEvent(String clientId, Long time) {
        return registerClientToEvent(clientId, time, Collections.EMPTY_SET);
    }

    public SseEmitter registerClientToEvent(String clientId, Long time, Set<EventType> eventTypes) {
        SseEmitter sseEmitter = new SseEmitter(time);
        registerClientToEvents(clientId, sseEmitter, eventTypes);
        sseEmitter.onCompletion(() -> unregisterClient(clientId));
        return sseEmitter;
    }

    public void registerClientToEvents(String clientId, SseEmitter emitter, Set<EventType> eventTypes) {
        SseClient newClient = new SseClient(clientId, emitter);
        newClient.addEvents(eventTypes);
        clients.merge(clientId, newClient, (oldClient, client) -> {
            client.addEvents(oldClient.getEvents());
            return client;
        });
        log.info("SSE property listener added id = " + clientId);
    }

    public void unregisterClient(String clientId) {
        if (clients.size() != 0) {
            SseClient client = clients.remove(clientId);
            SseEmitter emitter = client.getEmitter();
            emitter.complete();
            log.info("Unregister client id = " + clientId);
        }
    }

    public void updateClient(String newClientId, String oldClientId) {
        SseClient client = clients.remove(oldClientId);
        if (client != null) {
            client.setClientId(newClientId);
            clients.put(newClientId, client);
        }
    }

    protected void send(T event) {
        clients.values().forEach(emitter -> {
            try {
                emitter.getEmitter().send(event, MediaType.APPLICATION_JSON);
            } catch (IOException e) {
                emitter.getEmitter().complete();
            }
        });
    }
}
