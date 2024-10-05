package online.train.onlinetrain.dto.response;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
public class TrainResponse {
    private Long trainId;
    private String trainType;
    private String trainName;
    private List<TrainClassResponse> trainClasses;

    public TrainResponse(Long trainId, String trainType, String trainName, List<TrainClassResponse> trainClasses) {
        this.trainId = trainId;
        this.trainType = trainType;
        this.trainName = trainName;
        this.trainClasses = trainClasses;
    }

}
