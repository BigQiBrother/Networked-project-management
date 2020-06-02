package com.agile.agiletest.controller;


import com.agile.agiletest.Result.Result;
import com.agile.agiletest.config.data.DataSource;
import com.agile.agiletest.config.data.DataSourceNames;
import com.agile.agiletest.pojo.Trips;
import com.agile.agiletest.service.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class TripsController {
    /**
     *
     */
    @Autowired
    private TripsService tripsService;

    @PostMapping("/getAimtrips")
    @ResponseBody
    @DataSource(DataSourceNames.TWO)
    public Result getAimtrips(@RequestBody Trips trips){
        Result result = tripsService.getAimtrips(trips);
        return result;
    }

    @PostMapping("/getalltrips")
    @ResponseBody
    @DataSource(DataSourceNames.TWO)
    public Result getAlltrips(@RequestBody Trips trips){
        Result result = tripsService.getAlltrips(trips);
        return result;
    }
}
