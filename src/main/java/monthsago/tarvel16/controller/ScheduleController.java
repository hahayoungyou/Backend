package monthsago.tarvel16.controller;

import monthsago.tarvel16.Model.Schedule;
import monthsago.tarvel16.Model.Test;
import monthsago.tarvel16.Service.ScheduleService;
import monthsago.tarvel16.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ScheduleController {


    @Autowired
    private ScheduleService scheduleService;

    //getAllBoard - mobile
    @PostMapping("/saveschedule")
    public Schedule saveSchedule(@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }


}
