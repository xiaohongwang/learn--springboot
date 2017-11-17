package com.springboot.controller.thymeleaf;

import com.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/17.
 */
@Controller
@RequestMapping("/asterisk")
public class AsteriskController {
    @Resource
    private UserService userService;

    @RequestMapping("test")
    public String test(Model model){
      model.addAttribute("user", userService.findUserById(9));
      return  "/thymeleaf-learn/asterisk";
    }
}
