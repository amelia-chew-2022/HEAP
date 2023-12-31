package com.heap.backend.repository;

import com.heap.backend.models.menu.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface MenuRepository extends MongoRepository<Menu, String> {

    Optional<Menu> findByUserIdAndName(String userId, String name);

    Optional<Menu> findByIdAndUserId(String id, String userId);

    List<Menu> findAllByUserIdOrderByCreateDateTimeDesc(String userId);

    void deleteByUserIdAndId(String userId, String id);
}
