package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.responses.orderdetails.ListOrderDetailResponse;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailManager implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;
    @Autowired
    public OrderDetailManager(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<ListOrderDetailResponse> getAll() {
        List<OrderDetail> result = this.orderDetailRepository.findAll();
        List<ListOrderDetailResponse> response = new ArrayList<ListOrderDetailResponse>();
        for(OrderDetail orderDetail : result) {
            ListOrderDetailResponse listOrderDetailResponse = new ListOrderDetailResponse();
            listOrderDetailResponse.setOrderId(orderDetail.getOrder().getOrderId());
            listOrderDetailResponse.setProductId(orderDetail.getProduct().getProductId());
            listOrderDetailResponse.setDiscount(orderDetail.getDiscount());
            listOrderDetailResponse.setUnitPrice(orderDetail.getUnitPrice());
            listOrderDetailResponse.setQuantity(orderDetail.getQuantity());
            response.add(listOrderDetailResponse);
        }
        return response;
    }
}
