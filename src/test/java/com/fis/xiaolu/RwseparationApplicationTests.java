package com.fis.xiaolu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fis.xiaolu.service.ProcessOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RWSeparationApp.class)
public class RwseparationApplicationTests {

    @Autowired
    private ProcessOrder processOrder;

    @Test
    public void insertOrders() {
        processOrder.insertOrders(5);
    }

    @Test
    public void queryOrders() {
        processOrder.findOrders();
        processOrder.findOrdersMaster();
    }

}

