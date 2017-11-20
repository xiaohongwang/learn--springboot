package com.springboot.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaohong on 2017/11/20.
 */
@Controller
@RequestMapping("/layout")
public class LayoutController {

    @RequestMapping("/test")
    public String test(){
        return "/thymeleaf-learn/layout";
    }
}
