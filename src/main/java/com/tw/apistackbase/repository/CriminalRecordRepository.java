package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriminalRecordRepository extends JpaRepository<CriminalRecord, Long> {

    CriminalRecord save(CriminalRecord criminalRecord);

    CriminalRecord findById(long id);

    List<CriminalRecord> findAll();

}
