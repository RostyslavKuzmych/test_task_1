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
public class TrafficByAsinEntity {

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

    @Field(value = "browser_session_percentage")
    private Double browserSessionPercentage;

    @Field(value = "browser_session_percentage_b2b")
    private Double browserSessionPercentageB2B;

    @Field(value = "mobile_app_session_percentage")
    private Double mobileAppSessionPercentage;

    @Field(value = "mobile_app_session_percentage_b2b")
    private Double mobileAppSessionPercentageB2B;

    @Field(value = "session_percentage")
    private Double sessionPercentage;

    @Field(value = "session_percentage_b2b")
    private Double sessionPercentageB2B;

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

    @Field(value = "browser_page_views_percentage")
    private Double browserPageViewsPercentage;

    @Field(value = "browser_page_views_percentage_b2b")
    private Double browserPageViewsPercentageB2B;

    @Field(value = "mobile_app_page_views_percentage")
    private Double mobileAppPageViewsPercentage;

    @Field(value = "mobile_app_page_views_percentage_b2b")
    private Double mobileAppPageViewsPercentageB2B;

    @Field(value = "page_views_percentage")
    private Double pageViewsPercentage;

    @Field(value = "page_views_percentage_b2b")
    private Double pageViewsPercentageB2B;

    @Field(value = "buy_box_percentage")
    private Double buyBoxPercentage;

    @Field(value = "buy_box_percentage_b2b")
    private Double buyBoxPercentageB2B;

    @Field(value = "unit_session_percentage")
    private Double unitSessionPercentage;

    @Field(value = "unit_session_percentage_b2b")
    private Double unitSessionPercentageB2B;

}
