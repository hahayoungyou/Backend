package monthsago.tarvel16.controller;

import monthsago.tarvel16.Model.Board;
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


    @GetMapping("/getschedule/{no}")
    public List<Schedule> getSchedule( @PathVariable String no) {

        return scheduleService.getSchedule(no);
    }
    @PostMapping("/saveschedule")
    public Schedule saveSchedule(@RequestBody Schedule schedule) {

     //=> id를 받아와서  reschedule 에 저장

        return   scheduleService.saveSchedule(schedule);
    }
    @DeleteMapping("/deleteschedule/{no}")
    public void deleteSchedule(@PathVariable Integer no) {
        scheduleService.deleteSchedule(no);
    }
    @PutMapping("/updateschedule/{no}")
    public void updateschedule(@PathVariable Integer no, @RequestBody Schedule schedule) {
        scheduleService.updateSchedule(no,schedule);
    }
}
