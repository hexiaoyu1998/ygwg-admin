package com.example.admin.dao;

import com.example.admin.entity.MemberEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface memberDao {

    Object insert(HttpServletRequest request);

    Object delete(HttpServletRequest request);

    void update( MemberEntity memberEntity);

    List<MemberEntity> findAll(HttpServletRequest request);

    MemberEntity findById(String Id);

    List<MemberEntity> findByName(String Name);

    List<MemberEntity> findByEmail(String Email);

    List<MemberEntity> findByregisterTime(String Time);

    List<MemberEntity> findByAffiliation(String affiliation);

    List<MemberEntity> findByCountry(String country);

    List<MemberEntity> outputFindAll();







}
