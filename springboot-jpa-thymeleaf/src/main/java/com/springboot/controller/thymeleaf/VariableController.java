package com.springboot.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaohong on 2017/11/17.
 */
@Controller
@RequestMapping("/variable")
public class VariableController {

    @RequestMapping("/test")
    public String test1(Model model){
        model.addAttribute("userName","xiaohong");
        model.addAttribute("age",45);
        return "thymeleaf-learn/Variable expression";
    }
}
