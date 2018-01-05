package me.zgy.service;

import me.zgy.annotation.RpcService;

/**
 * Created by Rayee on 2017/10/1.
 */
@RpcService(value = HelloService.class, version = "2.0.0")
public class HelloServiceImpl2 implements HelloService {
    @Override
    public String hello(String name) {
        return "您好" + name;
    }

    @Override
    public String hello(Person person) {
        return "您好" + person.getFirstName() + person.getLastName();
    }
}
