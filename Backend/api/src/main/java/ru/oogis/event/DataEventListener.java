package ru.oogis.event;

import event.EventEntity;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.oogis.mapper.EventMapper;

@Component
public class DataEventListener {
    private final EventMapper mapper;
    private final ApplicationEventPublisher eventPublisher;

    public DataEventListener(EventMapper mapper, ApplicationEventPublisher eventPublisher) {
        this.mapper = mapper;
        this.eventPublisher = eventPublisher;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION, classes = {EventEntity.class})
    public void onOntologyClsChange(EventEntity event) {
        eventPublisher.publishEvent(mapper.mapping(event));
    }
}
