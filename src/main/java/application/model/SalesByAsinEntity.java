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
public class SalesByAsinEntity {

    @Field(value = "units_ordered")
    private Integer unitsOrdered;

    @Field(value = "units_ordered_b2b")
    private Integer unitsOrderedB2B;

    @Field(value = "ordered_product_sales_id")
    private OrderedProductSalesEntity orderedProductSales;

    @Field(value = "ordered_product_sales_b2b_id")
    private OrderedProductSalesB2BEntity orderedProductSalesB2B;

    @Field(value = "total_order_items")
    private Integer totalOrderItems;

    @Field(value = "total_order_items_b2b")
    private Integer totalOrderItemsB2B;

}
