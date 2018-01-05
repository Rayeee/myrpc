package me.zgy.service;

import me.zgy.annotation.RpcService;

/**
 * Created by Rayee on 2017/10/1.
 */
@RpcService(value = HelloService.class)
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello" + name;
    }

    @Override
    public String hello(Person person) {
        return "Hello" + person.getFirstName() + person.getLastName();
    }
}
