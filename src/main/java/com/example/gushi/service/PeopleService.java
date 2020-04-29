package com.example.gushi.service;

import com.example.gushi.dao.MLike;
import com.example.gushi.dao.People;
import com.example.gushi.dao.Tangshi;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController

public interface PeopleService {



//	private static PeopleService  serverHandler ;
//    @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
//    public void init() {  
//        serverHandler = this;  
//        serverHandler.peopleRepository = this.peopleRepository;        
//        // 初使化时将已静态化的testService实例化
//    }  
//	


//	public static PeopleService getInstance() {
//
//		return peopleService;
//	}

	public Map<String,Object> login(String phone_number, String password) ;
	public int register(String phone_number, String password) ;

	public List<MLike> getLikesByPhoneNumbe(String number);
	public void changePassword(String  id,String password);
	public List<Tangshi> getTangshis();

	public void addtoLike(String number ,int id);
	public void removeLike(String number ,int id);

	public void changeMessage(People p);
	public List<Tangshi> qureyByTitle(String s);


	
}
