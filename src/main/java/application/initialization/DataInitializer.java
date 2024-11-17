package application.initialization;

import application.dto.external.AmazonResponseDto;
import application.repository.SalesAndTrafficByAsinRepository;
import application.repository.SalesAndTrafficByDateRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final SalesAndTrafficByAsinRepository salesAndTrafficByAsinRepository;
    private final SalesAndTrafficByDateRepository salesAndTrafficByDateRepository;
    private final ObjectMapper objectMapper;


    @Scheduled(cron = "0 0/30 * * * *")
    @Transactional
    public void updateMongoDb() {

        File file = new File("test_report.json");

        AmazonResponseDto amazonResponseDto = null;

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            amazonResponseDto = objectMapper.readValue(file, AmazonResponseDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        if (amazonResponseDto != null) {
            salesAndTrafficByAsinRepository.saveAll(amazonResponseDto.getSalesAndTrafficByAsinDtos());
            salesAndTrafficByDateRepository.saveAll(amazonResponseDto.getSalesAndTrafficByDateDtos());
        }
    }
}
