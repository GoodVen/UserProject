/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.app.service.IUserService;
import org.app.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sergey
 */
@Controller
@Scope("singleton")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @PostConstruct
    public void post(){
        System.out.println("post construct");
    }
    
    @PreDestroy
    public void pre(){
        System.out.println("pre Destroy");
    }
    
    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public String index(Model model){
    model.addAttribute("accounts", userService.getAll());
    return "index";
    }
    
    @RequestMapping(value = "/user/create.htm", method = RequestMethod.GET)
    public String createUser (@ModelAttribute("userAttribute") User account, Model model){
    return "usercreate";
    }
    
    @RequestMapping(value = "/user/update/{id}.htm", method = RequestMethod.GET)
    public String updateUser(@PathVariable Long id,@ModelAttribute("userAttribute") User account, Model model ){
    for (User us: userService.getAll()){
    if ( us.getId().longValue()== id.longValue()){
    account.setId(us.getId());
    account.setName(us.getName());
    model.addAttribute("userAttribute", account);
    break;
    }
    }
    return "userupdate";
    }
    
    @RequestMapping(value = "/user/delete/{id}.htm", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id, Model model){
        userService.deliteUser(id);
        return "redirect:/index.htm";
    }
    
    @RequestMapping(value = "/user/save.htm", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("userAttribute") User account, Model model){
    if(account.getId()==null){
    this.userService.addUser(account);
   
    } else {
            this.userService.updateUser(account);
            }
    return "redirect:/index.htm";
    }
}
