package com.agile.agiletest.service.impl;

import com.agile.agiletest.Result.Result;
import com.agile.agiletest.dao.OrderDao;
import com.agile.agiletest.dao.TripsDao;
import com.agile.agiletest.pojo.Order;
import com.agile.agiletest.pojo.OrderReturn;
import com.agile.agiletest.pojo.Person;
import com.agile.agiletest.pojo.Trips;
import com.agile.agiletest.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private TripsDao tripsDao;

    @Override
    public Result getOrder(String username) {
        Result result = new Result();
        Person person = new Person();
        List<OrderReturn> orderReturnList  = new ArrayList<OrderReturn>();
        Trips trips = new Trips();

        //获取订单列表
        List<Order> orderdata= orderDao.getOrder(username);

        if(orderdata!=null){

            for(Order i:orderdata) {
                if (i.getStatus() == 0)
                    continue;
                OrderReturn orderReturn = new OrderReturn();
                person = orderDao.getPersoninf(i.getPersonId());
                trips = tripsDao.gettrips(i.getCarInfoId());
                orderReturn.setId(i.getId());
                orderReturn.setTrueName(person.getTrueName());
                orderReturn.setIdCardNum(person.getIdCardNum());
                orderReturn.setPhoneNum(person.getPhoneNum());
                orderReturn.setCarNum(trips.getCarNum());
                orderReturn.setDestinationLocation(trips.getDestinationLocation());
                orderReturn.setOrginLocation(trips.getOrginLocation());
                orderReturn.setTicketPrice(trips.getTicketPrice());
                orderReturn.setTicketNum(trips.getTicketNum());
                orderReturn.setStartTime(trips.getStartTime());
                orderReturn.setReachTime(trips.getReachTime());
                orderReturn.setChangeTimes(i.getChangeTimes());
                orderReturn.setSeat(i.getSeat());
                if (i.getStatus() == 1) {
                    orderReturn.setStatus("已支付");
                } else if (i.getStatus() == 2) {
                    orderReturn.setStatus("已退票");
                } else {
                    orderReturn.setStatus("已改签");
                }
//                orderReturn.setStartTime(orderReturn.getStartTime());
//                orderReturn.setStartTime(trips.getStartTime());
                orderReturnList.add(orderReturn);

            }
            result.setStateCode(200);
            result.setMsg("Query succeed");
            result.setData(orderReturnList);
        }
        else{
//            result.setStateCode();
            result.setStateCode(404);
            result.setData(false);
            result.setMsg("Query failed,no order");
        }
        return result;
    }

    @Override
    public Result changeOrder(int orderId, int tripsId) {
        Result result = new Result();
        Order order = orderDao.getAimOrder(orderId);
        Trips trips = tripsDao.gettrips(tripsId);
        if (order.getCarInfoId() == tripsId) {
            result.setMsg("请不要改签同一张票");
            result.setStateCode(404);
            return result;
        }
        if (trips.getTicketNum() > 0) {
            tripsDao.changeOldtrips(order.getCarInfoId());
            tripsDao.changeNewtrips(tripsId);
            orderDao.changeOrder(orderId, tripsId);
            result.setStateCode(200);
            result.setMsg("change order succeed");
        } else {
            result.setStateCode(404);
            result.setMsg("change order failed");
        }
        return result;
    }
}
