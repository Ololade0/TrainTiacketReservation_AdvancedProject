package online.train.onlinetrain.dto.response;

import lombok.*;
import online.train.onlinetrain.dao.model.Fare;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainClassResponse {
    private Long trainClassId;
    private String className;
    private Fare fare;
    private String message;
    private String title;

}
