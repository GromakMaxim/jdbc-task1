package com.example.demo.controller;

import com.example.demo.service.DBService;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private DBService DBService;

    public Controller(DBService DBService) {
        this.DBService = DBService;
    }

    @GetMapping("/products/fetch-product")
    public String getProduct(@RequestParam String name) {
        return DBService.getProductByName(name);
    }

}
