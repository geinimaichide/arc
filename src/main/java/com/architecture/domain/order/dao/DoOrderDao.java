package com.architecture.domain.order.dao;

import com.architecture.BaseSaveDao;
import com.architecture.domain.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("doOrderDao")
public class DoOrderDao implements BaseSaveDao<Order> {

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
