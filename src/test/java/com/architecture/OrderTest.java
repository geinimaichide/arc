package com.architecture;

import com.architecture.domain.order.domain.Order;
import com.architecture.three.product.model.Product;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class OrderTest {
    @Test
    public void should_test_order() {
        Order order = new Order(new Product(1, 100d), 1);
        assertThat(new Order(new Product(1, 100d), 1), is(order));
        assertThat(Order.save(new Product(1, 100d), 1), is(order));
    }
}
