package online.train.onlinetrain.service;

import lombok.extern.slf4j.Slf4j;
import online.train.onlinetrain.Title;
import online.train.onlinetrain.dao.model.TrainClass;
import online.train.onlinetrain.dao.repository.TrainClassRepository;
import online.train.onlinetrain.dto.request.TrainClassRequest;
import online.train.onlinetrain.dto.response.TrainClassResponse;
import online.train.onlinetrain.exception.TrainClassCannotBeFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TrainClassServiceImpl implements TrainClassService {



    @Autowired
    private TrainClassRepository trainClassRepository;

    @Autowired
    private StationService stationService;



    public List<TrainClass> saveTrainClasses(List<TrainClassRequest> trainClassRequests) {
        List<TrainClass> trainClasses = new ArrayList<>();

        for (TrainClassRequest request : trainClassRequests) {
            TrainClass trainClass = TrainClass.builder()
                    .className(request.getClassName())
                    .fare(request.getFare())
                    .title(Title.TIS)
                    .build();
            trainClasses.add(trainClass);
        }

        return trainClassRepository.saveAll(trainClasses);
    }


    @Override
    public TrainClass findTrainClassById(Long trainClassId) {
        Optional<TrainClass> foundTrainClass = trainClassRepository.findById(trainClassId);
        if(foundTrainClass.isPresent()){
            return foundTrainClass.get();
        }
        throw new TrainClassCannotBeFoundException("Trainclass cannot be foung");
    }

    @Override
    public List<TrainClass> findAllTrainClass() {
        return trainClassRepository.findAll();
    }



}



