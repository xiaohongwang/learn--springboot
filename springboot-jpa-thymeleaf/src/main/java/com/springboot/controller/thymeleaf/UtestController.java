package com.springboot.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaohong on 2017/11/17.
 */
@Controller
@RequestMapping("/utext")
public class UtestController {

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("url","<a th:href=/user/list>第一个链接</a>");
        return "thymeleaf-learn/utext";
    }
}
