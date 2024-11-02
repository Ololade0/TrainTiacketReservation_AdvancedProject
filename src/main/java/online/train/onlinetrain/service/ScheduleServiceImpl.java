package online.train.onlinetrain.service;
import lombok.RequiredArgsConstructor;
import online.train.onlinetrain.dao.model.ArrivalStation;
import online.train.onlinetrain.dao.model.Schedule;
import online.train.onlinetrain.dao.model.DepartureStations;
import online.train.onlinetrain.dao.model.ScheduleType;
import online.train.onlinetrain.dao.repository.ScheduleRepository;
import online.train.onlinetrain.exception.InvalidScheduleException;
import online.train.onlinetrain.exception.ScheduleCannotBeFoundException;
import online.train.onlinetrain.exception.ScheduleDetailsException;
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
//    private final StationService stationService;


        public List<Schedule> createSchedules(LocalDate date) throws InvalidScheduleException, ScheduleDetailsException {
            List<Schedule> scheduleList = new ArrayList<>();
            TrainTimetable( date, scheduleList);
            return scheduleRepository.saveAll(scheduleList);
        }

    private void TrainTimetable(LocalDate date, List<Schedule> scheduleList) throws InvalidScheduleException, ScheduleDetailsException {
        // Morning departure times from Lagos to Ibadan
        scheduleList.add(createSchedule( DepartureStations.EBUTA_META_STATION, ArrivalStation.MONIYA_STATION, ScheduleType.MORNING, date, LocalTime.of(8, 0)));
        scheduleList.add(createSchedule(DepartureStations.AGEGE_STATION, ArrivalStation.MONIYA_STATION, ScheduleType.MORNING,  date, LocalTime.of(8, 28)));
        scheduleList.add(createSchedule(DepartureStations.AGBADO_STATION, ArrivalStation.MONIYA_STATION, ScheduleType.MORNING, date, LocalTime.of(8, 43)));
        scheduleList.add(createSchedule(DepartureStations.PAPALANTO_STATION, ArrivalStation.MONIYA_STATION, ScheduleType.MORNING,  date, LocalTime.of(9, 9)));
        scheduleList.add(createSchedule(DepartureStations.ABEOKUTA,ArrivalStation.MONIYA_STATION, ScheduleType.MORNING,  date, LocalTime.of(9, 35)));
        scheduleList.add(createSchedule(DepartureStations.OMI_ADIO_STATION, ArrivalStation.MONIYA_STATION, ScheduleType.MORNING,  date, LocalTime.of(10, 11)));
//        scheduleList.add(createSchedule(DepartureStations.MONIYA_STATION, date, LocalTime.of(10,30)));

        // Morning departure times from Ibadan to Lagos
        scheduleList.add(createSchedule(DepartureStations.MONIYA_STATION,ArrivalStation.EBUTA_META_STATION,ScheduleType.MORNING, date, LocalTime.of(8, 0)));
        scheduleList.add(createSchedule(DepartureStations.OMI_ADIO_STATION,  ArrivalStation.EBUTA_META_STATION,ScheduleType.MORNING,date, LocalTime.of(8, 20)));
        scheduleList.add(createSchedule(DepartureStations.ABEOKUTA,ArrivalStation.EBUTA_META_STATION,ScheduleType.MORNING, date, LocalTime.of(8, 59)));
        scheduleList.add(createSchedule(DepartureStations.PAPALANTO_STATION, ArrivalStation.EBUTA_META_STATION,ScheduleType.MORNING,date, LocalTime.of(9, 23)));
        scheduleList.add(createSchedule(DepartureStations.AGBADO_STATION, ArrivalStation.EBUTA_META_STATION,ScheduleType.MORNING, date, LocalTime.of(9, 48)));
        scheduleList.add(createSchedule(DepartureStations.AGEGE_STATION, ArrivalStation.EBUTA_META_STATION,ScheduleType.MORNING,date, LocalTime.of(10, 3)));
//        scheduleList.add(createSchedule(DepartureStations.EBUTA_META_STATION, ArrivalStation.EBUTA_META_STATION,ScheduleType.MORNING,date, LocalTime.of(8, 0)));

        //        // Afternoon departure times from Lagos to Ibadan
        scheduleList.add(createSchedule(DepartureStations.EBUTA_META_STATION, ArrivalStation.MONIYA_STATION, ScheduleType.EVENING, date, LocalTime.of(16, 0)));
        scheduleList.add(createSchedule(DepartureStations.AGEGE_STATION, ArrivalStation.MONIYA_STATION, ScheduleType.EVENING, date, LocalTime.of(16, 28)));
        scheduleList.add(createSchedule(DepartureStations.AGBADO_STATION,ArrivalStation.MONIYA_STATION, ScheduleType.EVENING,  date, LocalTime.of(16, 43)));
        scheduleList.add(createSchedule(DepartureStations.PAPALANTO_STATION,  ArrivalStation.MONIYA_STATION, ScheduleType.EVENING,date, LocalTime.of(17, 9)));
        scheduleList.add(createSchedule(DepartureStations.ABEOKUTA, ArrivalStation.MONIYA_STATION, ScheduleType.EVENING,date, LocalTime.of(17, 35)));
        scheduleList.add(createSchedule(DepartureStations.OMI_ADIO_STATION, ArrivalStation.MONIYA_STATION, ScheduleType.EVENING,date, LocalTime.of(18, 11)));
//        scheduleList.add(createSchedule(DepartureStations.MONIYA_STATION,  date, LocalTime.of(16, 0)));

        // Afternoon departure times from Ibadan to Lagos
        scheduleList.add(createSchedule(DepartureStations.AGEGE_STATION, ArrivalStation.EBUTA_META_STATION, ScheduleType.EVENING,date, LocalTime.of(18, 3)));
        scheduleList.add(createSchedule(DepartureStations.AGBADO_STATION, ArrivalStation.EBUTA_META_STATION, ScheduleType.EVENING,date, LocalTime.of(17, 48)));
        scheduleList.add(createSchedule(DepartureStations.PAPALANTO_STATION, ArrivalStation.EBUTA_META_STATION, ScheduleType.EVENING,  date, LocalTime.of(17, 23)));
        scheduleList.add(createSchedule(DepartureStations.ABEOKUTA,ArrivalStation.EBUTA_META_STATION, ScheduleType.EVENING, date, LocalTime.of(16, 59)));
        scheduleList.add(createSchedule(DepartureStations.OMI_ADIO_STATION, ArrivalStation.EBUTA_META_STATION, ScheduleType.EVENING, date, LocalTime.of(16, 20)));
        scheduleList.add(createSchedule(DepartureStations.MONIYA_STATION,ArrivalStation.EBUTA_META_STATION, ScheduleType.EVENING,  date, LocalTime.of(16, 0)));



    }


    private Schedule createSchedule(DepartureStations departureStations, ArrivalStation arrivalStation, ScheduleType scheduleType,LocalDate date, LocalTime departureTime) throws InvalidScheduleException, ScheduleDetailsException {
   LocalTime arrivalTime = departureTime.plusHours(1).plusMinutes(45);
        validateScheduleTimetable(departureStations, arrivalStation, scheduleType, date, departureTime, arrivalTime);
        return Schedule.builder()
                .departureTime(departureTime)
                .arrivalTime(arrivalTime)
                .departureDate(date)
                .arrivalDate(date)
                .duration(Duration.between(departureTime, arrivalTime))
                .departureStations(departureStations)
                .arrivalStation(arrivalStation)
                .createdAt(LocalDateTime.now())
                .scheduleType(scheduleType)
                .build();

}

    private static void validateScheduleTimetable(DepartureStations departureStations, ArrivalStation arrivalStation, ScheduleType scheduleType, LocalDate date, LocalTime departureTime, LocalTime arrivalTime) throws ScheduleDetailsException, InvalidScheduleException {
        if (departureStations == null || arrivalStation == null || scheduleType == null
                || date == null || departureTime == null) {
            throw new ScheduleDetailsException("All parameters must be provided and cannot be null.");
        }
        if (arrivalTime.isBefore(departureTime)) {
            throw new ScheduleDetailsException("Arrival time cannot be before departure time.");
        }
        LocalDate currentDate = LocalDate.now();
        if (date.isEqual(currentDate) || date.isBefore(currentDate)) {
            throw new ScheduleDetailsException("The departure date must be at least 2 days in advance. or you cannot schedule a train for a past date ");
        }

        LocalDate minScheduleDate = currentDate.plusDays(2);
        if (date.isBefore(minScheduleDate)) {
            throw new ScheduleDetailsException("Schedules can only be created for at least 2 days in advance.");
        }

        LocalDate maxScheduleDate = currentDate.plusDays(2);
        if (date.isAfter(maxScheduleDate)) {
            throw new InvalidScheduleException("Schedules can only be created for up to 2 days in advance.");
        }
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
//          foundSchedule.get().setArrivalStation(createdSchedule.getArrivalStation());
          foundSchedule.get().setUpdatedAt(LocalDateTime.now());
//          foundSchedule.get().setDepartureStation(createdSchedule.getDepartureStation());
          foundSchedule.get().setDuration(createdSchedule.getDuration());
//          foundSchedule.get().setTrainSchedule(createdSchedule.getTrainSchedule());
          foundSchedule.get().setArrivalTime(createdSchedule.getArrivalTime());
          foundSchedule.get().setDepartureTime(createdSchedule.getDepartureTime());
          return scheduleRepository.save(foundSchedule.get());
      }
        throw new ScheduleCannotBeFoundException("Schedule cannot Be found");
    }

    @Override
    public List<Schedule> findAllSchedule() {
        return scheduleRepository.findAll();
    }

}
