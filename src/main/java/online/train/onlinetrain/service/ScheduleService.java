package online.train.onlinetrain.service;

import online.train.onlinetrain.dao.model.Schedule;
import online.train.onlinetrain.exception.InvalidScheduleException;
import online.train.onlinetrain.exception.ScheduleCannotBeFoundException;
import online.train.onlinetrain.exception.ScheduleDetailsException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ScheduleService {


    List<Schedule> createSchedules(LocalDate date) throws InvalidScheduleException, ScheduleDetailsException;
    Optional<Schedule> findSchedule(Long schedule);

    Schedule updateSchedule(Schedule createdSchedule, Long scheduleId) throws ScheduleCannotBeFoundException;

     List<Schedule> findAllSchedule();
}
