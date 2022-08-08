package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.responses.orders.ListOrderResponse;

import java.util.List;

public interface OrderService {

    List<ListOrderResponse> getAll();
}
