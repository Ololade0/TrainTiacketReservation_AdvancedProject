package online.train.onlinetrain.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private String departureStation;
    private String arrivalStation;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private Duration duration;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private ScheduleType scheduleType;

//    @ManyToOne
//    @JoinColumn(name = "train_id")
//    @JsonIgnore
//    private Train trainSchedule;
//
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Station> stationList = new ArrayList<>();

}
