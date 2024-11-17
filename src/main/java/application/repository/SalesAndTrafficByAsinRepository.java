package application.repository;

import application.model.SalesAndTrafficByAsinEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesAndTrafficByAsinRepository extends MongoRepository<SalesAndTrafficByAsinEntity, String> {

    Optional<SalesAndTrafficByAsinEntity> findByParentAsin(String asin);

}

