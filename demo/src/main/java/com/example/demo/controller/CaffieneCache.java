package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CaffieneCache implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CaffieneCache.class);

    @Autowired
    private UserService userService;

     public void run(String... args) throws Exception{
        log.info("Starting Cache testing..");
        System.out.println(userService.getUsers());

     }
}
