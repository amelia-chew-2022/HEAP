package com.heap.backend.data.request.business;

import com.heap.backend.models.business.fooddelivery.Container;
import com.heap.backend.models.business.marketing.common.Influencer;
import com.heap.backend.models.business.marketing.common.Promotion;
import com.heap.backend.models.business.marketing.flyerdistribution.Flyer;
import com.heap.backend.models.business.outletexpansion.Staff;
import com.heap.backend.models.business.marketing.posterbanner.PosterBanner;
import com.heap.backend.models.business.marketing.socialmedia.SocialMedia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBusinessGrowthPlanRequest {

    private String id;
    private String planName;
    private String startDate;
    private String endDate;
    private double budget;
    private int priority;
    private String planType;

    //1. Unique to FD (Food Delivery Marketplace Strategy)
    private String menuId;
    private Container[] containers;

    //2. Unique to MK (Marketing Strategy)
    private Promotion promotion;
    private String method;
    private Influencer[] influencer;
    //2.1. Unique to SocialMedia
    private SocialMedia socialMedia;
    //2.2. Unique to PosterBanner
    private PosterBanner posterBanner;
    //2.3. Unique to FlyerDistribution
    private Flyer flyer;

    //3. Unique to OutletExpansion
    private String address;
    private Staff[] staffs;
    private double rentalPrice;
    private double renovation;

}
