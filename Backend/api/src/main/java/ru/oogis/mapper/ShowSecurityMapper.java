package ru.oogis.mapper;

import data.dto.SecurityDto;
import org.mapstruct.Mapper;
import ru.oogis.transfer.ShowSecurity;

@Mapper(componentModel = "spring" )
public interface ShowSecurityMapper {
    ShowSecurity securityDtoToShowSecurity(SecurityDto securityDto);
    SecurityDto showSecurityToSecurityDto(ShowSecurity showSecurity);
}
