package com.architecture.three.product.dao.impl;

import com.architecture.three.product.dao.interfaces.ProductDao;
import com.architecture.three.product.model.Product;
import org.springframework.stereotype.Service;

@Service("productDao")
public class ProductDaoImpl implements ProductDao {
    
    @Override
    public Product getById(String proId) {
        return new Product(1, 100d);
    }
}
