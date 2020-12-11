package com.example.admin.dao;

import com.example.admin.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Repository
public class memberDaoImpl implements memberDao{
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Object insert(HttpServletRequest request) {
        String memberEmail = request.getParameter("memberEmail");
        String memberName=request.getParameter("memberName");

        Query query1=new Query(Criteria.where("memberName").is(memberName));
        Query query2=new Query(Criteria.where("memberEmail").is(memberEmail));

        MemberEntity member1=mongoTemplate.findOne(query1,MemberEntity.class);
        MemberEntity member2=mongoTemplate.findOne(query2,MemberEntity.class);

        if(member1!=null&&member2!=null){
            return "会员已注册";
        }
        else{
            if(member1==null||member2==null){
                MemberEntity memberEntity=new MemberEntity();
                memberEntity.setMemberName(memberName);
                memberEntity.setMemberEmail(memberEmail);
                memberEntity.setAffiliation(request.getParameter("affiliation"));
                memberEntity.setCountry(request.getParameter("country"));

                Date date = new Date(); // get the current date
                SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
                System.out.println(fmt.format(date));


                Calendar calendar=Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.YEAR,1);
                String DueDate=fmt.format(calendar.getTime());


                memberEntity.setRegisterTime(fmt.format(date));
                memberEntity.setDueTime(DueDate);
                memberEntity.setDue(false);
                mongoTemplate.save(memberEntity);

                Query query=new Query();
                query.addCriteria(new Criteria().andOperator(Criteria.where("memberName").is(memberName),
                                                             Criteria.where("memberEmail").is(memberEmail)));
                memberEntity=mongoTemplate.findOne(query,MemberEntity.class);
                return memberEntity.getMemberId();
            }
        }
        //mongoTemplate.save(memberEntity);
        return null;
    }

    @Override
    public Object delete(HttpServletRequest request) {
        String memberId=request.getParameter("deleteId");
        Query query=new Query(Criteria.where("_id").is(memberId));
        MemberEntity member=mongoTemplate.findOne(query,MemberEntity.class);
        if(member==null){
            return "该用户不存在！";
        }
        else{
            mongoTemplate.remove(query,MemberEntity.class);
            return member;
        }

    }


    @Override
    public void update(MemberEntity memberEntity) {
        Query query = new Query(Criteria.where("_id").is(memberEntity.getMemberId()));

        //todo
    }

    @Override
    public List<MemberEntity> findAll(HttpServletRequest request) {
        return mongoTemplate.find(new Query(),MemberEntity.class);
    }

    @Override
    public MemberEntity findById(String Id) {
        Query query=new Query(Criteria.where("_id").is(Id));

        return (MemberEntity) mongoTemplate.find(query,MemberEntity.class);
    }

    @Override
    public List<MemberEntity> findByName(String Name) {
        Query query=new Query(Criteria.where("memberName").is(Name));
        List<MemberEntity> memberEntity= mongoTemplate.find(query,MemberEntity.class);
//        System.out.println(memberEntity.get(0).getDue());
        return memberEntity;
    }

    @Override
    public List<MemberEntity> findByEmail(String Email) {
        Query query=new Query(Criteria.where("memberEmail").is(Email));
        List<MemberEntity> memberEntity= mongoTemplate.find(query,MemberEntity.class);
        return memberEntity;
    }

    @Override
    public List<MemberEntity> findByregisterTime(String Time) {
        Query query =new Query(Criteria.where("registerTime").is(Time));
        List<MemberEntity> memberEntitity=mongoTemplate.find(query,MemberEntity.class);
        return memberEntitity;
    }

    @Override
    public List<MemberEntity> findByAffiliation(String affiliation) {
        Query query =new Query(Criteria.where("affiliation").is(affiliation));
        List<MemberEntity> memberEntitity=mongoTemplate.find(query,MemberEntity.class);
        return memberEntitity;
    }

    @Override
    public List<MemberEntity> findByCountry(String country) {
        Query query =new Query(Criteria.where("country").is(country));
        List<MemberEntity> memberEntitity=mongoTemplate.find(query,MemberEntity.class);
        return memberEntitity;
    }

    @Override
    public List<MemberEntity> outputFindAll() {
       return mongoTemplate.findAll(MemberEntity.class);
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(date.format(formatter));

    }


}

