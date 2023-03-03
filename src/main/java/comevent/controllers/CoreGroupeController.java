package comevent.controllers;


import comevent.services.impl.CoreGroupeServiceImpl;
import comevent.services.impl.CoreServiceImpl;
import comevent.services.impl.LinkApiImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core/groupes")
public class CoreGroupeController {
    private LinkApiImpl linkApi;

    private String apiGroupesUrl = "http://localhost:8091/groupes";
    private CoreServiceImpl coreService;
    private CoreGroupeServiceImpl coreGroupeService;

    public CoreGroupeController(){
        this.coreGroupeService = new CoreGroupeServiceImpl();
        this.linkApi = new LinkApiImpl();
        this.coreService = new CoreServiceImpl();
    }
    @PostMapping
    public String saveGroupe(final @RequestBody String groupeDto, final @RequestHeader String Authorization) {
        if ( coreService.isValid(Authorization) )
            return coreGroupeService.saveGroupe(groupeDto);
        return "Not autorized";

        //String result = linkApi.request(apiGroupesUrl,"post", groupeDto).toString();
        //return result;
    }

    @GetMapping
    public String getGroupes() {
        return coreGroupeService.getGroupes();
    }

    @GetMapping("/{id}")
    public String getGroupes(@PathVariable Long id) {
        return coreGroupeService.getGroupesById(id);
    }



    @DeleteMapping("/{id}")
    public Boolean deleteArtiste(final @RequestBody Long id) {
        Boolean result = (Boolean) linkApi.request(apiGroupesUrl,"post", id.toString());
        return result;
        //return coreGroupService.saveGroupe(groupeDto);
    }
}
