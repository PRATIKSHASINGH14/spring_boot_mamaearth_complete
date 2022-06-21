package com.project.mama.earth.controller;

import com.project.mama.earth.dto.CartDto;
import com.project.mama.earth.dto.OrderedItemsDto;
import com.project.mama.earth.model.OrderedItems;
import com.project.mama.earth.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(
        origins = {"http://localhost:4200/"},
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}
)
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity createOrder(@RequestBody List<CartDto> cartItems) {
        orderService.createOrder(cartItems);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<OrderedItemsDto>> getAllOrders(@RequestBody String username) {
        List<OrderedItemsDto> orderedItemsDto = new ArrayList<>();
        List<OrderedItems> orderedItems = orderService.getAllOrders(username);
        for(OrderedItems orderedItem: orderedItems) {
            OrderedItemsDto orderedItemDto = new OrderedItemsDto(orderedItem);
            orderedItemsDto.add(orderedItemDto);
        }
        return new ResponseEntity<>(orderedItemsDto, HttpStatus.OK);
    }
}
