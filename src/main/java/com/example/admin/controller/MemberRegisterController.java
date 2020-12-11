package com.example.admin.controller;

import com.example.admin.dao.memberDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
@RequestMapping(value = "/member")
public class MemberRegisterController {

    @Autowired
    memberDaoImpl memberDao;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Object register(HttpServletRequest request, RedirectAttributes redirectAttributes){

       redirectAttributes.addFlashAttribute("member",memberDao.insert(request));
        return "redirect:/index";
    }

    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public Object find (HttpServletRequest request,RedirectAttributes redirectAttributes){
        String find_select=request.getParameter("find-select");
        String find_value=request.getParameter("find-value");
        switch(find_select){
            case "Name":
                redirectAttributes.addFlashAttribute("memberList",memberDao.findByName(find_value));break;
            case "Email":
                redirectAttributes.addFlashAttribute("memberList",memberDao.findByEmail(find_value));break;
            case "RegisterTime":
                redirectAttributes.addFlashAttribute("memberList",memberDao.findByregisterTime(find_value));break;
            case "Affiliation":
                redirectAttributes.addFlashAttribute("memberList",memberDao.findByAffiliation(find_value));break;
            case "Country":
                redirectAttributes.addFlashAttribute("memberList",memberDao.findByCountry(find_value));break;
            default:break;
        }
        return "redirect:/index";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object delete(HttpServletRequest request,RedirectAttributes redirectAttributes){

        Object result=memberDao.delete(request);
        if(result instanceof String)
        {
            redirectAttributes.addFlashAttribute("deleteinfo",result);
        }
        else {
            redirectAttributes.addFlashAttribute("deleteinfo","删除成功！");
            redirectAttributes.addFlashAttribute("memberDelete",result);
        }

        return "redirect:/index";

    }




}

