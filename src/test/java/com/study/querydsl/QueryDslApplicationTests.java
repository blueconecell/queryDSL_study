package com.study.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.entity.Hello;
import com.study.querydsl.entity.Member;
import com.study.querydsl.entity.QHello;
import com.study.querydsl.entity.QMember;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.study.querydsl.entity.QMember.*;

@SpringBootTest
@Transactional
class QueryDslApplicationTests {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;


    @Test
    void contextLoads() {
        Hello hello = new Hello();
        em.persist(hello);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QHello qHello = QHello.hello;

        Hello result = query
                .selectFrom(qHello)
                .fetchOne();
        Assertions.assertEquals(result, hello);
        Assertions.assertEquals(result.getId(), hello.getId());

    }



}
