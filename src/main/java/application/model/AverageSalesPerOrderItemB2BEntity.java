package application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AverageSalesPerOrderItemB2BEntity {

    @Field(value = "amount")
    private Double amount;

    @Field(value = "currency_code")
    private String currencyCode;

}
