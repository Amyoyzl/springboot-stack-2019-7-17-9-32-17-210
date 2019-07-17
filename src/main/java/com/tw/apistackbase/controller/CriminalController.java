package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Criminal;
import com.tw.apistackbase.repository.CriminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<Criminal> getAll() {
        return repository.findAll(new Sort(Sort.Direction.DESC, "time"));
    }

    @GetMapping(params = "name")
    public List<Criminal> getByName(@RequestParam String name) {
        return repository.findAll().stream()
                .filter(criminal -> criminal.getName().contains(name))
                .collect(Collectors.toList());
    }

}
