package com.heap.backend.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("flyerDistributionMarketingPlan")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FlyerDistributionMarketingPlan implements BusinessGrowthPlan {

    //Common Fields
    @Id
    private String id;
    @NotBlank
    private String userId;
    @NotBlank
    private String planName;
    @NotBlank
    private String startDate;
    @NotBlank
    private String endDate;
    @NotBlank
    private int priority;
    @NotBlank
    private String planType;

    //Common to all MarketingPlan
    private String method;
    private String promotionName;
    private String promoStartDate;
    private String promoEndDate;
    private String promoDescription;
    private String promoTnC;
    private Influencer[] influencer;

    //Unique to this FlyerDistributionMarketingPlan
    private String flyerDesign;
    private double flyerCost;
    private double flyerQuantity;

}
