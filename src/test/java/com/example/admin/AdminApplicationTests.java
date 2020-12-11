package com.example.admin;

import com.example.admin.dao.memberDaoImpl;
import com.example.admin.dao.outputDaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class AdminApplicationTests {

    @Autowired
    outputDaoImpl outputDao;


    @Test
    void contextLoads() {
    }

    @Test
    void testOutExcel()  {
        System.out.println(outputDao.outputExcel());
    }


}
