package com.qingshan.service;

import java.text.ParseException;

public interface TimeServcie {
    public int getTime(String beginTime) throws ParseException;
    public int getTime();
}
