package com.example.gushi.service;


import com.example.gushi.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private TangshiRepository tangshiRepository;
    @Autowired
    private LikeRepository likeRepository;




    // 返回-1代表账号不存在，返回-2代表密码错误，登陆成功则返回1
    public Map<String, Object> login(String phone_number, String password) {
        People people = peopleRepository.findByPhoneNumber(phone_number);

        Map<String, Object> req = new HashMap<>();
        if (people == null) {
            req.put("status", -1);
            return req;
        }
        if (people.getPassword().equals(password)) {
            req.put("status", 1);
            req.put("people", people);
            List<MLike> tangans = getLikesByPhoneNumbe(phone_number);

            if (tangans != null && tangans.size() > 0) {
                List<Tangshi> tangshis =new ArrayList<>();
                for (MLike MLike :tangans){
                    Optional<Tangshi> tangshi =tangshiRepository.findById(MLike.getTangshiid());
                    if(tangshi.isPresent())
                    tangshis.add(tangshi.get());

                }
                req.put("tangan", tangshis);
            } else {
                req.put("tangan", new ArrayList<>());
            }


        } else {
            req.put("status", -2);
        }
        return req;

    }

    // 返回0代表账号已经被注册，否则返回id
    public int register(String phone_number, String password) {


        if ((int) login(phone_number, password).get("status") != -1)
            return 0;

        if (password.equals("汉")) {
            return 2;
        }

        People people1 = new People();
        people1.setPhoneNumber(phone_number);
        people1.setPassword(password);
        peopleRepository.save(people1);

        return 1;

    }

    @Override
    public void changePassword(String id, String password) {

        People people = peopleRepository.findByPhoneNumber(id);
        if (people == null) {
            people = new People();
            people.setPhoneNumber(id);

        }
        people.setPassword(password);
        peopleRepository.save(people);
    }

    @Override
    public List<MLike> getLikesByPhoneNumbe(String number) {
        return likeRepository.findByNumber(number);
    }

    @Override
    public List<Tangshi> getTangshis() {
        return tangshiRepository.findAll();
    }

    @Override
    public void addtoLike(String number, int id) {
        MLike mLike =new MLike();
       mLike.setNumber(number);
       mLike.setTangshiid(id);
        likeRepository.save(mLike);

    }

    @Override
    public void removeLike(String number, int id) {
        MLike mLike =new MLike();
        mLike.setNumber(number);
        mLike.setTangshiid(id);
        likeRepository.delete(mLike);
    }

    @Override
    public void changeMessage(People p) {
        peopleRepository.save(p);
    }

    @Override
    public List<Tangshi> qureyByTitle(String s) {
        return tangshiRepository.findByTitleContains(s);
    }


}
