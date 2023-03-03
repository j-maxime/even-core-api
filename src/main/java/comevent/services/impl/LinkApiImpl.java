package comevent.services.impl;

import comevent.services.LinkApi;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class LinkApiImpl implements LinkApi {
    private String url;
    private RestTemplate restTemplate;
    private HttpHeaders headers;
    private String requestType;
    public LinkApiImpl(){
        this.restTemplate = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public Object request(String url, String requestType, String body){
        this.url = url;
        this.requestType = requestType;
        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<Object> response = restTemplate.postForEntity(this.url, request, Object.class);
        return response.getBody();
    }
}
