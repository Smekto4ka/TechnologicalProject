package ru.oogis.mapper;

import event.EventEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.oogis.event.MyEvent;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-24T16:43:38+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public MyEvent mapping(EventEntity event) {
        if ( event == null ) {
            return null;
        }

        MyEvent myEvent = new MyEvent();

        return myEvent;
    }
}
