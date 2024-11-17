package application.controller;

import application.dto.internal.GeneralAllDto;
import application.model.SalesAndTrafficByAsinEntity;
import application.model.SalesAndTrafficByDateEntity;
import application.service.abstraction.SalesAndTrafficService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales_and_traffic")
@Tag(name = "Sales and traffic supervision", description = "Endpoints for sales and traffic supervision")
public class SalesAndTrafficController {

    private final SalesAndTrafficService salesAndTrafficService;

    @GetMapping("/date")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get analytics for specified date",
            description = "Endpoint for getting analytics for specified date")
    public GeneralAllDto<SalesAndTrafficByDateEntity> getSalesAndTrafficByDate(
            @RequestParam(name = "from_date") LocalDate fromDate,
            @RequestParam(name = "to_date", required = false) LocalDate toDate,
            Pageable pageable
    ) {
        return salesAndTrafficService.getSalesAndTrafficByDate(fromDate.minusDays(1L),
                toDate == null? fromDate.plusDays(1L) : toDate.plusDays(1L), pageable);
    }

    @GetMapping("/asin")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get analytics for specified asin",
            description = "Endpoint for getting analytics for specified asin")
    public SalesAndTrafficByAsinEntity getSalesAndTrafficByAsin(
            @RequestParam(name = "asin_id") String asinId
    ) {
        return salesAndTrafficService.getSalesAndTrafficByAsin(asinId);
    }

    @GetMapping("/date/all")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get analytics for all period",
            description = "Endpoint for getting analytics for all period")
    public GeneralAllDto<SalesAndTrafficByDateEntity> getSalesAndTrafficByDateAll(Pageable pageable) {
        return salesAndTrafficService.getSalesAndTrafficByDateAll(pageable);
    }

    @GetMapping("/asin/all")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get analytics for all asins",
            description = "Endpoint for getting analytics for all asins")
    public GeneralAllDto<SalesAndTrafficByAsinEntity> getSalesAndTrafficByAsinAll(Pageable pageable) {
        return salesAndTrafficService.getSalesAndTrafficByAsinAll(pageable);
    }
}
