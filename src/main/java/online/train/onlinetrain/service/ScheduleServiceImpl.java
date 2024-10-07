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





//    @Override
//    public List<Schedule> createSchedules(LocalDate date) {
//        List<Schedule> scheduleList = new ArrayList<>();
//        LocalDateTime morningDepartureTime = LocalDateTime.of(date, LocalTime.of(8,0));
//        LocalDateTime morningArrivalTime = morningDepartureTime.plusHours(1).plusMinutes(45);
//        Duration morningDuration = Duration.between(morningDepartureTime, morningArrivalTime);
//
//        Schedule morningSchedule = Schedule.builder()
//                .createdAt(LocalDateTime.now())
//                .arrivalStation("Station A")
//                .departureStation("Station B")
//                .departureTime(morningDepartureTime)
//                .arrivalTime(morningArrivalTime)
//                .duration(morningDuration)
//                .build();
//        scheduleList.add(morningSchedule);
//
//
//        LocalDateTime eveningDepartureTime = LocalDateTime.of(date, LocalTime.of(16, 0));
//        LocalDateTime eveningArrivalTime = eveningDepartureTime.plusHours(1).plusMinutes(45);
//        Duration eveningDuration = Duration.between(eveningDepartureTime, eveningArrivalTime);
//
//        Schedule eveningSchedule = Schedule.builder()
//                .createdAt(LocalDateTime.now())
//                .arrivalStation("Station C")
//                .departureStation("Station D")
//                .departureTime(eveningDepartureTime)
//                .arrivalTime(eveningArrivalTime)
//                .duration(eveningDuration)
//                .build();
//        scheduleList.add(eveningSchedule);
//
//        return scheduleRepository.saveAll(scheduleList);
//    }
public List<Schedule> createSchedules(LocalDate date) {
    List<Schedule> scheduleList = new ArrayList<>();

    // Morning departure times from Lagos to Ibadan
    scheduleList.add(createSchedule("LAGOS", "EBUTA-METTA", date, LocalTime.of(8, 0)));
    scheduleList.add(createSchedule("LAGOS", "AGEGE", date, LocalTime.of(8, 28)));
    scheduleList.add(createSchedule("LAGOS", "AGBADO", date, LocalTime.of(8, 43)));
    scheduleList.add(createSchedule("LAGOS", "PAPALANTO", date, LocalTime.of(9, 9)));
    scheduleList.add(createSchedule("LAGOS", "ABEOKUTA", date, LocalTime.of(9, 35)));
    scheduleList.add(createSchedule("LAGOS", "OMI-ADIO", date, LocalTime.of(10, 11)));
    scheduleList.add(createSchedule("LAGOS", "MONIYA", date, LocalTime.of(8, 0)));

    // Morning departure times from Ibadan to Lagos
    scheduleList.add(createSchedule("IBADAN", "EBUTA-METTA", date, LocalTime.of(10, 3)));
    scheduleList.add(createSchedule("IBADAN", "AGEGE", date, LocalTime.of(9, 48)));
    scheduleList.add(createSchedule("IBADAN", "AGBADO", date, LocalTime.of(9, 23)));
    scheduleList.add(createSchedule("IBADAN", "PAPALANTO", date, LocalTime.of(8, 59)));
    scheduleList.add(createSchedule("IBADAN", "ABEOKUTA", date, LocalTime.of(8, 20)));
    scheduleList.add(createSchedule("IBADAN", "OMI-ADIO", date, LocalTime.of(8, 0)));

    // Afternoon departure times from Lagos to Ibadan
    scheduleList.add(createSchedule("LAGOS", "EBUTA-METTA", date, LocalTime.of(16, 0)));
    scheduleList.add(createSchedule("LAGOS", "AGEGE", date, LocalTime.of(16, 28)));
    scheduleList.add(createSchedule("LAGOS", "AGBADO", date, LocalTime.of(16, 43)));
    scheduleList.add(createSchedule("LAGOS", "PAPALANTO", date, LocalTime.of(17, 9)));
    scheduleList.add(createSchedule("LAGOS", "ABEOKUTA", date, LocalTime.of(17, 35)));
    scheduleList.add(createSchedule("LAGOS", "OMI-ADIO", date, LocalTime.of(18, 11)));
    scheduleList.add(createSchedule("LAGOS", "MONIYA", date, LocalTime.of(16, 0)));

    // Afternoon departure times from Ibadan to Lagos
    scheduleList.add(createSchedule("IBADAN", "EBUTA-METTA", date, LocalTime.of(18, 3)));
    scheduleList.add(createSchedule("IBADAN", "AGEGE", date, LocalTime.of(17, 48)));
    scheduleList.add(createSchedule("IBADAN", "AGBADO", date, LocalTime.of(17, 23)));
    scheduleList.add(createSchedule("IBADAN", "PAPALANTO", date, LocalTime.of(16, 59)));
    scheduleList.add(createSchedule("IBADAN", "ABEOKUTA", date, LocalTime.of(16, 20)));
    scheduleList.add(createSchedule("IBADAN", "OMI-ADIO", date, LocalTime.of(16, 0)));

    return scheduleRepository.saveAll(scheduleList);
}

    private Schedule createSchedule(String departureStation, String arrivalStation, LocalDate date, LocalTime departureTime) {
        LocalDateTime departureDateTime = LocalDateTime.of(date, departureTime);
        return Schedule.builder()
                .departureStation(departureStation)
                .arrivalStation(arrivalStation)
                .departureTime(departureDateTime)
                .createdAt(LocalDateTime.now())
                .build();

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
