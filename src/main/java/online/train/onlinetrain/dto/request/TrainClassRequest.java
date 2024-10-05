package online.train.onlinetrain.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import online.train.onlinetrain.Title;
import online.train.onlinetrain.dao.model.Fare;

@Setter
@Getter
public class TrainClassRequest {

    private Long trainClassId;
    private String className;
//    @Column(columnDefinition = "TEXT")
//    private String fare;
    private Fare fare;
    private String title;

}
