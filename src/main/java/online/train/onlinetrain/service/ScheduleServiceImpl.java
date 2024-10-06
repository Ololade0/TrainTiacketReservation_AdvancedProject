package online.train.onlinetrain.service;
import lombok.RequiredArgsConstructor;
import online.train.onlinetrain.dao.model.Schedule;
import online.train.onlinetrain.dao.model.ScheduleType;
import online.train.onlinetrain.dao.repository.ScheduleRepository;
import online.train.onlinetrain.dto.request.CreateScheduleRequest;
import online.train.onlinetrain.exception.ScheduleCannotBeFoundException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleRepository scheduleRepository;





    @Override
    public List<Schedule> createSchedules(LocalDate date) {
        List<Schedule> scheduleList = new ArrayList<>();
        LocalDateTime morningDepartureTime = LocalDateTime.of(date, LocalTime.of(8,0));
        LocalDateTime morningArrivalTime = morningDepartureTime.plusHours(1).plusMinutes(45);
        Duration morningDuration = Duration.between(morningDepartureTime, morningArrivalTime);

        Schedule morningSchedule = Schedule.builder()
                .createdAt(LocalDateTime.now())
                .arrivalStation("Station A")
                .departureStation("Station B")
                .departureTime(morningDepartureTime)
                .arrivalTime(morningArrivalTime)
                .duration(morningDuration)
                .build();
        scheduleList.add(morningSchedule);


        LocalDateTime eveningDepartureTime = LocalDateTime.of(date, LocalTime.of(16, 0));
        LocalDateTime eveningArrivalTime = eveningDepartureTime.plusHours(1).plusMinutes(45);
        Duration eveningDuration = Duration.between(eveningDepartureTime, eveningArrivalTime);

        Schedule eveningSchedule = Schedule.builder()
                .createdAt(LocalDateTime.now())
                .arrivalStation("Station C")
                .departureStation("Station D")
                .departureTime(eveningDepartureTime)
                .arrivalTime(eveningArrivalTime)
                .duration(eveningDuration)
                .build();
        scheduleList.add(eveningSchedule);

        return scheduleRepository.saveAll(scheduleList);
    }




    @Override
    public Optional<Schedule> findSchedule(Long schedule) {
        Optional<Schedule> foundSchedule =  scheduleRepository.findById(schedule);
        if(foundSchedule.isPresent()){
            return foundSchedule;
        }
        throw new RuntimeException("Schedule cannot be found");
    }

    @Override
    public Schedule updateSchedule(Schedule createdSchedule, Long scheduleId) throws ScheduleCannotBeFoundException {
      Optional<Schedule> foundSchedule =  scheduleRepository.findById(scheduleId);
      if(foundSchedule.isPresent()){
          foundSchedule.get().setArrivalStation(createdSchedule.getArrivalStation());
          foundSchedule.get().setUpdatedAt(LocalDateTime.now());
          foundSchedule.get().setDepartureStation(createdSchedule.getDepartureStation());
          foundSchedule.get().setDuration(createdSchedule.getDuration());
//          foundSchedule.get().setTrainSchedule(createdSchedule.getTrainSchedule());
          foundSchedule.get().setArrivalTime(createdSchedule.getArrivalTime());
          foundSchedule.get().setDepartureTime(createdSchedule.getDepartureTime());
          return scheduleRepository.save(foundSchedule.get());
      }
        throw new ScheduleCannotBeFoundException("Schedule cannot Be found");
    }

}
