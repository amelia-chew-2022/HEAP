package com.heap.backend.repository;

import com.heap.backend.models.PosterAndBannerMarketingPlan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PosterAndBannerMarketingPlanRepository extends MongoRepository<PosterAndBannerMarketingPlan, String> {

  Optional<PosterAndBannerMarketingPlan> findByUserIdAndPlanName(String userId, String planName);

  Optional<PosterAndBannerMarketingPlan> findByIdAndUserId(String planId, String userId);

  List<PosterAndBannerMarketingPlan> findAllByUserId(String userId);

  void deleteByUserIdAndId(String id, String bgpId);
}