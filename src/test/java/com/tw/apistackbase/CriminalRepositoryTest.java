package com.tw.apistackbase;

import com.tw.apistackbase.model.Criminal;
import com.tw.apistackbase.model.CriminalRecord;
import com.tw.apistackbase.repository.CriminalRecordRepository;
import com.tw.apistackbase.repository.CriminalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CriminalRepositoryTest {

    @Autowired
    private CriminalRepository criminalRepository;

    @Autowired
    private CriminalRecordRepository recordRepository;

    @Test
    public void should_add_criminal() {
        Criminal criminal = new Criminal();
        criminal.setName("caseTest");

        long criminalId = criminalRepository.save(criminal).getId();
        Criminal fetchedCriminal = criminalRepository.findById(criminalId).get();
        assertSame(fetchedCriminal.getName(), criminal.getName());

    }

    @Test
    public void should_update_criminal() {
        Criminal criminal = new Criminal();
        criminal.setName("caseTest");
        long criminalId = criminalRepository.save(criminal).getId();
        Criminal updateCriminal = new Criminal();
        updateCriminal.setName("caseUpdate");
        updateCriminal.setId(criminalId);

        criminalRepository.save(updateCriminal);
        Criminal fetchedCriminal = criminalRepository.findById(criminalId).get();

        assertSame(fetchedCriminal.getName(), updateCriminal.getName());
    }

    @Test
    public void should_delete_criminal() {
        Criminal criminal = new Criminal();
        criminal.setName("caseTest");
        long criminalId = criminalRepository.save(criminal).getId();
        criminalRepository.deleteById(criminalId);
        boolean exist = criminalRepository.findById(criminalId).isPresent();
        assertFalse(exist);
    }

    @Test
    public void should_return_criminals() {
        Criminal criminal = new Criminal();
        criminal.setName("caseTest");
        CriminalRecord record = new CriminalRecord();
        record.setSubjectiveDescription("====");
        record.setObjectiveDescription("====");
        record.setId(recordRepository.save(record).getId());
        criminal.setCriminalRecord(record);
        criminalRepository.save(criminal);
        List<Criminal> criminals = criminalRepository.findAll();
        assertSame(criminals.size(), 1);
        assertSame(criminals.get(0).getName(), criminal.getName());
    }

    @Test
    public void should_return_criminal_given_id() {
        Criminal criminal = new Criminal();
        criminal.setName("caseTest");
        long criminalId = criminalRepository.save(criminal).getId();

        Criminal fetchedCriminal = criminalRepository.findById(criminalId).get();
        assertSame(fetchedCriminal.getName(), criminal.getName());
    }

}
