package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CriminalRepository extends JpaRepository<Criminal, Long> {

    Criminal save(Criminal criminal);

    List<Criminal> findByOrderByTimeDesc();

    List<Criminal> findByName(String name);

    Optional<Criminal> findById(long id);

    void deleteById(long id);



}
