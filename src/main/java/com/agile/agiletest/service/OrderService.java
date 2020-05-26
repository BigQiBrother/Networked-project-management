package com.agile.agiletest.service;


import com.agile.agiletest.Result.Result;

/**
 * 订单处理
 * @author 41688
 * @version 0.1
. * */
public interface OrderService {
    /**
     * @param username
     * @return
     */
    Result getOrder(String username);

    /**
     *订单改签
     */
    Result changeOrder(int orderId, int tripsId, int seat);
}
