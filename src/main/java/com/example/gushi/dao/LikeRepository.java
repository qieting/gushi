package com.example.gushi.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LikeRepository extends JpaRepository<MLike, String> {

     public List<MLike> findByNumber(String number);


}