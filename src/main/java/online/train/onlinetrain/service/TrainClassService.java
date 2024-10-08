package online.train.onlinetrain.service;


import online.train.onlinetrain.dao.model.TrainClass;
import online.train.onlinetrain.dto.request.TrainClassRequest;
import online.train.onlinetrain.exception.TrainClassCannotBeFoundException;

import java.util.List;

public interface TrainClassService {
    public List<TrainClass> saveTrainClasses(List<TrainClassRequest> trainClassRequests);
    //   TrainClassResponse saveTrainClasses(TrainClassRequest trainClassRequests);
    TrainClass findTrainClassById(Long trainClassId) throws TrainClassCannotBeFoundException;

    List<TrainClass> findAllTrainClass();

}
