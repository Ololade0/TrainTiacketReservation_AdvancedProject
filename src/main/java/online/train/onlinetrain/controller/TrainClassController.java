package online.train.onlinetrain.controller;

import online.train.onlinetrain.dao.model.Station;
import online.train.onlinetrain.dao.model.TrainClass;
import online.train.onlinetrain.dto.request.TrainClassRequest;
import online.train.onlinetrain.service.TrainClassService;
import online.train.onlinetrain.dto.response.TrainClassResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/trainsclass")
public class TrainClassController {

    @Autowired
    private TrainClassService trainClassService;



    @PostMapping("/addtrainclass")
    public ResponseEntity<List<TrainClass>> saveTrainClasses(@RequestBody List<TrainClassRequest> trainClassRequests)
                                               {
       List<TrainClass> savedTrainClasses = trainClassService.saveTrainClasses(trainClassRequests);
        return new ResponseEntity<>(savedTrainClasses, HttpStatus.CREATED);

}
    @GetMapping("/{trainClassId}")
    public ResponseEntity<?>findTrainClassById(@PathVariable Long trainClassId){
       return new ResponseEntity<>(trainClassService.findTrainClassById(trainClassId), HttpStatus.OK);
    }


    @GetMapping("/findAll")
    public ResponseEntity<?>findAllTrain(){
        return new ResponseEntity<>(trainClassService.findAllTrainClass(), HttpStatus.OK);
    }
//    @GetMapping("findAll")
//    public ResponseEntity<?>findTrainAll(){
//        return new ResponseEntity<>(trainClassService., HttpStatus.OK);
//    }
}



