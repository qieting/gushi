package com.example.gushi.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface TangshiRepository extends JpaRepository<Tangshi, Integer> {


    public List<Tangshi> findByTitleContains(String s);



}