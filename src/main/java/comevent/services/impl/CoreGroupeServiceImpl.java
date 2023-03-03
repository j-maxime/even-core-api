package comevent.services.impl;

import comevent.services.CoreGroupeService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service("coreGroupeService")
public class CoreGroupeServiceImpl implements CoreGroupeService {
    String apiGroupes = "http://localhost:8091/groupes";
    private Boolean testInit;
    public CoreGroupeServiceImpl(){
        this.testInit = true;
    }
    @Override
    public String saveGroupe(String groupeDto){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> request = new HttpEntity<>(groupeDto, headers);


        String url = apiGroupes+"";
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response.getBody();
    }

    public String getGroupes(){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> request = new HttpEntity<>("", headers);


        String url = apiGroupes+"";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();

    }

    public String getGroupesById(long id){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> request = new HttpEntity<>("", headers);


        String url = apiGroupes+"/"+id;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();

    }


}
