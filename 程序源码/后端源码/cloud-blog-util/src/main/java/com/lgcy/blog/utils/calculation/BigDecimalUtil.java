package com.lgcy.blog.utils.calculation;

import java.math.BigDecimal;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 提供精确的浮点数运算(包括加 、 减 、 乘 、 除 、 四舍五入)工具类
 * @author: 李钢 2580704698@qq.com
 * @date: 2019/9/16 8:51
 * @Copyright: Copyright (c) 2019
 */
public class BigDecimalUtil {

    // 默认精度
    private static final int DEF_DIV_SCALE = 10;

    private BigDecimalUtil() {
    }

    /**
     * @param scale 四舍五入保留小数点后的位数
     * @param v     要相加的数值
     * @Title: 多个数值加法运算
     * @Description: 多个数值加法运算
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 9:35
     * @return:
     */
    public static double add(int scale, double... v) {
        if (v.length < 2) {
            throw new IllegalArgumentException("传入的参数数量不符合要求，必须传两位及以上参数");
        }
        BigDecimal result = new BigDecimal("0");
        BigDecimal bg = null;
        for (int i = 0; i < v.length; i++) {
            bg = new BigDecimal(v[i]);
            result = result.add(bg);
        }
        if (scale > 0) {
            return round(result.doubleValue(), scale);
        } else {
            return result.doubleValue();
        }
    }

    /**
     * @param scale 四舍五入保留小数点后的位数
     * @param v     要相减的数值，第一参数是被减数，后面的是减数
     * @Title: 多个数值减法运算
     * @Description: 多个数值减法运算
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 9:35
     * @return:
     */
    public static double sub(int scale, double... v) {
        if (v.length < 2) {
            throw new IllegalArgumentException("传入的参数数量不符合要求，必须传两位及以上参数");
        }
        BigDecimal result = new BigDecimal(v[0]);
        BigDecimal bg = null;
        for (int i = 1; i < v.length; i++) {
            bg = new BigDecimal(v[i]);
            result = result.subtract(bg);
        }
        if (scale > 0) {
            return round(result.doubleValue(), scale);
        } else {
            return result.doubleValue();
        }
    }

    /**
     * @param scale 四舍五入保留小数点后的位数
     * @param v     要相乘的数值
     * @Title: 多个数值乘法运算
     * @Description: 多个数值乘法运算
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 9:35
     * @return:
     */
    public static double mul(int scale, double... v) {
        if (v.length < 2) {
            throw new IllegalArgumentException("传入的参数数量不符合要求，必须传两位及以上参数");
        }
        BigDecimal result = new BigDecimal("1");
        BigDecimal bg = null;
        for (int i = 0; i < v.length; i++) {
            bg = new BigDecimal(v[i]);
            result = result.multiply(bg);
        }
        if (scale > 0) {
            return round(result.doubleValue(), scale);
        } else {
            return result.doubleValue();
        }
    }

    /**
     * @param scale 四舍五入保留小数点后的位数
     * @param v     要相除的数值，第一参数是被除数，后面的是除数
     * @Title: 多个数值除法运算
     * @Description: 多个数值除法运算
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 9:35
     * @return:
     */
    public static double div(int scale, double... v) {
        if (v.length < 2) {
            throw new IllegalArgumentException("传入的参数数量符合要求，必须传两位及以上参数");
        }
        BigDecimal result = new BigDecimal(v[0]);
        BigDecimal bg = null;
        for (int i = 1; i < v.length; i++) {
            bg = new BigDecimal(v[i]);
            if (scale > 0) {
                result = result.divide(bg, scale, BigDecimal.ROUND_HALF_UP);
            } else {
                result = result.divide(bg);
            }
        }
        return result.doubleValue();
    }

    /**
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @Title:
     * @Description: 提供精确的小数位四舍五入处理。
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 9:53
     * @return: 四舍五入后的结果
     */
    public static double roundUp(double v, int scale) {
        return round(v, scale);
    }
    /**
     * @param v     需要操作的数字
     * @param scale 小数点后保留几位
     * @Title:
     * @Description: 提供精确的小数位，不进行四舍五入处理。
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 9:53
     * @return: 保留后的结果
     */
    public static double roundDown(double v, int scale)
    {
        if ( scale < 0 )
        {
            throw new IllegalArgumentException("精确度不能小于0");
        }

        BigDecimal b = new BigDecimal(v);
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_DOWN).doubleValue();
    }
    /**
     * @param value1
     * @param value2
     * @Title:
     * @Description: 精确加法
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 8:56
     * @return:
     */
    @Deprecated
    public static Double add(Double value1, Double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.add(b2).doubleValue();
    }

    /**
     * @param value1
     * @param value2
     * @Title:
     * @Description: 精确加法
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 8:56
     * @return:
     */
    @Deprecated
    public static Double add(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2).doubleValue();
    }

    /**
     * @param value1
     * @param value2
     * @Title:
     * @Description: 精确减法
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 8:56
     * @return:
     */
    @Deprecated
    public static Double sub(Double value1, Double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * @param value1
     * @param value2
     * @Title:
     * @Description: 精确减法
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 8:56
     * @return:
     */
    @Deprecated
    public static Double sub(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.subtract(b2).doubleValue();
    }


    /**
     * @param value1
     * @param value2
     * @Title:
     * @Description: 精确乘法
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 8:56
     * @return:
     */
    @Deprecated
    public static Double mul(Double value1, Double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * @param value1
     * @param value2
     * @Title:
     * @Description: 精确乘法
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 8:56
     * @return:
     */
    @Deprecated
    public static Double mul(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2).doubleValue();
    }


    /**
     * @param value1
     * @param value2
     * @Title:
     * @Description: 精确除法 使用默认精度
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 8:56
     * @return:
     */
    @Deprecated
    public static Double div(Double value1, Double value2) {
        return div(value1, value2, DEF_DIV_SCALE);
    }

    /**
     * @param value1
     * @param value2
     * @Title:
     * @Description: 精确除法 使用默认精度
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 8:56
     * @return:
     */
    @Deprecated
    public static Double div(String value1, String value2) {
        return div(value1, value2, DEF_DIV_SCALE);
    }


    /**
     * @param value1
     * @param value2
     * @param scale:精度
     * @Title:
     * @Description: 精确除法
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 8:56
     * @return:
     */
   @Deprecated
    public static Double div(Double value1, Double value2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("精确度不能小于0");
        }
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * @param value1
     * @param value2
     * @param scale:精度
     * @throws IllegalArgumentException
     * @Title:
     * @Description: 精确除法
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 8:56
     * @return:
     */
    @Deprecated
    public static Double div(String value1, String value2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * @param value
     * @param scale:精度,小数点后多少位
     * @return
     * @Title:
     * @Description: 四舍五入
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 8:59
     */
    public static Double round(Double value, int scale) {
        return div(value, 1.0, scale);
    }

    /**
     * @param value
     * @param scale:精度,小数点后多少位
     * @return
     * @throws IllegalAccessException
     * @Title:
     * @Description: 四舍五入
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 8:59
     */
    public static Double round(String value, int scale) throws IllegalAccessException {
        return div(value, "1.0", scale);
    }

    /**
     *
     */
    /**
     * @Title:
     * @Description: 比较大小
     * @author: 李钢 2580704698@qq.com
     * @date: 2019/9/16 9:00
     * @param: b1
     * @param: b2
     * @return:
     */
    public static boolean equalTo(BigDecimal b1, BigDecimal b2) {
        if (b1 == null || b2 == null) {
            return false;
        }
        return 0 == b1.compareTo(b2);
    }


}
