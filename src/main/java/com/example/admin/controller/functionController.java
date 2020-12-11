package com.example.admin.controller;

import com.example.admin.dao.outputDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Controller
@RequestMapping(value = "/function")
public class functionController {

    @Autowired
    outputDaoImpl outputDao;

    @ResponseBody
    @RequestMapping(value = "/outexcel",method= RequestMethod.GET)
    public String outputExcel()  {
        String message=outputDao.outputExcel();
        return message;
    }


}
