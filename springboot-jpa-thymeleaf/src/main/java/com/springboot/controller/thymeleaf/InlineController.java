package com.springboot.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaohong on 2017/11/20.
 */
@Controller
@RequestMapping("inline")
public class InlineController {

    @RequestMapping("test")
    public String test(Model model){
        model.addAttribute("userName","xiaoxiao");
        return "/thymeleaf-learn/inline";
    }
}
