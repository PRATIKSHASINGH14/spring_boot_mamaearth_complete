package com.project.mama.earth.service;

import com.project.mama.earth.repository.OrderedItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderedItemsService {
    @Autowired
    private OrderedItemsRepository orderedItemsRepository;
}
