package com.agile.agiletest.config.mq;

import com.agile.agiletest.Result.Result;
import com.agile.agiletest.dao.TripsDao;
import com.agile.agiletest.pojo.Order;
import com.agile.agiletest.pojo.Trips;
import com.agile.agiletest.pojo.myMessage;
import com.agile.agiletest.service.TripsService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = MQConstants.BUY)
public class MQReceiver {
    @Autowired
    private TripsService tripsService;

    @Autowired
    private TripsDao tripsDao;

    @RabbitHandler
    public void process(myMessage message) {
        System.out.println(message.getCarNum() + " " + message.getStartTime());
        Trips trips = tripsDao.getTripsInfoByCarNumAndStartTime(message.getCarNum(), message.getStartTime());
        System.out.println(trips);
        int carInfoId = trips.getId();
        //        int carInfoId  = data.getInteger("id");
        //进入购票service
        Result result = tripsService.buyTicket(message.getUsername(), carInfoId, message.getCarNum(), message.getSeat());
        Order order = (Order) ((Map<String, Object>) result.getData()).get("order");
        tripsService.payMoney(order.getId());
    }
}
