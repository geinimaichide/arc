package com.architecture.three.product.dao.interfaces;

import com.architecture.three.product.model.Product;

public interface ProductDao {
    Product getById(String proId);
}
