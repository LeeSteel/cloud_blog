package com.lgcy.blog.utils.base;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version V1.0
 * @Title: 时间工具类
 * @Package com.lgcy.blog.utils.date
 * @Description: 时间工具类
 * @author: 李钢 2580704698@qq.com
 * @date: 2019/9/7 11:25
 * @Copyright: Copyright (c) 2019
 */
public class DateUtils {

    /**
     * 日期格式 yyyy-MM
     */
    public static final String PATTERN_YYYY_MM = "yyyy-MM";

    /**
     * 日期格式 yyyy-MM-dd
     */
    public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     */
    public static final String PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


    /**
     * @Title:
     * @Description: 日期格式化
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/7 11:04
     * @param: date 日期
     * @return: 输出格式为 yyyy-MM-dd 的字串
     */
    public static String formatDate(Date date) {
        return formatDate(date, PATTERN_YYYY_MM_DD);
    }

    /**
     * @Title:
     * @Description: 日期格式化
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/7 11:05
     * @param date    日期
     * @param pattern 格式化类型
     * @return: 日期格式化
     */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdfDate = new SimpleDateFormat(pattern);
        return sdfDate.format(date);
    }


    /**
     * @Title:
     * @Description: 获取当前时间字符串 格式为 yyyy-MM-dd HH:mm:ss
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/7 11:08
     * @param: null
     * @return: 当前时间字符串 格式为 yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentTime() {
        SimpleDateFormat sdfTemp = new SimpleDateFormat(PATTERN_YYYY_MM_DD_HH_MM_SS);
        return sdfTemp.format(System.currentTimeMillis());
    }
}
