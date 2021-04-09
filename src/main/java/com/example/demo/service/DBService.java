package com.example.demo.service;

import com.example.demo.repository.DB;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    private DB repository;

    public DBService(DB repository) {
        this.repository = repository;
    }

    public String getProductByName(String name) {
        return repository.getProductByName(name);
    }
}
