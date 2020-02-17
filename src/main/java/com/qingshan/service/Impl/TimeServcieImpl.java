package com.qingshan.service.Impl;

import com.qingshan.common.exception.ServiceException;
import org.springframework.stereotype.Service;
import com.qingshan.service.TimeServcie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service("timeService")
public class TimeServcieImpl implements TimeServcie {
    private String defaultTime;

    public String getDefaultTime() {
        return defaultTime;
    }

    public void setDefaultTime(String defaultTime) {
        this.defaultTime = defaultTime;
    }

    @Override
    public int getTime(String beginTime) throws ParseException {
        String pattern="([0-9]{4})-[0-9]{2}-[0-9]{2}";
        boolean matches = beginTime.matches(pattern);
        if(false==matches){
            throw  new ServiceException("日期格式错误！");
        }

        System.out.println("beginTime:"+beginTime);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(beginTime);
        long parseTime = parse.getTime();
        System.out.println("parseTime:"+parseTime);
        long now=System.currentTimeMillis();
        System.out.println("now:"+now);
        if(now-parseTime<0){
           throw  new ServiceException("设定的时间超过了现在时间！"
                   +"现在时间是："+sdf.format(new Date(now)));
        }

        int days = (int)((now - parseTime) / 1000 / 60 / 60 / 24);//这个地方要加括号不加括号会计算错误

        System.out.println("days:"+days);

        return days;
    }

    @Override
    public int getTime() {

        return 0;
    }
}
