package ru.oogis.sse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


import java.util.HashSet;
import java.util.Set;

public class SseClient {
    //TODO: change to jwt token
    @Getter
    @Setter
    private String clientId;
    @Getter
    @Setter
    private final SseEmitter emitter;
    private final Set<EventType> eventTypes = new HashSet<>();

    public SseClient(String clientId, SseEmitter emitter) {
        this.clientId = clientId;
        this.emitter = emitter;
    }

    public void addEvents(Set<EventType> events) {
        eventTypes.addAll(events);
    }

    public Set<EventType> getEvents() {
        return Set.copyOf(eventTypes);
    }
}
