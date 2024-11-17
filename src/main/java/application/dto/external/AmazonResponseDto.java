package application.dto.external;

import application.model.SalesAndTrafficByAsinEntity;
import application.model.SalesAndTrafficByDateEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.List;
import java.util.Set;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
@Accessors(chain = true)
public class AmazonResponseDto {

    @JsonProperty("salesAndTrafficByAsin")
    private Set<SalesAndTrafficByAsinEntity> salesAndTrafficByAsinDtos;

    @JsonProperty("salesAndTrafficByDate")
    private Set<SalesAndTrafficByDateEntity> salesAndTrafficByDateDtos;

}
