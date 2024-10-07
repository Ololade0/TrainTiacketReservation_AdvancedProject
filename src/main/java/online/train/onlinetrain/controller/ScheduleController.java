package online.train.onlinetrain.controller;
import online.train.onlinetrain.dao.model.Schedule;
import online.train.onlinetrain.dto.request.CreateScheduleRequest;
import online.train.onlinetrain.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@RequestMapping("api/schedule")
public class ScheduleController {
//    @Autowired
//    private ScheduleService scheduleService;
//
//    @PostMapping("/createschedule")
//    public ResponseEntity<?> createSchedules(
//            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
//        try {
//            List<Schedule> schedules = scheduleService.createSchedules(date);
//            return new ResponseEntity<>(schedules, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }


    @Autowired
    private ScheduleService scheduleService;

    // Define a bounded task executor with a maximum of 5 concurrent threads


    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    @PostMapping("/create")
    public ResponseEntity<List<Schedule>> createFixedSchedules(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        try {
            // Submit the schedule creation task to the executor
            Future<List<Schedule>> future = executorService.submit(() ->
                    scheduleService.createSchedules(date)
            );

            // Get the result from the future (waits for the task to complete)
            List<Schedule> schedules = future.get();

            return new ResponseEntity<>(schedules, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

