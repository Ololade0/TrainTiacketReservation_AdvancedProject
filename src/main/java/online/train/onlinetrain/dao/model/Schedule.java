package online.train.onlinetrain.dao.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    private LocalTime departureTime;
    private LocalTime  arrivalTime;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private Duration duration;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private ScheduleType scheduleType;
    private DepartureStations departureStations;
    private ArrivalStation arrivalStation;




//    @ManyToOne
//    @JoinColumn(name = "train_id")
//    @JsonIgnore
//    private Train trainSchedule;
//
//    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Station> stationList = new ArrayList<>();

}
