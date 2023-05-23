package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyUtil {
    //生成唯一主键：时间+6位随机数
    public static synchronized String genUniqueKey() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    	String str = sdf.format(new Date());
        return "Ms"+str;
    }
}
