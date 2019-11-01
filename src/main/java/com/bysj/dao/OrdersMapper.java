package com.bysj.dao;

import com.bysj.pojo.Orders;

import java.util.List;

public interface OrdersMapper {

    List<Orders> queryAllOrders();
    Orders queryOrdersById(int id);
    List<Orders> queryOrdersByUserId(int userId);
    List<Orders> queryOrdersByTeacherId(int teacherId);
    int addOrders(Orders orders);
    int updateOrders(Orders orders);
    int deleteOrders(int id);

}
