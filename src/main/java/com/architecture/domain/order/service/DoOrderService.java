package com.architecture.domain.order.service;

import com.architecture.domain.order.controller.CreateOrderCommand;
import com.architecture.domain.order.dao.DoOrderDao;
import com.architecture.domain.order.domain.Order;
import com.architecture.three.product.dao.interfaces.ProductDao;
import com.architecture.three.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DoOrderService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private DoOrderDao doOrderDao;

    @Transactional
    public void save(CreateOrderCommand command){
        Product product = productDao.getById(command.getProId());
        Order order = Order.save(product, command.getNumber());
        doOrderDao.save(order);
    }

}
