package com.architecture.domain.order.domain;

import com.architecture.three.product.model.Product;
import lombok.Data;
import lombok.Getter;

import java.time.Instant;

@Data
public class Order {

    @Getter
    private String no;
    @Getter
    private double totalPrice;
    @Getter
    private int number;

    public Order(Product product, int aNumber) {
        this.no = no();
        this.totalPrice = totalPrice(product.getPrice(), aNumber);
        this.number = aNumber;
    }

    private String no() {
        return String.valueOf(Instant.now().getEpochSecond());
    }

    private double totalPrice(double price, int number) {
        return price * number;
    }

    public static Order save(Product product, int number) {
        if (isProduct(product)) {
            throw new IllegalArgumentException("product id is illegal");
        }
        return new Order(product, number);
    }

    private static boolean isProduct(Product product) {
        return product == null;
    }
    
}
