package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.ListOrderDetailResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public interface OrderDetailService {

    Result add(CreateOrderDetailRequest createOrderDetailRequest);

    Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest);

    Result update(UpdateOrderDetailRequest updateOrderDetailRequest);

    DataResult<GetOrderDetailResponse> getById(int orderId, int productId);
    DataResult<List<ListOrderDetailResponse>> getAll();
}
