package online.train.onlinetrain.controller;
import online.train.onlinetrain.dao.model.Schedule;
import online.train.onlinetrain.dto.request.CreateScheduleRequest;
import online.train.onlinetrain.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/createschedule")
    public ResponseEntity<?> createSchedules(CreateScheduleRequest createScheduleRequest)    {
        // Logging the incoming request
        System.out.println("Received request: " + createScheduleRequest);

        List<Schedule> createdSchedule = scheduleService.createSchedules(createScheduleRequest);
        return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);

    }


}
