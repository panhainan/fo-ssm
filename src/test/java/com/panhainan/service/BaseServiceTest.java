package com.panhainan.service;

/**
 * Created by fo on 2017/1/21.
 */

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Junit测试Service的父类，继承此类省去每次配置@RunWith以及@ContextConfiguration的麻烦
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
    })
public class BaseServiceTest {
}
