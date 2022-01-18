/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app.controller;

import org.app.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Sergey
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext(new String[]{"/web/WEB-INF/dispacher-servlet.xml"} );
        IUserService iuser = (IUserService)context.getBean("userService");
        System.out.println("count of users: "+ iuser.getAll().size());
    }
}
