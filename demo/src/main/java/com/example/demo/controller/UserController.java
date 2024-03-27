package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.entity.DataResponse;
import com.example.demo.exception.HeaderNotFoundException;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//@Pointcut("execution(* com.example.demo.controller.*.*(..))")
@RestController
//@RequestMapping(path = "/hi")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<Student>> getUserData() {
        return userService.getUsers();
    }

    @PostMapping(path = "/post")
    //@ResponseBody
    public ResponseEntity<?> regUser(@RequestBody Student student){
        return userService.addUser(student);
    }

    @DeleteMapping(path = "/{name}")
    public ResponseEntity<?> deleteUser(@PathVariable String name){
        return userService.deleteUser(name);
    }

    @PutMapping(path = "/{id}")
    public String putUser(@PathVariable Long id, @RequestBody Student student){
        return userService.putUser(id, student);
    }
}