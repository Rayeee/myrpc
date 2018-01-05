package me.zgy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Rayee on 2017/12/11.
 */
public class ServerBootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
        context.start();
    }

}
