package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.ListOrderDetailResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
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
    public Result add(@RequestBody CreateOrderDetailRequest createOrderDetailRequest) {
        return this.orderDetailService.add(createOrderDetailRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteOrderDetailRequest deleteOrderDetailRequest) {
        return this.orderDetailService.delete(deleteOrderDetailRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateOrderDetailRequest updateOrderDetailRequest) {
        return this.orderDetailService.update(updateOrderDetailRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<GetOrderDetailResponse> getById(int orderId, int productId) {
        return this.orderDetailService.getById(orderId,productId);
    }

    @GetMapping("/getall")
    public DataResult<List<ListOrderDetailResponse>> getAll() {
        return this.orderDetailService.getAll();
    }
}
