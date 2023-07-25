package com.imranmadbar;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Cacheable(cacheNames = "myCache")
    public String getCachedData() {
		System.out.println("Calling......getCachedData");
        return "Cached data";
    }
}