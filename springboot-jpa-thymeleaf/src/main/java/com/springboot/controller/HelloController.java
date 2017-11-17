package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaohong on 2017/11/15.
 */
@Controller
public class HelloController {

//    @RequestMapping("/hello/{name}")
//    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name){
//        model.addAttribute("name",name);
//        return "hello";
//    }

    @RequestMapping("/hello/{name}")
    public String hello(Model model, @PathVariable(value = "name") String name){
        model.addAttribute("name",name);
        return "hello";
    }

}
