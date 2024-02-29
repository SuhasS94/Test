package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.users.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Service1 {

    @Autowired
    private User user;

    @Value("${data.spring}")
    String person;

    public void meathod(){
        log.info(person);
    }

}
