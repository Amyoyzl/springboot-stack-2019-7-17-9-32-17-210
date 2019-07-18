package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Procuratorate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProcuratorateRepository extends JpaRepository<Procuratorate, Long> {

    Optional<Procuratorate> findById(long id);

}
