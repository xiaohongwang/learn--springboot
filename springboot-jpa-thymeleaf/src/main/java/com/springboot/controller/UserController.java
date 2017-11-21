package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.UserService;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by xiaohong on 2017/11/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "redirect:/user/list";
    }

    @RequestMapping("/list")
    public String userList(Model model){
       List<User> userList = userService.getUserList();
       model.addAttribute("users",userList);
       return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/add";
    }

    @RequestMapping("/add")
    public String add(User user){
       userService.save(user);
       return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        userService.delete(id);
        return "redirect:/user/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Integer id){
        User user = new User();
       model.addAttribute("user", userService.findUserById(id));
        return "/user/edit";
    }

    @RequestMapping("/edit")
    public String toEdit(User user){
        userService.edit(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/toFindUser")
    public String toEditByUserName(Model model,Integer id ,String userName){
        User user = new User();
        user = userService.findUserById(id);
        model.addAttribute("user1", user);
        user = userService.findUserByUserName(userName);
        model.addAttribute("user2", user);
        return "/thymeleaf-learn/asterisk";
    }

    @RequestMapping("/findUser")
    public String toEditByUserName(Model model){
        User user = new User();
        user = userService.findUserById(10);
        model.addAttribute("user",user);
        return "/user/userInfo";
    }
}
