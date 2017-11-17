package com.springboot.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiaohong on 2017/11/17.
 */
@Controller
@RequestMapping("/utility")
public class UtilityController {

    @RequestMapping("/dates/test")
    public String test(Model model){
        Date nowTime = new Date();
        model.addAttribute("nowTime",nowTime.getTime());
        return "/thymeleaf-learn/utility";
    }


    @RequestMapping("/strings/test")
    public String test1(Model model){
        model.addAttribute("name","xiaoxiao");
        List<String> list = new ArrayList<>();
        list.add("age");
        list.add("address");
        model.addAttribute("infos",list);
        String[] arrs = {"12","13","14"};
        return "/thymeleaf-learn/utility";
    }
}
