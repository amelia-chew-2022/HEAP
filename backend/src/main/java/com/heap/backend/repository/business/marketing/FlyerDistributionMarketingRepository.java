package com.heap.backend.repository.business.marketing;

import com.heap.backend.models.business.marketing.flyerdistribution.FlyerDistributionMarketingPlan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FlyerDistributionMarketingRepository extends MongoRepository<FlyerDistributionMarketingPlan, String> {

  Optional<FlyerDistributionMarketingPlan> findByUserIdAndPlanName(String userId, String planName);

  Optional<FlyerDistributionMarketingPlan> findByIdAndUserId(String planId, String userId);

  List<FlyerDistributionMarketingPlan> findAllByUserId(String userId);

  void deleteByUserIdAndId(String id, String bgpId);
}