package monthsago.tarvel16.controller;

import monthsago.tarvel16.Model.Test;
import monthsago.tarvel16.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TestController {


    @Autowired
    private TestService testService;

    //getAllBoard - mobile
    @GetMapping("/test")
    public List<Test> getTest() {
        return testService.getTest();
    }

}
