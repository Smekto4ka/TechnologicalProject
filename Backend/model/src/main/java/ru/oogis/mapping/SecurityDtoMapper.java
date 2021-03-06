package ru.oogis.mapping;

import ru.oogis.dto.SecurityDto;
import ru.oogis.entity.SecurityData;
import ru.oogis.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface SecurityDtoMapper {
    @Mappings({
            @Mapping(target = "userId", source = "id"),
            @Mapping(target = "login", source = "securityData.login"),
            @Mapping(target = "password", source = "securityData.password")
    })
    SecurityDto UserToDto(User user);

    SecurityData securityDtoToEntity(SecurityDto securityDto);
}
