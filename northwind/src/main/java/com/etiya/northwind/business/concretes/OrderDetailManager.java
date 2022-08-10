package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailResponse;
import com.etiya.northwind.business.responses.orderDetails.ListOrderDetailResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailManager implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;
    private ModelMapperService modelMapperService;
    @Autowired
    public OrderDetailManager(OrderDetailRepository orderDetailRepository,ModelMapperService modelMapperService) {
        this.orderDetailRepository = orderDetailRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public void add(CreateOrderDetailRequest createOrderDetailRequest) {
        OrderDetail orderDetail = this.modelMapperService.forRequest().map(createOrderDetailRequest,OrderDetail.class);
        this.orderDetailRepository.save(orderDetail);
    }

    @Override
    public void delete(DeleteOrderDetailRequest deleteOrderDetailRequest) {
        OrderDetail orderDetail = this.modelMapperService.forRequest().map(deleteOrderDetailRequest,OrderDetail.class);
        this.orderDetailRepository.delete(orderDetail);
    }

    @Override
    public void update(UpdateOrderDetailRequest updateOrderDetailRequest) {
        OrderDetail orderDetail = this.modelMapperService.forRequest().map(updateOrderDetailRequest,OrderDetail.class);
        this.orderDetailRepository.save(orderDetail);
    }

    @Override
    public GetOrderDetailResponse getById(int orderId, int productId) {
         OrderDetail orderDetail = this.orderDetailRepository.getByOrder_OrderIdAndProduct_ProductId(orderId,productId);
         GetOrderDetailResponse response = this.modelMapperService.forResponse().map(orderDetail,GetOrderDetailResponse.class);
         return response;
    }

    @Override
    public List<ListOrderDetailResponse> getAll() {
        List<OrderDetail> result = this.orderDetailRepository.findAll();
        List<ListOrderDetailResponse> response = result.stream().map(orderDetail ->this.modelMapperService.forResponse()
                .map(orderDetail,ListOrderDetailResponse.class)).collect(Collectors.toList());
        return response;
    }
}
