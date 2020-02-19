package com.qingshan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qingshan.service.TimeServcie;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
@RequestMapping("/time")
public class TimeController {
    @Resource
    TimeServcie timeServcie;
    @RequestMapping("/getTime")
    public ModelAndView getTime(String beginTime) throws ParseException {
        if(beginTime==null||beginTime==""){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(new Date());
            System.out.println("format:"+format);
            beginTime=format;
        }
        int days = timeServcie.getTime(beginTime);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("caculateTime",days);
        return new ModelAndView("simpleWebShow",map);
    }
    @RequestMapping("setTime")
    public void setTime(String setTimeValue){

    }
    @RequestMapping("/getTimes")
    public ModelAndView getTimes(){
        HashMap<String, Integer> map1 = new HashMap<>();
        int days = timeServcie.getTime();
        map1.put("caculateTime",days);

        return new ModelAndView("caculateTime",map1);
    }

}
