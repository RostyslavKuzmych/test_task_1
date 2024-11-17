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
public class TrafficByDateEntity {

    @Field(value = "browser_page_views")
    private Integer browserPageViews;

    @Field(value = "browser_page_views_b2b")
    private Integer browserPageViewsB2B;

    @Field(value = "mobile_app_page_views")
    private Integer mobileAppPageViews;

    @Field(value = "mobile_app_page_views_b2b")
    private Integer mobileAppPageViewsB2B;

    @Field(value = "page_views")
    private Integer pageViews;

    @Field(value = "page_views_b2b")
    private Integer pageViewsB2B;

    @Field(value = "browser_sessions")
    private Integer browserSessions;

    @Field(value = "browser_sessions_b2b")
    private Integer browserSessionsB2B;

    @Field(value = "mobile_app_sessions")
    private Integer mobileAppSessions;

    @Field(value = "mobile_app_sessions_b2b")
    private Integer mobileAppSessionsB2B;

    @Field(value = "sessions")
    private Integer sessions;

    @Field(value = "sessions_b2b")
    private Integer sessionsB2B;

    @Field(value = "buy_box_percentage")
    private Double buyBoxPercentage;

    @Field(value = "buy_box_percentage_b2b")
    private Double buyBoxPercentageB2B;

    @Field(value = "order_item_session_percentage")
    private Double orderItemSessionPercentage;

    @Field(value = "order_item_session_percentage_b2b")
    private Double orderItemSessionPercentageB2B;

    @Field(value = "unit_session_percentage")
    private Double unitSessionPercentage;

    @Field(value = "unit_session_percentage_b2b")
    private Double unitSessionPercentageB2B;

    @Field(value = "average_offer_count")
    private Integer averageOfferCount;

    @Field(value = "average_parent_items")
    private Integer averageParentItems;

    @Field(value = "feedback_received")
    private Integer feedbackReceived;

    @Field(value = "negative_feedback_received")
    private Integer negativeFeedbackReceived;

    @Field(value = "received_negative_feedback_rate")
    private Double receivedNegativeFeedbackRate;

}
