package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Criminal;
import com.tw.apistackbase.repository.CriminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public Criminal getById(@PathVariable long id) {
        Optional<Criminal> optionalCriminal = repository.findById(id);
        return optionalCriminal.isPresent() ? optionalCriminal.get() : null;
    }

}
