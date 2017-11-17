package com.springboot.controller.thymeleaf;

import com.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/17.
 */
@Controller
@RequestMapping("/switch")
public class SwitchController {
    @Resource
    private UserService userService;

    @RequestMapping("/test/{id}")
    public String test(Model model, @PathVariable("id") Integer id){
        model.addAttribute("user", userService.findUserById(id));
        return "/thymeleaf-learn/switch";
    }
}
