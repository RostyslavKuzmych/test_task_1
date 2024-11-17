package application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "sales_and_traffic_by_asin")
public class SalesAndTrafficByAsinEntity {

    @Id
    private String parentAsin;

    @Field(name = "sales_by_asin")
    private SalesByAsinEntity salesByAsin;

    @Field(value = "traffic_by_asin_id")
    private TrafficByAsinEntity trafficByAsin;

}
