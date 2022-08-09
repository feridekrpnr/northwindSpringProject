package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.GetOrderResponse;
import com.etiya.northwind.business.responses.orders.ListOrderResponse;

import java.util.List;

public interface OrderService {

    void add(CreateOrderRequest createOrderRequest);

    void delete(DeleteOrderRequest deleteOrderRequest);

    void update(UpdateOrderRequest updateOrderRequest);

    GetOrderResponse getById(int id);
    List<ListOrderResponse> getAll();


}
