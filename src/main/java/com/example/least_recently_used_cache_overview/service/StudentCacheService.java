package com.example.least_recently_used_cache_overview.service;

import com.example.least_recently_used_cache_overview.model.StudentCacheData;
import java.util.LinkedList;
import java.util.List;

public class StudentCacheService {

    static List<StudentCacheData> cacheData = new LinkedList<>();
    public static final int CAPACITY = 4;

    /**
     * To add data to cache given dataKey and dataDetails
     * @param dataKey
     * @param dataDetails
     * @return
     */
    public String addData( String dataKey, String dataDetails) {
        StudentCacheData studentCacheData = new StudentCacheData(dataKey, dataDetails);
        // add element at end
        addData(studentCacheData);
        return "done";
    }

    /***
     * To add data to cache given studentCacheData
     * @param studentCacheData
     */
    private static void addData(StudentCacheData studentCacheData) {
        // if CAPACITY is reached remove element from beginning
        if(cacheData.size() == CAPACITY) {
            System.out.println("cache is full. So removing data");
            System.out.println("before removing, data:"+cacheData);
            cacheData.remove(0);
            System.out.println("after removing, data:"+cacheData);
        }
        // add element at end
        cacheData.add(studentCacheData);
        System.out.println("after adding, data:"+cacheData);
    }

    /**
     * To retrive data from cache for given dataKey
     * @param dataKey
     * @return
     */
    public String getData(String dataKey) {
        System.out.println("before getting data:"+cacheData);
        boolean present = cacheData.stream().anyMatch(m -> m.getDataKey().equals(dataKey));
        if(!present) {
            System.out.println("Data not present in cache, reading from DB");
            // check actual DB for data, put in cache and return
            String dataDesc = "data from DB";
            StudentCacheData studentCacheData = new StudentCacheData(dataKey, dataDesc);
            System.out.println("read data from DB...");
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
