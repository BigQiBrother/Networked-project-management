package com.agile.agiletest.controller;


import com.agile.agiletest.Result.Result;
import com.agile.agiletest.config.data.DataSource;
import com.agile.agiletest.config.data.DataSourceNames;
import com.agile.agiletest.service.OrderService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     *get all order
     * @author 41688
     * @return
     * */
    @PostMapping("/getorder")
    @DataSource(DataSourceNames.TWO)
    public Result getOrder(@RequestBody JSONObject jsonObject){
        String username = jsonObject.getString("username");

        Result result = orderService.getOrder(username);
        return result;
    }

    /**
     * change order
     * @author 41688
     * @return
     * */
    @PostMapping("/changeorder")
    @DataSource(DataSourceNames.ONE)
    public Result changeOrder(@RequestBody JSONObject jsonObject){
        int orderid = jsonObject.getInteger("orderId");
        int tripsid = jsonObject.getInteger("tripsId");
        Result result = orderService.changeOrder(orderid,tripsid);
        return result;
    }
}
