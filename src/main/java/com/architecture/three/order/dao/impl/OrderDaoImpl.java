package com.architecture.three.order.dao.impl;

import com.architecture.three.order.dao.interfaces.OrderDao;
import com.architecture.three.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderDao")
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void save(Order order) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("insert into arc_t_order(no, totalPrice, number) values(?,?,?)");
        jdbcTemplate.update(stringBuffer.toString(), new  Object[]{order.getNo(), order.getTotalPrice(), order.getNumber()});
    }
}
