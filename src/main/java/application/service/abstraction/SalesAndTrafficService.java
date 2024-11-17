package application.service.abstraction;

import application.dto.internal.GeneralAllDto;
import application.model.SalesAndTrafficByAsinEntity;
import application.model.SalesAndTrafficByDateEntity;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface SalesAndTrafficService {

    GeneralAllDto<SalesAndTrafficByDateEntity> getSalesAndTrafficByDate(
            LocalDate fromDate,
            LocalDate toDate,
            Pageable pageable
    );

    SalesAndTrafficByAsinEntity getSalesAndTrafficByAsin(String asinId);

    GeneralAllDto<SalesAndTrafficByDateEntity> getSalesAndTrafficByDateAll(Pageable pageable);

    GeneralAllDto<SalesAndTrafficByAsinEntity> getSalesAndTrafficByAsinAll(Pageable pageable);
}
