package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.ListOrderDetailResponse;

import java.util.List;

public interface OrderDetailService {

    void add(CreateOrderDetailRequest createOrderDetailRequest);

    void delete(DeleteOrderDetailRequest deleteOrderDetailRequest);

    void update(UpdateOrderDetailRequest updateOrderDetailRequest);

    GetOrderDetailResponse getById(int orderId,int productId);
    List<ListOrderDetailResponse> getAll();
}
