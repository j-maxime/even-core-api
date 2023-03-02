package comevent.controllers;


import comevent.services.CoreService;
import comevent.services.impl.CoreServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
public class CoreController {

    private final CoreServiceImpl coreService;

    CoreController(CoreServiceImpl coreService){
        this.coreService = coreService;
    }

    @GetMapping
    public String getTest() {
        return "core api is runnings";
    }

    @PostMapping("/login")
    public String loginAdmin(@RequestBody String admin) {
        //return true;
        return this.coreService.loginAdmin(admin);
    }
}
