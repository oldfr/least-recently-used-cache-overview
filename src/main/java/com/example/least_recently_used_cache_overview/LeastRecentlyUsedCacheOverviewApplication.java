package com.example.least_recently_used_cache_overview;

import com.example.least_recently_used_cache_overview.model.StudentCacheData;
import com.example.least_recently_used_cache_overview.service.StudentCacheService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LeastRecentlyUsedCacheOverviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeastRecentlyUsedCacheOverviewApplication.class, args);

		StudentCacheData data1 = new StudentCacheData("a","descA");
		StudentCacheData data2 = new StudentCacheData("b","descB");
		StudentCacheData data3 = new StudentCacheData("c","descC");
		StudentCacheData data4 = new StudentCacheData("d","descD");
		StudentCacheData data5 = new StudentCacheData("e","descE");
		StudentCacheData data6 = new StudentCacheData("f","descF");

		List<StudentCacheData> dataList = Arrays.asList(data1, data2, data3, data4, data5, data6);

		StudentCacheService service = new StudentCacheService();
		System.out.println("adding data to cache =========> \n");
		for(int i=0;i<6;i++) {
			service.addData(dataList.get(i).getDataKey(), dataList.get(i).getDataDetails());
		}

		System.out.println("reading data from cache =========> \n");
		service.getData("c");

		System.out.println("\nreading data which is unavailable in cache =========> \n");
		service.getData("l");
	}

}
