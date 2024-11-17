package application.repository;

import application.model.SalesAndTrafficByDateEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesAndTrafficByDateRepository extends MongoRepository<SalesAndTrafficByDateEntity, String> {
    List<SalesAndTrafficByDateEntity> findByDateBetween(LocalDate fromDate, LocalDate toDate, Pageable pageable);

    List<SalesAndTrafficByDateEntity> findByDateBetween(LocalDate fromDate, LocalDate toDate);
}

