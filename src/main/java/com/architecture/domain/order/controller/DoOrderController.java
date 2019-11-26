package com.architecture.domain.order.controller;

import com.architecture.domain.order.dao.DoOrderDao;
import com.architecture.domain.order.domain.Order;
import com.architecture.domain.order.service.DoOrderService;
import com.architecture.three.product.dao.interfaces.ProductDao;
import com.architecture.three.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/do/order")
public class DoOrderController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private DoOrderDao doOrderDao;

    @Autowired
    private DoOrderService doOrderService;

    @PostMapping
    public void save(@RequestBody @Valid CreateOrderCommand command) {
        Product product = productDao.getById(command.getProId());
        Order order = Order.save(product, command.getNumber());
        doOrderDao.save(order);
    }

    @PostMapping("/1")
    public void save1(@RequestBody @Valid CreateOrderCommand command) {
        doOrderService.save(command);
    }
}
