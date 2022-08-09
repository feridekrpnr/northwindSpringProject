package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.GetOrderResponse;
import com.etiya.northwind.business.responses.orders.ListOrderResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderManager implements OrderService {

    private OrderRepository orderRepository;


    private ModelMapperService modelMapperService;
    @Autowired
    public OrderManager(OrderRepository orderRepository,ModelMapperService modelMapperService) {
        this.orderRepository = orderRepository;

        this.modelMapperService = modelMapperService;

    }

    @Override
    public void add(CreateOrderRequest createOrderRequest) {
         Order order = this.modelMapperService.forRequest().map(createOrderRequest,Order.class);
         this.orderRepository.save(order);
    }

    @Override
    public void delete(DeleteOrderRequest deleteOrderRequest) {
        Order order = this.modelMapperService.forRequest().map(deleteOrderRequest,Order.class);
        this.orderRepository.delete(order);
    }

    @Override
    public void update(UpdateOrderRequest updateOrderRequest) {
        Order order = this.modelMapperService.forRequest().map(updateOrderRequest,Order.class);
        this.orderRepository.save(order);
    }

    @Override
    public GetOrderResponse getById(int id) {
        Order order = this.orderRepository.findById(id);
        GetOrderResponse response = this.modelMapperService.forResponse().map(order,GetOrderResponse.class);
        return response;
    }

    @Override
        public List<ListOrderResponse> getAll() {
            List<Order> result = orderRepository.findAll();
            List<ListOrderResponse> response = result.stream().map(order -> this.modelMapperService.forResponse()
                    .map(order,ListOrderResponse.class)).collect(Collectors.toList());
            for(int i = 0; i <response.size(); i++) {
                response.get(i).setFullName(result.get(i).getEmployee().getFirstName()+ " " + result.get(i).getEmployee().getLastName());
            }
            return response;
        }
}
