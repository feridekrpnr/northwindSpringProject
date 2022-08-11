package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.GetOrderResponse;
import com.etiya.northwind.business.responses.orders.ListOrderResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public interface OrderService {

    Result add(CreateOrderRequest createOrderRequest);

    Result delete(DeleteOrderRequest deleteOrderRequest);

    Result update(UpdateOrderRequest updateOrderRequest);

    DataResult<GetOrderResponse> getById(int id);
    DataResult<List<ListOrderResponse>> getAll();


}
