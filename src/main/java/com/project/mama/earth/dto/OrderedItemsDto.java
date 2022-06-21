package com.project.mama.earth.dto;

import com.project.mama.earth.model.OrderedItems;

public class OrderedItemsDto {
    private Long orderId;
    private String productName;
    private Integer quantity;
    private Long price;

    public OrderedItemsDto(OrderedItems orderedItems) {
        this.orderId = orderedItems.getOrderId();
        this.productName = orderedItems.getProductName();
        this.quantity = orderedItems.getQuantity();
        this.price = orderedItems.getPrice();
    }
}
