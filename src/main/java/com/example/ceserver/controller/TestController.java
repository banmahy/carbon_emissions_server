package com.example.ceserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping("/test")
    public ResponseEntity<List<String>> test() {
        List<String> objects = new ArrayList<>();
        objects.add("Hello World");
        objects.add("ni hao ");
        return ResponseEntity.ok(objects);
    }
}
