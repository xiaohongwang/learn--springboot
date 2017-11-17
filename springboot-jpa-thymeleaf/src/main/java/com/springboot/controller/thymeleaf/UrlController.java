package com.springboot.controller.thymeleaf;

import org.codehaus.groovy.runtime.StringGroovyMethods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaohong on 2017/11/17.
 */
@Controller
@RequestMapping("/url")
public class UrlController {

    @RequestMapping("/test")
    public String url(){
        return "/thymeleaf-learn/url";
    }
}
