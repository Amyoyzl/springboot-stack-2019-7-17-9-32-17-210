package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Prosecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProsectorRepository extends JpaRepository<Prosecutor, Long> {

    Prosecutor findById(long id);
}
