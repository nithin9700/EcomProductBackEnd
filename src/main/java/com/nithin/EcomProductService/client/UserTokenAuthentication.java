package com.nithin.EcomProductService.client;
import com.nithin.EcomProductService.exception.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserTokenAuthentication {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${userAuthentication.api.base.url}")
    private String BaseURl;
    @Value("${userAuthentication.api.validate}")
    private String validate;

    public boolean isValid(String token) {
        String url = BaseURl.concat(validate);
        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.GET, entity, Boolean.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new InvalidCredentialException("Invalid Token. Status code: " + response.getStatusCodeValue());
        }


    }

}
