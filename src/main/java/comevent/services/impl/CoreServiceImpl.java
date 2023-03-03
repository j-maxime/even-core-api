package comevent.services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import comevent.services.CoreService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.net.URI;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service("coreService")
public class CoreServiceImpl implements CoreService {
    String apiAdmin = "http://localhost:8090/admin";
    private final boolean testInit;

    public CoreServiceImpl() {
        this.testInit = true;
    }


    @Override
    public String loginAdmin(String adm) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> request = new HttpEntity<>(adm, headers);


        String url = apiAdmin+"/login";
        ResponseEntity<Boolean> response = restTemplate.postForEntity(url, request, Boolean.class);
        Boolean result = response.getBody();

        if ( result ){
            String token = this.getToken();
            return token;
        }
        //return result;
        return "failed";
    }

    private String getToken(){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> request = new HttpEntity<>("",headers);


        String url = apiAdmin+"/token";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String result = response.getBody();
        return result;
    }

    public Boolean isValid(String token){


        String url = apiAdmin+"/tokenIsValid";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);

        HttpEntity<String> request = new HttpEntity<>("", headers);

        ResponseEntity<Boolean> response = restTemplate.postForEntity(url, request, Boolean.class);
        Boolean result = response.getBody();


        return result;
    }



}
