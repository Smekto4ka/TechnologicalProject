package love.smekto4ka.web;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping(value = "/articles")
    public Object getArticles(@RegisteredOAuth2AuthorizedClient("articles-client-authorization-code")
                                        OAuth2AuthorizedClient authorizedClient) {
        return "sdfsde e e e e e e e e e ";
    }
}
