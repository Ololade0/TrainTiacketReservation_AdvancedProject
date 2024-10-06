package online.train.onlinetrain.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import online.train.onlinetrain.dao.model.ScheduleType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Setter
@Getter
@ToString
public class CreateScheduleRequest {
        private String morningDepartureStation;
        private String morningArrivalStation;
        private LocalDateTime morningDepartureTime;
        private LocalDateTime morningArrivalTime;
        private ScheduleType scheduleType;

        private String eveningDepartureStation;
        private String eveningArrivalStation;
        private LocalDateTime eveningDepartureTime;
        private LocalDateTime eveningArrivalTime;
//        private String eveningDepartureStation;
//        private String eveningArrivalStation;
//        private LocalDateTime eveningDepartureTime;
//        private LocalDateTime eveningArrivalTime;
}
