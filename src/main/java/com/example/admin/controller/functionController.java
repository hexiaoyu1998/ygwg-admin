package com.example.admin.controller;

import com.example.admin.dao.memberDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/function")
public class functionController {

    @Autowired
    memberDaoImpl memberDao;


    @ResponseBody
    @RequestMapping(value = "/outexcel",method= RequestMethod.GET)
    public Object outputExcel()  {
        return memberDao.outputFindAll().toArray();

    }


}
