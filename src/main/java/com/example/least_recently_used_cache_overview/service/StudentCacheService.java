package com.example.least_recently_used_cache_overview.service;

import com.example.least_recently_used_cache_overview.model.StudentCacheData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StudentCacheService {

    static List<StudentCacheData> cacheData = new LinkedList<>();
    public static final int CAPACITY = 4;

    public String addData( String dataKey, String dataDetails) {
        StudentCacheData studentCacheData = new StudentCacheData(dataKey, dataDetails); // time is not needed remove it
        addData(studentCacheData);
        // add element at end
        return "done";
    }

    private static void addData(StudentCacheData studentCacheData) {
        // if CAPACITY is reached remove element from beginning
        if(cacheData.size() == CAPACITY) {
            System.out.println("before removing, data:"+cacheData);
            cacheData.remove(0);
            System.out.println("after removing, data:"+cacheData);
        }
        cacheData.add(studentCacheData);
        System.out.println("after adding, data:"+cacheData);
    }

    public String deleteData( String data) {
        
        return "done";
    }

    public String getData(String dataKey) {
        System.out.println("before getting data:"+cacheData);
        boolean present = cacheData.stream().anyMatch(m -> m.getDataKey().equals(dataKey));
        if(!present) {
            System.out.println("not present in cache, reading from DB");
            // check actual DB for data, put in cache and return
            String dataDesc = "data from DB";
            StudentCacheData studentCacheData = new StudentCacheData(dataKey, dataDesc);
            addData(studentCacheData);
            return dataDesc;
        }
        // if present, remove existing and add in end
        StudentCacheData studentCacheData = cacheData.stream().filter(m -> m.getDataKey().equals(dataKey)).findAny().get();
        System.out.println("removed existing data:"+cacheData);
        cacheData.remove(studentCacheData);
        cacheData.add(studentCacheData);
        System.out.println("added data:"+cacheData);

        return studentCacheData.getDataDetails();
    }
}
