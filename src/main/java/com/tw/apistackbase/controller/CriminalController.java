package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Criminal;
import com.tw.apistackbase.repository.CriminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/criminals")
public class CriminalController {

    @Autowired
    private CriminalRepository repository;

    @PostMapping
    public Criminal add(@RequestBody Criminal criminal){
        criminal.setTime(System.currentTimeMillis());
        return repository.save(criminal);
    }

}
