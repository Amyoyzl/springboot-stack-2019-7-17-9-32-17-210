package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalRepository extends JpaRepository<Criminal, Long> {

}