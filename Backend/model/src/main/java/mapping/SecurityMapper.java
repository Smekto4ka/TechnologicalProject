package mapping;

import data.dto.SecurityDto;
import entity.SecurityData;
import entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface SecurityMapper {
    @Mappings({
            @Mapping(target = "userId", source = "id"),
            @Mapping(target = "login", source = "securityData.login"),
            @Mapping(target = "password", source = "securityData.password")
    })
    SecurityDto UserToDto(User user);

    SecurityData securityDtoToEntity(SecurityDto securityDto);
}
