package com.agile.agiletest.controller;

import com.agile.agiletest.Result.Result;
import com.agile.agiletest.config.data.DataSource;
import com.agile.agiletest.config.data.DataSourceNames;
import com.agile.agiletest.config.mq.MQSender;
import com.agile.agiletest.dao.TripsDao;
import com.agile.agiletest.dao.UserDao;
import com.agile.agiletest.pojo.Message;
import com.agile.agiletest.service.TripsService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TicketController {

    @Autowired
    private MQSender mqSender;

    @Autowired
    private TripsService tripsService;

    @Autowired
    private TripsDao tripsDao;

    @Autowired
    private UserDao userDao;

    /**
     * 预定车票
     * @param data
     * @return
     */
    @PostMapping("/buyticket")
    @DataSource(DataSourceNames.ONE)
    public Result buyTicket(@RequestBody JSONObject data) {
        //获取前端传来的数据
        String username = data.getString("username");
        String carNum = data.getString("carNum");
        String startTime = data.getString("startTime");
        int seat = data.getInteger("seat");
        Result result = new Result();
        Message message = new Message(username, carNum, startTime, seat);
        mqSender.sendMessage(new Message(message.getUsername(), message.getCarNum(), message.getStartTime(), message.getSeat()));
        result.setStateCode(200);
        return result;
    }


    /**
     *退票
     * @param data
     * @return
     */
    @PostMapping("/ticketrefund")
    @DataSource(DataSourceNames.ONE)
    public Result ticketRefund(@RequestBody JSONObject data){
//       获取这三个信息进行订单查询 personId  carNum  orginLocation  destinationLocation
//        int personId = 0;
        String username = data.getString("username");
        int personId = userDao.getUserByUsername(username).getPersonId();
        String carNum = data.getString("carNum");
        String startTime = data.getString("startTime");
        String reachTime = data.getString("reachTime");
        Result result = tripsService.ticketRetund(personId, carNum, startTime, reachTime);
        return result;
    }

    @PostMapping("/paymoney")
    @DataSource(DataSourceNames.ONE)
    public Result payMoney(@RequestBody JSONObject data){
        int orderId = data.getInteger("orderId");
        return tripsService.payMoney(orderId);
    }
}
