package com.imranmadbar.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.imranmadbar.spring_boot_soap_service.User;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize() {

        User peter = new User();
        peter.setName("imran");
        peter.setEmpId(1111);
        peter.setSalary(12000);

        User sam = new User();
        sam.setName("hossain");
        sam.setEmpId(1112);
        sam.setSalary(32000);


        users.put(peter.getName(), peter);
        users.put(sam.getName(), sam);

    }


    public User getUsers(String name) {
        return users.get(name);
    }
}