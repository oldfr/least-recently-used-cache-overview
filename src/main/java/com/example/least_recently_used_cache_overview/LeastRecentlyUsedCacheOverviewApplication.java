package com.example.least_recently_used_cache_overview;

import com.example.least_recently_used_cache_overview.model.StudentCacheData;
import com.example.least_recently_used_cache_overview.service.StudentCacheService;
import java.util.Arrays;
import java.util.List;

public class LeastRecentlyUsedCacheOverviewApplication {

	public static void main(String[] args) {

		StudentCacheData data1 = new StudentCacheData("a","descA");
		StudentCacheData data2 = new StudentCacheData("b","descB");
		StudentCacheData data3 = new StudentCacheData("c","descC");
		StudentCacheData data4 = new StudentCacheData("d","descD");
		StudentCacheData data5 = new StudentCacheData("e","descE");

		List<StudentCacheData> dataList = Arrays.asList(data1, data2, data3, data4, data5);

		StudentCacheService service = new StudentCacheService();
		System.out.println("getting data from cache =========> \n");
		for(int i=0;i<5;i++) {
			service.addData(dataList.get(i).getDataKey(), dataList.get(i).getDataDetails());
		}

		System.out.println("reading data from cache =========> \n");
		service.getData("a");
	}

}
