package com.agile.agiletest.config.mq;

import com.agile.agiletest.Result.Result;
import com.agile.agiletest.dao.TripsDao;
import com.agile.agiletest.pojo.Message;
import com.agile.agiletest.pojo.Order;
import com.agile.agiletest.pojo.Trips;
import com.agile.agiletest.service.TripsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MQReceiver {
    @Autowired
    private TripsService tripsService;

    @Autowired
    private TripsDao tripsDao;

    @RabbitListener(queues = MQConstants.BUY)
    public void receive(Message message) {
        Trips trips = tripsDao.getTripsInfoByCarNumAndStartTime(message.getCarNum(), message.getStartTime());
        int carInfoId = trips.getId();
        //        int carInfoId  = data.getInteger("id");
        //进入购票service
        Result result = tripsService.buyTicket(message.getUsername(), carInfoId, message.getCarNum());
        Order order = (Order) ((Map<String, Object>) result.getData()).get("order");
        tripsService.payMoney(order.getId());
    }
}
