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
public class SalesByDateEntity {

    @Field(value = "ordered_product_sales_id")
    private OrderedProductSalesEntity orderedProductSales;

    @Field(value = "ordered_product_sales_b2b_id")
    private OrderedProductSalesB2BEntity orderedProductSalesB2B;

    @Field(value = "units_ordered")
    private Integer unitsOrdered;

    @Field(value = "units_ordered_b2b")
    private Integer unitsOrderedB2B;

    @Field(value = "total_order_items")
    private Integer totalOrderItems;

    @Field(value = "total_order_items_b2b")
    private Integer totalOrderItemsB2B;

    @Field(value = "average_sales_per_order_item_id")
    private AverageSalesPerOrderItemEntity averageSalesPerOrderItem;

    @Field(value = "average_sales_per_order_item_b2b_id")
    private AverageSalesPerOrderItemB2BEntity averageSalesPerOrderItemB2B;

    @Field(value = "average_units_per_order_item")
    private Double averageUnitsPerOrderItem;

    @Field(value = "average_units_per_order_item_b2b")
    private Double averageUnitsPerOrderItemB2B;

    @Field(value = "average_selling_price_id")
    private AverageSellingPriceEntity averageSellingPrice;

    @Field(value = "average_selling_price_b2b_id")
    private AverageSellingPriceB2BEntity averageSellingPriceB2B;

    @Field(value = "units_refunded")
    private Integer unitsRefunded;

    @Field(value = "refund_rate")
    private Double refundRate;

    @Field(value = "claims_granted")
    private Integer claimsGranted;

    @Field(value = "claims_amount_id")
    private ClaimsAmountEntity claimsAmount;

    @Field(value = "shipped_product_sales_id")
    private ShippedProductSalesEntity shippedProductSales;

    @Field(value = "units_shipped")
    private Integer unitsShipped;

    @Field(value = "orders_shipped")
    private Integer ordersShipped;

}
