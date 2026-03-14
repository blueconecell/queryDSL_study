package com.study.querydsl.controller;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.entity.Hello;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

     EntityManager em;

    @GetMapping("/hello")
    public String Hello() {
        return "hello";
    }

    @GetMapping("/dsl")
    public String Dsl(){
        Hello hello = new Hello();
        em.persist(hello);


        JPAQueryFactory query = new JPAQueryFactory(em);

        return "dsl";
    }
}
