package application.service.impl;

import application.dto.internal.GeneralAllDto;
import application.exception.EntityNotFoundException;
import application.model.SalesAndTrafficByAsinEntity;
import application.model.SalesAndTrafficByDateEntity;
import application.repository.SalesAndTrafficByAsinRepository;
import application.repository.SalesAndTrafficByDateRepository;
import application.service.abstraction.SalesAndTrafficService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SalesAndTrafficServiceImpl implements SalesAndTrafficService {

    private final SalesAndTrafficByDateRepository salesAndTrafficByDateRepository;
    private final SalesAndTrafficByAsinRepository salesAndTrafficByAsinRepository;


    @Override
    @Transactional
    @Cacheable(value = "getSalesAndTrafficByDate", key = "#fromDate + '_' + #toDate + '_' + #pageable.toString()", condition = "#fromDate != null and #toDate != null")
    public GeneralAllDto<SalesAndTrafficByDateEntity> getSalesAndTrafficByDate(
            LocalDate fromDate,
            LocalDate toDate,
            Pageable pageable
    ) {
        return new GeneralAllDto<SalesAndTrafficByDateEntity>()
                .setData(salesAndTrafficByDateRepository.findByDateBetween(fromDate, toDate, pageable))
                .setTotalCount(salesAndTrafficByDateRepository.findByDateBetween(fromDate, toDate).size());
    }

    @Override
    @Transactional
    @Cacheable(value = "getSalesAndTrafficByAsin", key = "#asinId", condition = "#asinId != null")
    public SalesAndTrafficByAsinEntity getSalesAndTrafficByAsin(String asinId) {
        return salesAndTrafficByAsinRepository.findByParentAsin(asinId)
                .orElseThrow(() -> new EntityNotFoundException("Asin " + asinId + " not found"));
    }

    @Override
    @Transactional
    @Cacheable(value = "getSalesAndTrafficByDateAll", key = "#pageable.toString()", condition = "#pageable != null")
    public GeneralAllDto<SalesAndTrafficByDateEntity> getSalesAndTrafficByDateAll(Pageable pageable) {
        return new GeneralAllDto<SalesAndTrafficByDateEntity>()
                .setData(salesAndTrafficByDateRepository.findAll(pageable).stream().toList())
                .setTotalCount((int) salesAndTrafficByDateRepository.count());
    }

    @Override
    @Transactional
    @Cacheable(value = "getSalesAndTrafficByAsinAll", key = "#pageable.toString()", condition = "#pageable != null")
    public GeneralAllDto<SalesAndTrafficByAsinEntity> getSalesAndTrafficByAsinAll(Pageable pageable) {
        return new GeneralAllDto<SalesAndTrafficByAsinEntity>()
                .setData(salesAndTrafficByAsinRepository.findAll(pageable).stream().toList())
                .setTotalCount((int) salesAndTrafficByAsinRepository.count());
    }
}
