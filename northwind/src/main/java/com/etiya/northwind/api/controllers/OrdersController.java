package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.GetOrderResponse;
import com.etiya.northwind.business.responses.orders.ListOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private OrderService orderService;
    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateOrderRequest createOrderRequest) {
        this.orderService.add(createOrderRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteOrderRequest deleteOrderRequest) {
        this.orderService.delete(deleteOrderRequest);
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateOrderRequest updateOrderRequest) {
        this.orderService.update(updateOrderRequest);
    }

    @GetMapping("/getbyid")
    public GetOrderResponse getById(@RequestParam int id) {
        return this.orderService.getById(id);
    }

    @GetMapping("/getall")
    public List<ListOrderResponse> getAll() {
        return this.orderService.getAll();
    }

}
