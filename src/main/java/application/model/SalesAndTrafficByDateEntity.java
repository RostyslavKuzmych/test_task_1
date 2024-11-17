package application.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "sales_and_traffic_by_date")
public class SalesAndTrafficByDateEntity {

    @Id
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Field(value = "date")
    private LocalDate date;

    @Field(value = "sales_by_date_id")
    private SalesByDateEntity salesByDate;

    @Field(value = "traffic_by_date_id")
    private TrafficByDateEntity trafficByDate;

}
