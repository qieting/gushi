package com.example.gushi.controller;


import com.example.gushi.dao.People;
import com.example.gushi.dao.Tangshi;
import com.example.gushi.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class MyController {

    @Autowired
    private PeopleService peopleService;

    //
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {

        return "正常使用";

    }

    // 返回-1代表账号不存在，返回-2代表密码错误，登陆成功则返回1
    @RequestMapping(value = "/login")
    public Map<String, Object> login(@RequestParam("number") String phone_number, @RequestParam(name = "password") String pass_word,
                                     HttpSession session) {

        Map<String, Object> req = new HashMap<>();
        if (pass_word == null) {
            req.put("status", 100);
        }
        if (phone_number == null) {
            req.put("status", 101);
        }
        req = peopleService.login(phone_number, pass_word);
        if ((int) req.get("status") == 1) {
            session.setAttribute("id", phone_number);
        }
        return req;
    }

    // 返回0代表账号已经被注册，否则返回1
    @RequestMapping(value = "/register")
    public int register(@RequestParam("number") String phone_number, @RequestParam("password") String pass_word,
                        HttpSession session) {

        int id = peopleService.register(phone_number, pass_word);
        if (id == 1) {
            session.setAttribute("id", phone_number);

        }
        return id;
    }

    // 返回0代表账号已经被注册，否则返回1
    @RequestMapping(value = "/changePassword")
    public int changePassword(@RequestParam("number") String phone_number, @RequestParam("password") String pass_word,
                              HttpSession session) {
        peopleService.changePassword(phone_number, pass_word);

        session.setAttribute("id", phone_number);

        return 1;
    }

    // 返回0代表账号已经被注册，否则返回1
    @RequestMapping(value = "/addlike")
    public int addTangan(@RequestParam("id") int tangshiid,

                                  HttpSession session) {

        System.out.println(1);

        peopleService.addtoLike((String)session.getAttribute("id"),tangshiid);
        return  1;


    }
    @RequestMapping(value = "/removelike")
    public int removeTangan(@RequestParam("id") int tangshiid,

                         HttpSession session) {


        peopleService.removeLike((String)session.getAttribute("id"),tangshiid);
        return  1;


    }



    // 返回0代表账号已经被注册，否则返回1
    @RequestMapping(value = "/changemessage")
    public int delete(@RequestBody People people,

                      HttpSession session) {


        peopleService.changeMessage(people);
        return 0;
    }

    @RequestMapping(value = "/query")
    public List<Tangshi> query(@RequestParam("params") String s){
        return  peopleService.qureyByTitle(s);
    }


}