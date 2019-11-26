package com.architecture.three.product.service.impl;

import com.architecture.three.product.dao.interfaces.ProductDao;
import com.architecture.three.product.model.Product;
import com.architecture.three.product.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product getById(String proId) {
        return productDao.getById(proId);
    }
}
