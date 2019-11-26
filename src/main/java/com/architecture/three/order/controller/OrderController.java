package com.architecture.three.order.controller;

import com.architecture.three.order.model.Order;
import com.architecture.three.order.service.interfaces.OrderService;
import com.architecture.three.product.model.Product;
import com.architecture.three.product.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    // mode 1，业务在 controller
    @PostMapping("/{proId}")
    public void save(@PathVariable String proId, @RequestParam(name = "number") int number) {
        Product product = productService.getById(proId);
        if (product == null) {
            throw new IllegalArgumentException("product id is illegal");
        }
        String no = String.valueOf(Instant.now().toEpochMilli());
        Order order = new Order(no, product.getPrice() * number, number);
        orderService.save(order);
    }


    // mode 2，业务在 service
    @PostMapping("/2/{proId}")
    public void save2(@PathVariable String proId, @RequestParam(name = "number") int number) {
        orderService.save(proId, number);
    }

    // mode 3，业务分散在 controller 、 service

    @PostMapping("/3/{proId}")
    public void save3(@PathVariable String proId, @RequestParam(name = "number") int number) {
        Product product = productService.getById(proId);
        if (product == null) {
            throw new IllegalArgumentException("product id is illegal");
        }
        orderService.save(product, number);
    }
}
