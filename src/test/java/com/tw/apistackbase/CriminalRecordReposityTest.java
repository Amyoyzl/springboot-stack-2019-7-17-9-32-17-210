package com.tw.apistackbase;

import com.tw.apistackbase.model.CriminalRecord;
import com.tw.apistackbase.repository.CriminalRecordRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CriminalRecordReposityTest {

    @Autowired
    private CriminalRecordRepository recordRepository;

    @Test
    public void should_add_criminalRecord() {
        CriminalRecord record = new CriminalRecord();
        record.setObjectiveDescription("====");
        record.setSubjectiveDescription("====");

        long id = recordRepository.save(record).getId();
        CriminalRecord fetchedRecord = recordRepository.findById(id).get();
        assertSame(fetchedRecord.getSubjectiveDescription(), record.getSubjectiveDescription());
    }

    @Test
    public void should_delete_criminalRecord() {
        CriminalRecord record = new CriminalRecord();
        record.setObjectiveDescription("====");
        record.setSubjectiveDescription("====");

        long id = recordRepository.save(record).getId();
        recordRepository.deleteById(id);
        boolean exist = recordRepository.findById(id).isPresent();
        assertFalse(exist);
    }

    @Test
    public void should_update_criminalRecord() {
        CriminalRecord record = new CriminalRecord();
        record.setObjectiveDescription("====");
        record.setSubjectiveDescription("====");
        long id = recordRepository.save(record).getId();
        CriminalRecord updateRecord = new CriminalRecord();
        updateRecord.setId(id);
        updateRecord.setSubjectiveDescription("update");

        recordRepository.save(updateRecord);
        CriminalRecord fetchedRecord = recordRepository.findById(id).get();

        assertSame(updateRecord.getSubjectiveDescription(), fetchedRecord.getSubjectiveDescription());
    }

    @Test
    public void should_return_criminalRecord() {
        CriminalRecord record1 = new CriminalRecord();
        record1.setObjectiveDescription("====");
        record1.setSubjectiveDescription("====");
        CriminalRecord record2 = new CriminalRecord();
        record2.setObjectiveDescription("====");
        record2.setSubjectiveDescription("====");
        recordRepository.save(record1);
        recordRepository.save(record2);
        List<CriminalRecord> records = recordRepository.findAll();

        assertEquals(records.size(), 2);
        assertSame(records.get(0).getSubjectiveDescription(), record1.getSubjectiveDescription());
    }

    @Test
    public void should_return_criminalRecord_by_id() {
        CriminalRecord record = new CriminalRecord();
        record.setObjectiveDescription("====");
        record.setSubjectiveDescription("======");
        long id = recordRepository.save(record).getId();

        CriminalRecord fetchedRecord = recordRepository.findById(id).get();

        assertSame(fetchedRecord.getObjectiveDescription(), record.getObjectiveDescription());
    }


}
