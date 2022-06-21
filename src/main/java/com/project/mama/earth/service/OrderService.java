package com.project.mama.earth.service;

import com.project.mama.earth.dto.CartDto;
import com.project.mama.earth.model.Order;
import com.project.mama.earth.model.OrderedItems;
import com.project.mama.earth.repository.OrderRepository;
import com.project.mama.earth.repository.OrderedItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderedItemsRepository orderedItemsRepository;

    public void createOrder(List<CartDto> cartItems) {
        Order order = new Order();
        long orderId = order.getId();
        long price = 0;
        for(CartDto cartItem : cartItems ) {
            OrderedItems orderedItem = new OrderedItems(cartItem);
            orderedItem.setOrderId(orderId);
            orderedItemsRepository.save(orderedItem);
            price+=cartItem.getPrice();
        }
        order.setTotalPrice(price);
        order.setCreatedDate(new Date());

    }

    public List<OrderedItems> getAllOrders(String username) {
        return orderedItemsRepository.findByUsernameGroupByOrderId(username).get();
    }

}
