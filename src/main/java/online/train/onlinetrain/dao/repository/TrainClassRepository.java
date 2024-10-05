package online.train.onlinetrain.dao.repository;

import online.train.onlinetrain.dao.model.TrainClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainClassRepository extends JpaRepository<TrainClass, Long> {

}
