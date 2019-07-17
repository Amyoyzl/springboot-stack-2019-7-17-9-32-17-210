package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Criminal;
import com.tw.apistackbase.repository.CriminalRepository;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        return repository.findByOrderByTimeDesc();
    }

    @GetMapping(params = "name")
    public List<Criminal> getByName(@RequestParam String name) {
        return repository.findByName(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }

}
