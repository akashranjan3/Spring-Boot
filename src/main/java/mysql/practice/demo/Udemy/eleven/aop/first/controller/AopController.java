package mysql.practice.demo.Udemy.eleven.aop.first.controller;

import mysql.practice.demo.Udemy.eleven.aop.first.AccountDAO;
import mysql.practice.demo.Udemy.ten.advanceJpa.first.dao.AppDAO;
import mysql.practice.demo.Udemy.ten.advanceJpa.first.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aop")
public class AopController {

    @Autowired
    private AccountDAO accountDAO;

    public AopController(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

@GetMapping("/say_my_name")
    public String hello() {
        return "Hello Akash Ranjan.";
    }

@GetMapping("/call_me")
    public String callMe() {
    System.out.println("_____ hello boss ");
    accountDAO.addAccount();

        return "calling";
    }


}
