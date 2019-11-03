package com.bysj.service;

import com.bysj.dao.OrdersMapper;
import com.bysj.pojo.Orders;
import com.bysj.pojo.Teacher;

import java.util.Date;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {
    private OrdersMapper ordersMapper;

    public void setOrdersMapper(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    public List<Orders> queryAllOrders() {
        return ordersMapper.queryAllOrders();
    }

    public Orders queryOrdersById(int id) {
        return ordersMapper.queryOrdersById(id);
    }

    public List<Orders> queryOrdersByUserId(int userId) {
        return ordersMapper.queryOrdersByUserId(userId);
    }

    public List<Orders> queryOrdersByTeacherId(int teacherId) {
        return ordersMapper.queryOrdersByTeacherId(teacherId);
    }

    public int addOrders(Orders orders) {
        orders.setPubTime(new Date());
        return ordersMapper.addOrders(orders);
    }


    public int updateOrders(Orders orders) {
        return ordersMapper.updateOrders(orders);
    }

    public int deleteOrders(int id) {
        return ordersMapper.deleteOrders(id);
    }

    public int changeStatus(int id, int status) {
        Orders orders = ordersMapper.queryOrdersById(id);
        orders.setStatus(status);
        return ordersMapper.updateOrders(orders);
    }

    public int viewOrders(int id) {
        Orders orders = ordersMapper.queryOrdersById(id);
        orders.setCheckNum(orders.getCheckNum()+1);
        return ordersMapper.updateOrders(orders);
    }

    public int postOrders(int id, int teacher_id) {
        Orders orders = ordersMapper.queryOrdersById(id);
        orders.setStatus(1);
        Teacher teacher = new Teacher();
        teacher.setId(teacher_id);
        orders.setTeacher(teacher);
        return updateOrders(orders);
    }
}
