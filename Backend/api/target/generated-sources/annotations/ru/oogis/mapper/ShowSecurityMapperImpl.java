package ru.oogis.mapper;

import data.dto.SecurityDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.oogis.transfer.ShowSecurity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-24T19:55:22+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class ShowSecurityMapperImpl implements ShowSecurityMapper {

    @Override
    public ShowSecurity securityDtoToShowSecurity(SecurityDto securityDto) {
        if ( securityDto == null ) {
            return null;
        }

        ShowSecurity showSecurity = new ShowSecurity();

        showSecurity.setUserId( securityDto.getUserId() );
        showSecurity.setLogin( securityDto.getLogin() );
        showSecurity.setPassword( securityDto.getPassword() );

        return showSecurity;
    }

    @Override
    public SecurityDto showSecurityToSecurityDto(ShowSecurity showSecurity) {
        if ( showSecurity == null ) {
            return null;
        }

        SecurityDto securityDto = new SecurityDto();

        securityDto.setUserId( showSecurity.getUserId() );
        securityDto.setLogin( showSecurity.getLogin() );
        securityDto.setPassword( showSecurity.getPassword() );

        return securityDto;
    }
}
