package ru.oogis.mapper;

import event.EventEntity;
import org.mapstruct.Mapper;
import ru.oogis.event.MyEvent;

@Mapper(componentModel = "spring" )
public interface EventMapper {


    MyEvent mapping(EventEntity event);
}
