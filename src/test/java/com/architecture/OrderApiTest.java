package com.architecture;

import com.architecture.domain.order.controller.CreateOrderCommand;
import com.architecture.domain.order.controller.DoOrderController;
import com.architecture.domain.order.service.DoOrderService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class OrderApiTest {

    @Autowired
    private DoOrderService doOrderService;
    
    @Before
    public void configured() {
        RestAssuredMockMvc.standaloneSetup(new DoOrderController(doOrderService));
    }
    
    @Test
    public void should_order_save() {
        RestAssuredMockMvc.given().contentType("application/json").body(new CreateOrderCommand("1", 20)).when().post("/do/order/1")
                .then().statusCode(200);
    }

}
