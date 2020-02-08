package com.qingshan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qingshan.service.TimeServcie;

import javax.annotation.Resource;

@Controller
public class TimeController {
    @Resource
    TimeServcie timeServcie;
    @RequestMapping("/time")
    public String getTime(String beginTime){
        //String time = timeServcie.getTime(beginTime);
        //ModelAndView modelAndView = new ModelAndView();
       // modelAndView.addObject("caculateTime",time);
        System.out.println(123);
        return "simpleWebShow";
    }
}
