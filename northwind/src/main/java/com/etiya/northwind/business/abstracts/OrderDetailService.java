package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.responses.orderdetails.ListOrderDetailResponse;

import java.util.List;

public interface OrderDetailService {
    List<ListOrderDetailResponse> getAll();
}
