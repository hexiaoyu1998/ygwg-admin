package com.example.admin.dao;

import com.example.admin.entity.MemberEntity;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;




@Repository
public class outputDaoImpl implements outputDao{



    @Autowired
    memberDaoImpl memberDao;

    @Override
    public String outputExcel() {
        boolean tag;
        List<MemberEntity> memberEntityList = memberDao.outputFindAll();

        //创建Excel对象
        XSSFWorkbook wbook = new XSSFWorkbook();
        //创建Sheet对象
        XSSFSheet hsheet = wbook.createSheet("ygwgMember");
        //创建Row对象
        XSSFRow hrow = hsheet.createRow(0);


        hsheet.setDefaultRowHeight((short) 400);
        //设置每行高度
        hrow.setHeightInPoints(40);
        //创建Cell样式并设置样式
        XSSFCellStyle hstyle = wbook.createCellStyle();
        //水平居中
        hstyle.setAlignment(HorizontalAlignment.CENTER);
        //竖直居中
        hstyle.setVerticalAlignment(VerticalAlignment.CENTER);


        //创建字体
        XSSFFont font = wbook.createFont();
        //设置字体类型
        ((XSSFFont) font).setFontName("宋体");
        //设置字体是否加粗
//        font.setBold(true);
        //设置字体是否倾斜
//        font.setItalic(true);
        //设置字号
        font.setFontHeightInPoints((short) 11);
        //设置字体颜色
        font.setColor(IndexedColors.BLACK.index);
        //将字体加入样式
        hstyle.setFont(font);


        String[] heads = {"serial number", "memberId", "memberName", "memberEmail", "registerTime", "affiliation", "country", "dueTime", "isDue"};
        for (int i = 0; i < heads.length; i++) {
            hsheet.setColumnWidth(i, 6000);
        }
        for (int i = 0; i < heads.length; i++) {
            XSSFCell cell;
            cell = hrow.createCell(i);
            cell.setCellValue(heads[i]);
            cell.setCellStyle(hstyle);
        }

        //        写入行
        for (int i = 0; i < memberEntityList.size(); i++) {
            XSSFRow rows = hsheet.createRow(i + 1);
            MemberEntity memberEntity = memberEntityList.get(i);

            rows.createCell(0).setCellValue(i + 1);
            rows.createCell(1).setCellValue(memberEntity.getMemberId());
            rows.createCell(2).setCellValue(memberEntity.getMemberName());
            rows.createCell(3).setCellValue(memberEntity.getMemberEmail());
            rows.createCell(4).setCellValue(memberEntity.getRegisterTime());
            rows.createCell(5).setCellValue(memberEntity.getAffiliation());
            rows.createCell(6).setCellValue(memberEntity.getCountry());
            rows.createCell(7).setCellValue(memberEntity.getDueTime());
            rows.createCell(8).setCellValue(memberEntity.getDue().toString());


        }

        //路径可自定义

        try {
            //路径可自定义
            OutputStream output = new FileOutputStream("F:/YGWG-member.xlsx");
            wbook.write(output);
            output.close();
            output.flush();
            return "导出成功 F:/YGWG-member.xlsx";

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "导出失败，请关闭excel文件再次进行导出";
        }
    }
}
