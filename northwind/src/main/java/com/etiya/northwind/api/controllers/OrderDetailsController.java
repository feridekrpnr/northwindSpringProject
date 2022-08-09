package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.ListOrderDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {
    private OrderDetailService orderDetailService;
    @Autowired
    public OrderDetailsController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateOrderDetailRequest createOrderDetailRequest) {
        this.orderDetailService.add(createOrderDetailRequest);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteOrderDetailRequest deleteOrderDetailRequest) {
        this.orderDetailService.delete(deleteOrderDetailRequest);
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateOrderDetailRequest updateOrderDetailRequest) {
        this.orderDetailService.update(updateOrderDetailRequest);
    }

    @GetMapping("/getById")
    public GetOrderDetailResponse getById(int orderId, int productId) {
        return this.orderDetailService.getById(orderId,productId);
    }

    @GetMapping("/getAll")
    public List<ListOrderDetailResponse> getAll() {
        return this.orderDetailService.getAll();
    }
}
