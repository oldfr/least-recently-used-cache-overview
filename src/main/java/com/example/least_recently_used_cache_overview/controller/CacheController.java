package com.example.least_recently_used_cache_overview.controller;

import com.example.least_recently_used_cache_overview.service.StudentCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CacheController {

    @Autowired
    StudentCacheService dataService;

    @GetMapping("/addData")
    public String addData(@RequestParam("data") String dataKey, @RequestParam("dataDetail") String dataDetail) {
        System.out.println("calling service layer");
        return dataService.addData(dataKey, dataDetail);
    }

    @GetMapping("/deleteData")
    public String deleteData(@RequestParam String data) {

        return "done";
    }

    @GetMapping("/getData")
    public String getData(@RequestParam("dataKey") String dataKey) {
        System.out.println("calling service layer to get read from cache");
        return dataService.getData(dataKey);
    }
}
