package com.example.demo;


import com.example.demo.controller.HelloController;
import com.example.demo.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloController.class)
public class HelloControllerTest {

    @Resource
    private HelloController helloController;

    @Test
    public void test1() {
        User user = helloController.hello("tom");
        log.info("user info: {}", user.toString());
    }
}
