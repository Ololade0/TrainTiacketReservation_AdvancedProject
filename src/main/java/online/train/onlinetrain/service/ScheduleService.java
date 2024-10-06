package online.train.onlinetrain.service;

import online.train.onlinetrain.dao.model.Schedule;
import online.train.onlinetrain.dto.request.CreateScheduleRequest;
import online.train.onlinetrain.exception.ScheduleCannotBeFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ScheduleService {


    public List<Schedule> createSchedules(LocalDate date);
//    List<Schedule> createSchedules(CreateScheduleRequest createScheduleRequest);
    Optional<Schedule> findSchedule(Long schedule);

    Schedule updateSchedule(Schedule createdSchedule, Long scheduleId) throws ScheduleCannotBeFoundException;
}
