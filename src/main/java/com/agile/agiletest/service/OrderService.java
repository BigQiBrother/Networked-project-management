package com.agile.agiletest.service;


import com.agile.agiletest.Result.Result;


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
