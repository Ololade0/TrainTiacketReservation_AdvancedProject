package online.train.onlinetrain.dao.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stationId;
    private String stationName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "trainClass_id")
//    private TrainClass trainClass;
}
