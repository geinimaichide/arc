package com.architecture;

import com.architecture.domain.order.controller.CreateOrderCommand;
import com.architecture.domain.order.dao.DoOrderDao;
import com.architecture.domain.order.domain.Order;
import com.architecture.domain.order.service.DoOrderService;
import com.architecture.three.product.model.Product;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class OrderTest extends TestCase {
    @Test
    public void should_test_order() {
        Order order = new Order(new Product(1, 100d), 1);
        assertThat(new Order(new Product(1, 100d), 1), is(order));
        assertThat(Order.save(new Product(1, 100d), 1), is(order));
    }
//    @Autowired
    @MockBean
    private DoOrderService doOrderService;

    @Test
    public void should_test() {
        doOrderService.save(new CreateOrderCommand("1", 2));
    }
}
