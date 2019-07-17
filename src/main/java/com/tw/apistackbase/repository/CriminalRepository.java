package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriminalRepository extends JpaRepository<Criminal, Long> {

    List<Criminal> findByOrderByTimeDesc();

    List<Criminal> findByName(String name);

}
