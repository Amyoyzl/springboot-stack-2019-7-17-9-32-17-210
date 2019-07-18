package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CriminalRecordRepository extends JpaRepository<CriminalRecord, Long> {

    CriminalRecord save(CriminalRecord criminalRecord);

    Optional<CriminalRecord> findById(long id);

    List<CriminalRecord> findAll();

}
