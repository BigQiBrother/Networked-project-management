package com.agile.agiletest.service;
import com.agile.agiletest.Result.Result;
import com.agile.agiletest.pojo.Trips;


public interface TripsService {
    /**
     * 查询所有车票信息
     *
     * @param trips
     * @return
     */
    Result getAlltrips(Trips trips);

    /**
     * 查询目标车票信息
     *
     * @param trips
     * @return
     */
    Result getAimtrips(Trips trips);


    /**
     * 购买车票
     *
     * @param username
     * @param carInfoId
     * @param carNum
     * @return
     */
    Result buyTicket(String username, int carInfoId, String carNum, int seat);

    /**
     * 退票
     *
     * @param personId
     * @param carNum
     * @param reachTime
     * @param startTime
     * @return
     */
    Result ticketRetund(int personId, String carNum, String startTime, String reachTime);

    /**
     * 付钱
     *
     * @param orderId
     * @return
     */
    Result payMoney(int orderId, Trips trips);

}
