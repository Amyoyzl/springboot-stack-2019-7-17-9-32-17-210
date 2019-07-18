package com.tw.apistackbase;

import com.tw.apistackbase.model.Prosecutor;
import com.tw.apistackbase.repository.ProsectorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ProsectorRepositoryTest {

    @Autowired
    private ProsectorRepository repository;

    @Test
    public void should_add_prosecutor() {
        Prosecutor prosecutor = new Prosecutor();
        prosecutor.setName("Jimmy");

        long id = repository.save(prosecutor).getId();
        Prosecutor fetch = repository.findById(id).get();

        assertSame(fetch.getName(), prosecutor.getName());
    }

    @Test
    public void should_update_prosecutor() {
        Prosecutor prosecutor = new Prosecutor();
        prosecutor.setName("Jimmy");
        long id = repository.save(prosecutor).getId();
        Prosecutor updateProsector = new Prosecutor();
        updateProsector.setId(id);
        updateProsector.setName("upateName");

        repository.save(updateProsector);
        Prosecutor fetch = repository.findById(id).get();

        assertNotEquals("Jimmy", fetch.getName());
        assertSame(fetch.getName(), updateProsector.getName());
    }

    @Test
    public void should_delete_prosecutor() {
        Prosecutor prosecutor = new Prosecutor();
        prosecutor.setName("Jimmy");
        long id = repository.save(prosecutor).getId();

        repository.deleteById(id);
        boolean exist = repository.findById(id).isPresent();

        assertFalse(exist);
    }

    @Test
    public void should_return_prosecutors() {
        Prosecutor prosecutor1 = new Prosecutor();
        prosecutor1.setName("Jimmy");
        Prosecutor prosecutor2 = new Prosecutor();
        prosecutor2.setName("John");
        repository.save(prosecutor1);
        repository.save(prosecutor2);

        List<Prosecutor> prosecutors = repository.findAll();
        assertEquals(prosecutors.size(), 2);
        assertEquals(prosecutors.get(0).getName(), prosecutor1.getName());
        assertEquals(prosecutors.get(1).getName(), prosecutor2.getName());
    }


    @Test
    public void should_return_prosecutor_by_id() {
        Prosecutor prosecutor = new Prosecutor();
        prosecutor.setName("jimmy");
        long id = repository.save(prosecutor).getId();

        Prosecutor fetch = repository.findById(id).get();

        assertEquals(fetch.getName(), prosecutor.getName());
    }

}
