package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateTimeUtil
{
    public static String currentTime()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return LocalDateTime.now().format(formatter);
    }
}
