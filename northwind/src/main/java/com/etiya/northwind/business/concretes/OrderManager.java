package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.responses.orders.ListOrderResponse;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Customer;
import com.etiya.northwind.entities.concretes.Employee;
import com.etiya.northwind.entities.concretes.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderManager implements OrderService {

    private OrderRepository orderRepository;
    private EmployeeRepository employeeRepository;
    private CustomerRepository customerRepository;
    @Autowired
    public OrderManager(OrderRepository orderRepository, EmployeeRepository employeeRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;

    }
        @Override
        public List<ListOrderResponse> getAll() {
            List<Order> result = orderRepository.findAll();
            List<Employee> employees = employeeRepository.findAll();
            List<Customer> customers = customerRepository.findAll();
            List<ListOrderResponse> response = new ArrayList<ListOrderResponse>();


            for (Order order : result) {
                ListOrderResponse listOrderResponse = new ListOrderResponse();
                listOrderResponse.setOrderId(order.getOrderId());
                listOrderResponse.setOrderDate(order.getOrderDate());
                listOrderResponse.setShipName(order.getShipName());
                Employee employee = new Employee();

                for (Employee item : employees) {
                    if (order.getEmployee().getEmployeeId() != employee.getEmployeeId()) {
                        employee.setEmployeeId(item.getEmployeeId());
                        employee.setBirthDate(item.getBirthDate());
                        employee.setFirstName(item.getFirstName());
                        employee.setLastName(item.getLastName());
                        listOrderResponse.setEmployee(employee);
                    }
                }
                Customer customer = new Customer();
                for (Customer item : customers) {
                    if (order.getCustomer().getCustomerId() != customer.getCustomerId()) {
                        customer.setCity(item.getCity());
                        customer.setCompanyName(item.getCompanyName());
                        customer.setContactName(item.getContactName());
                        customer.setCustomerId(item.getCustomerId());
                        listOrderResponse.setCustomer(customer);
                    }
                }

                response.add(listOrderResponse);
            }
            return response;
        }
}
