package com.architecture.three.order.service.interfaces;

import com.architecture.three.order.model.Order;
import com.architecture.three.product.model.Product;

public interface OrderService {
    
    void save(Order order);

    void save(String id, int number);

    void save(Product product, int number);
}
