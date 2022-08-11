package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.GetOrderResponse;
import com.etiya.northwind.business.responses.orders.ListOrderResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Result add(@RequestBody @Valid CreateOrderRequest createOrderRequest) {
        return this.orderService.add(createOrderRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteOrderRequest deleteOrderRequest) {
        return this.orderService.delete(deleteOrderRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateOrderRequest updateOrderRequest) {
        return this.orderService.update(updateOrderRequest);
    }

    @GetMapping("/getbyid")
    public DataResult <GetOrderResponse >getById(@RequestParam int id) {
        return this.orderService.getById(id);
    }

    @GetMapping("/getall")
    public DataResult<List<ListOrderResponse>>getAll() {
        return this.orderService.getAll();
    }

}
