package com.Ecom.orderservice.controller;

import com.Ecom.orderservice.dto.OrderRequest;
import com.Ecom.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
public class OrderController {

    // setter DI
    @Autowired
    private OrderService orderService;

    @PostMapping("place")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest order) {
        orderService.placeOrder(order);
        return "order placed successfully";
    }
}
