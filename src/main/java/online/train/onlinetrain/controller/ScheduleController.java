package online.train.onlinetrain.controller;
import online.train.onlinetrain.dao.model.Schedule;
import online.train.onlinetrain.exception.InvalidScheduleException;
import online.train.onlinetrain.exception.ScheduleDetailsException;
import online.train.onlinetrain.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/schedule")
public class ScheduleController {
        @Autowired
        private ScheduleService scheduleService;

        @PostMapping("/createschedule")
        public ResponseEntity<?> createSchedules(
                @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
            try {

                List<Schedule> schedules = scheduleService.createSchedules(date);
                return new ResponseEntity<>(schedules, HttpStatus.CREATED);
//            }
//            catch (Exception e) {
//                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

            } catch (InvalidScheduleException | ScheduleDetailsException e) {
                throw new RuntimeException(e);
            }


        }
}

