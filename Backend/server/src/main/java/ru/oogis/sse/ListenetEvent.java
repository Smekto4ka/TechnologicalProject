package ru.oogis.sse;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.oogis.event.MyEvent;

@Component("MyListener")
public class ListenetEvent extends ClientRegistryAbstr<MyEvent>{

    @EventListener(MyEvent.class)
    public void handleOntologyOntoObjChange(MyEvent event) {
        System.out.println("OntoObjEvent");
        send(event);
    }
}
