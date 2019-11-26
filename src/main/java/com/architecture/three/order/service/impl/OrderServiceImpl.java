package com.architecture.three.order.service.impl;

import com.architecture.three.order.dao.interfaces.OrderDao;
import com.architecture.three.order.model.Order;
import com.architecture.three.order.service.interfaces.OrderService;
import com.architecture.three.product.model.Product;
import com.architecture.three.product.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Autowired
    private ProductService productService;

    
    @Override
    public void save(String id, int number) {
        Product product = productService.getById(id);
        if (product == null) {
            throw new IllegalArgumentException("product id is illegal");
        }
        String no = String.valueOf(Instant.now().toEpochMilli());
        Order order = new Order(no, product.getPrice() * number, number);
        orderDao.save(order);
    }

    public void save(double price, int number){
        String no = String.valueOf(Instant.now().toEpochMilli());
        Order order = new Order(no, price*number, number);
        orderDao.save(order);
    }
    

    @Override
    public void save(Product product, int number) {
        String no = String.valueOf(Instant.now().toEpochMilli());
        Order order = new Order(no, product.getPrice() * number, number);
        orderDao.save(order);
    }
}
