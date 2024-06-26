package com.example.demo.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    public CacheManager cacheManager (){
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("Nanna Cache");
        cacheManager.setCaffeine(cacheBuilder());
        return cacheManager;
    }

    private Caffeine<Object, Object> cacheBuilder() {
        return Caffeine.newBuilder()
            .initialCapacity(100)
            .maximumSize(500)
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .recordStats();
    }
}
