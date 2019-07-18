package com.tw.apistackbase;

import com.tw.apistackbase.model.Procuratorate;
import com.tw.apistackbase.repository.ProcuratorateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ProcuratorateReepositoryTest {

    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Test
    public void should_add_procuratorate() {
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setName("procuratorate");

        long id = procuratorateRepository.save(procuratorate).getId();
        Procuratorate fetch = procuratorateRepository.findById(id).get();

        assertSame(fetch.getName(), procuratorate.getName());
    }

    @Test
    public void should_update_procuratorate() {
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setName("procuratorate");
        long id = procuratorateRepository.save(procuratorate).getId();
        Procuratorate updateProcuratorate = new Procuratorate();
        updateProcuratorate.setId(id);
        updateProcuratorate.setName("upateName");

        procuratorateRepository.save(updateProcuratorate);
        Procuratorate fetch = procuratorateRepository.findById(id).get();

        assertNotEquals("procuratorate", fetch.getName());
        assertSame(fetch.getName(), updateProcuratorate.getName());
    }

    @Test
    public void should_delete_procuratorate() {
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setName("procuratorate");
        long id = procuratorateRepository.save(procuratorate).getId();

        procuratorateRepository.deleteById(id);
        boolean exist = procuratorateRepository.findById(id).isPresent();

        assertFalse(exist);
    }

    @Test
    public void should_return_procuratorates() {
        Procuratorate procuratorate1 = new Procuratorate();
        procuratorate1.setName("procuratorate1");
        Procuratorate procuratorate2 = new Procuratorate();
        procuratorate2.setName("procuratorate2");
        procuratorateRepository.save(procuratorate1);
        procuratorateRepository.save(procuratorate2);

        List<Procuratorate> procuratorates = procuratorateRepository.findAll();
        assertEquals(procuratorates.size(), 2);
        assertEquals(procuratorates.get(0).getName(), procuratorate1.getName());
        assertEquals(procuratorates.get(1).getName(), procuratorate2.getName());
    }

    @Test
    public void should_return_procuratorate_by_id() {
        Procuratorate procuratorate1 = new Procuratorate();
        procuratorate1.setName("procuratorate1");
        long id = procuratorateRepository.save(procuratorate1).getId();

        Procuratorate fetch = procuratorateRepository.findById(id).get();

        assertEquals(fetch.getName(), procuratorate1.getName());
    }

}
