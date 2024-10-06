package online.train.onlinetrain.dao.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@ToString
@Entity(name = "trainclass")
@AllArgsConstructor
@NoArgsConstructor
public class TrainClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainClassId;
    private String className;
    @Embedded
    private Fare fare;
    private String title;
//    @OneToMany( mappedBy = "trainClass",cascade= CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Station> stationList = new ArrayList<>();
}
