package com.example.admin.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
@Document(collection = "member")
public class MemberEntity {

    @Field("_id")
    String Id;


    String memberId;
    String memberName;
    String memberEmail;
    String registerTime;
    String affiliation;
    String country;
    String dueTime;  //会员到期时间
    Boolean isDue;   //会员是否到期

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public Boolean getDue() {
        return isDue;
    }

    public void setDue(Boolean due) {
        isDue = due;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }
//    public static void main(String[] args) {
//        Date date = new Date();
//        System.out.println(date.getTime());
//        System.out.println(System.currentTimeMillis());
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String current = df.format(System.currentTimeMillis());
//        System.out.println(current);
//
//
//    }

}


