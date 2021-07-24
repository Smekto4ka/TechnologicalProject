package mapping;

import data.dto.SecurityDto;
import entity.SecurityData;
import entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-24T19:55:19+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class SecurityMapperImpl implements SecurityMapper {

    @Override
    public SecurityDto UserToDto(User user) {
        if ( user == null ) {
            return null;
        }

        SecurityDto securityDto = new SecurityDto();

        securityDto.setUserId( user.getId() );
        securityDto.setLogin( userSecurityDataLogin( user ) );
        securityDto.setPassword( userSecurityDataPassword( user ) );

        return securityDto;
    }

    @Override
    public SecurityData securityDtoToEntity(SecurityDto securityDto) {
        if ( securityDto == null ) {
            return null;
        }

        SecurityData securityData = new SecurityData();

        securityData.setLogin( securityDto.getLogin() );
        securityData.setPassword( securityDto.getPassword() );

        return securityData;
    }

    private String userSecurityDataLogin(User user) {
        if ( user == null ) {
            return null;
        }
        SecurityData securityData = user.getSecurityData();
        if ( securityData == null ) {
            return null;
        }
        String login = securityData.getLogin();
        if ( login == null ) {
            return null;
        }
        return login;
    }

    private String userSecurityDataPassword(User user) {
        if ( user == null ) {
            return null;
        }
        SecurityData securityData = user.getSecurityData();
        if ( securityData == null ) {
            return null;
        }
        String password = securityData.getPassword();
        if ( password == null ) {
            return null;
        }
        return password;
    }
}
