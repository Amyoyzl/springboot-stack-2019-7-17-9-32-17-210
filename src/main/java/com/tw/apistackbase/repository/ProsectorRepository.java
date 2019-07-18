package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Prosecutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProsectorRepository extends JpaRepository<Prosecutor, Long> {

    Optional<Prosecutor> findById(long id);
}
