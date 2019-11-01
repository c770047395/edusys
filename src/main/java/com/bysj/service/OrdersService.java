package com.bysj.service;

import com.bysj.pojo.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> queryAllOrders();
    Orders queryOrdersById(int id);
    List<Orders> queryOrdersByUserId(int userId);
    List<Orders> queryOrdersByTeacherId(int teacherId);
    int addOrders(Orders orders);
    int updateOrders(Orders orders);
    int deleteOrders(int id);
    int changeStatus(int id , int status);
    int viewOrders(int id);
    int postOrders(int id,int teacher_id);
}
