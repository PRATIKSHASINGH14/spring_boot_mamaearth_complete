package com.project.mama.earth.repository;

import com.project.mama.earth.model.OrderedItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderedItemsRepository extends JpaRepository<OrderedItems,Long> {
    Optional<List<OrderedItems>> findByUsernameGroupByOrderId(String username);
}
