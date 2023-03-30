package com.example.ceserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestController
 * @Author
 * @Date 2023/3/29 23:03
 **/
@RestController
public class TestController {
    @RequestMapping("/test")
    public ResponseEntity<List<String>>  test() {
        List<String> objects = new ArrayList<>();
        objects.add("Hello World");
        objects.add("ni hao ");
        return ResponseEntity.ok(objects);
    }
}
