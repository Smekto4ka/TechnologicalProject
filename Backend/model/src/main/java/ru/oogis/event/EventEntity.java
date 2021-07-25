package ru.oogis.event;

import org.springframework.context.ApplicationEvent;

public class EventEntity extends ApplicationEvent {
    public EventEntity(Object source) {
        super(source);
    }

    //eventPublisher.publishEvent(new Event(this, clsDto, ModelChangeType.CREATE));
}
