package com.lgcy.blog.utils.base;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author tangyouhua
 *  
 * 描述：字符串工具类
 */
public class StringUtils {

    /***************************************************************************
     * 函数功能：以指定的标记对字符串进行分割,最后将分割的各部分拼接成字符串
     * 
     * 参数说明：
     * 
     * @str:待分割的字符串
     * 
     * @mark:指定的标记
     * 
     *             返回值：拼接成的字符串
     **************************************************************************/
    public static String splitToStr(String str, String mark) {
        StringTokenizer st = new StringTokenizer(str, mark);
        String returnText = "";// 要返回的分割后的字符串
        while (st.hasMoreElements()) {
            String token = st.nextToken().trim();
            returnText += token.trim();
        }
        return returnText;
    }

    /***************************************************************************
     * 函数功能：以特定的分割符，将字符串进行分割，将分割的各个部份存放入list对象中
     * 
     * 参数说明：
     * 
     * @str:待分割的字符串
     * 
     * @mark:指定的分割符
     * 
     *              返回值：返回存放着分割好的字符串各个部门的列表对象
     **************************************************************************/
    public static List<String> splitToList(String str, String mark) {
        List<String> list = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(str, mark);
        while (st.hasMoreElements()) {
            String token = st.nextToken();
            list.add(token);
        }
        return list;
    }

    /***************************************************************************
     * 函数功能：判断指定的字符父串中是否存在指定的子串
     * 
     * 参数说明：
     * 
     * @fstr:指定的字符父串
     * @cstr:指定的字符子串
     * 
     *               返回值：存在返回true;不存在或者父串或子串为null，返回false;
     **************************************************************************/
    public static boolean isContainChild(String fstr, String cstr) {
        boolean flag = false;
        try {
            if (fstr == null || cstr == null)
                return false;
            else {
                if (fstr.indexOf(cstr) == -1)
                    flag = false;
                else
                    flag = true;
            }
        } catch (Exception ex) {
            flag = false;
            ex.printStackTrace();
        }
        return flag;
    }

    /**
     * 将指定的list对象中的元素，转换成字符串。每个元素之间用mark标记分隔开
     * 
     * @param:list 要转换的list对象
     * @param:mark 元素之间的分隔符号
     * @return:返回转换后的字符串
     * @throws:
     */
    public static String convertListToString(List<String> list, String mark) {
        try {
            int size = list.size();
            StringBuffer returnText = new StringBuffer("");
            for (int i = 0; i < size; i++) {
                String str = list.get(i);
                if (str == null)
                    continue;
                if (i != size - 1)
                    returnText.append(str.toCharArray()).append(mark);
                else
                    returnText.append(str.toCharArray());
            }
            return returnText.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /***************************************************************************
     * 函数功能：判断指定字符串是否是数字
     * 
     * 参数说明：
     * 
     * @str:待判断的字符串
     * 
     *              返回值：是返回true;否则返回false;
     **************************************************************************/
    public static boolean isNumber(String str) {
        boolean flag = false;
        if(isEmpty(str)){
            return false;
        }
        
        try {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(str);
            if (!isNum.matches())
                flag = false;
            else
                flag = true;
        } catch (Exception ex) {
            flag = false;
            ex.printStackTrace();
        }
        return flag;
    }

    /***************************************************************************
     * 函数功能：全角转半角
     * 
     * 参数说明：
     * 
     * @QJstr:全角字符串
     * 
     *              返回值：返回转换后的半角字符串
     **************************************************************************/
    public static String q2b(String QJstr) {
        String outStr = "";
        String Tstr = "";
        byte[] b = null;

        for (int i = 0; i < QJstr.length(); i++) {
            try {
                Tstr = QJstr.substring(i, i + 1);
                b = Tstr.getBytes("unicode");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if (b[3] == -1) {
                b[2] = (byte) (b[2] + 32);
                b[3] = 0;

                try {
                    outStr = outStr + new String(b, "unicode");
                } catch (java.io.UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else
                outStr = outStr + Tstr;
        }
        return outStr;
    }

    /***************************************************************************
     * 函数功能：半角转全角
     * 
     * 参数说明：
     * 
     * @QJstr:半角字符串
     * 
     *              返回值：返回转换后的全角字符串
     **************************************************************************/
    public static String b2q(String BJstr) {
        String outStr = "";
        String Tstr = "";
        byte[] b = null;

        for (int i = 0; i < BJstr.length(); i++) {
            try {
                Tstr = BJstr.substring(i, i + 1);
                b = Tstr.getBytes("unicode");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (b[3] != -1) {
                b[2] = (byte) (b[2] - 32);
                b[3] = -1;
                try {
                    outStr = outStr + new String(b, "unicode");
                } catch (java.io.UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else
                outStr = outStr + Tstr;
        }
        return outStr;
    }

    /***************************************************************************
     * 函数功能：判断指定的字符串是否是中文
     * 
     * 参数说明：
     * 
     * @QJstr:待判断的字符串
     * 
     *                返回值：是中文返回true;否则返回false;
     **************************************************************************/
    public static boolean isCharacter(String str) {
        try {
            return str.matches("[\\u4E00-\\u9FA5]+");
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // md5
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    /**
     * 转换字节数组为16进制字串
     * 
     * @param b
     *            字节数组
     * @return 16进制字串
     */

    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 将指定的字符串进行MD5加密
     * 
     * @param:origin指定字符串
     * @return:
     * @throws:
     */
    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString
                    .getBytes()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    /**
     * 判断字符串是否为空
     * 
     * @param str
     * @return true 为null “” false 为不为空
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim()))
            return true;
        else
            return false;
    }
    
    /**
     * 按字符长度截取字符，将字符串转为utf-8编码，即都为两个字节
     * 
     * @param s
     *            原字符串
     * @param length
     *            截取长度
     * @return 截取后的长度
     */
    public static String subChineseString(String s, int length) {
        String str = "";
        byte[] bytes;
        try {
            bytes = s.getBytes("Unicode");

            int n = 0; // 表示当前的字节数
            int i = 2; // 要截取的字节数，从第3个字节开始
            for (; i < bytes.length && n < length; i++) {
                // 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
                if (i % 2 == 1) {
                    n++; // 在UCS2第二个字节时n加1
                } else {
                    // 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
                    if (bytes[i] != 0) {
                        n++;
                    }
                }
            }
            // 如果i为奇数时，处理成偶数
            if (i % 2 == 1) {
                // 该UCS2字符是汉字时，去掉这个截一半的汉字
                if (bytes[i - 1] != 0)
                    i = i - 1;
                // 该UCS2字符是字母或数字，则保留该字符
                else
                    i = i + 1;
            }
            str = new String(bytes, 0, i, "Unicode");
            return str;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            return str;
        }
    }

    /**
     * 截取字符串添加省略号
     * 
     * @param str
     *            带处理字符串
     * @param position
     *            截取位置,汉字、数字、字母都算一个位置
     * @return 带省略号的字符串
     */
    public static String subStringAddEllipsis(String str, int position) {
        String result = "";
        // 因汉字和字符都处理为两个字节，故截取位置需X2
        int subPostion = position * 2;
        if (str != null && !str.equals("")) {
            try {
                if (str.getBytes("Unicode").length > subPostion) {
                    str = StringUtils.subChineseString(str, subPostion) + "...";
                    // content = content.substring(0, 12) + "...";
                }
                result = str;
            } catch (UnsupportedEncodingException e) {
                return "";
            }
        }
        return result;
    }

    /**
     * 利用时间生成8位的随机数
     * 
     * @param time
     * @return
     */
    public static String toHex() {
        String s = "";
        for (int i = 0; i < 8; i++) {
            int a = (int) (Math.random() * 10);
            s += a;
        }
        return s;
    }

    /**
     * 字符串替换函数
     * 
     * @param from
     *            要替换的字符
     * @param to
     *            要替换成的目标字符
     * @param source
     *            要替换的字符串
     * @return 替换后的字符串
     */
    public static String str_replace(String from, String to, String source) {
        StringBuffer bf = new StringBuffer("");
        StringTokenizer st = new StringTokenizer(source, from, true);

        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();
            if (tmp.equals(from)) {
                bf.append(to);
            } else {
                bf.append(tmp);
            }
        }
        return bf.toString();
    }


    /**
     * 判断版本
     * 
     * @param str1
     *            旧
     * @param str2
     *            新
     * @return
     */
    public static boolean compareString(String str1, String str2) {

        try {
            str2 = str2.replace('.', ',');
            str1 = str1.replace('.', ',');
            String[] s1 = str1.split(",");
            String[] s2 = str2.split(",");

            for (int i = 0; i < s1.length; i++) {
                if (i <= s2.length - 1) {
                    if (s1[i].compareTo(s2[i]) < 0) {
                        System.out.println("com.lgcy.blog:" + s1[i] + "-0-" + s2[i]);
                        return true;
                    } else {
                        try {
                            System.out.println("com.lgcy.blog：" + s1[i] + "-0-" + s2[i]);
                            if (Integer.valueOf(s1[i]) < Integer.valueOf(s2[i])) {
                                return true;
                            } else if (Integer.valueOf(s1[i]) > Integer
                                    .valueOf(s2[i])) {
                                return false;
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if (s1.length < s2.length) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 单引号转化
     * 
     * @param value
     * @return
     */
    public static String signConvert(String value) {
        String result = "";
        if (!StringUtils.isEmpty(value)) {
            String strArray[] = value.split("'");
            if (strArray.length - 1 > 0) {
                for (int i = 0; i < strArray.length - 1; i++) {
                    result = result + strArray[i] + "''";
                }
                result = result + strArray[strArray.length - 1];
                System.out.println("com.lgcy.blog:" + "转义----->" + result);
            } else {
                result = value;
            }
            System.out.println("com.lgcy.blog:" + "result----->" + result);
        }

        return result;

    }


    /***
     * Decode 指url进行 UTF-8编码
     * 
     * @return  url编码后的字符串
     */
    public static String decode(String input) {

        try {
            input = URLDecoder.decode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return input;
    }

    /**
     * 是否合法的手机号码
     * 
     * @param str
     * @return
     */
    public static boolean isCellphone(String str) {

        // Pattern pattern = Pattern.compile("[0-9]{7,15}");
        Pattern pattern = Pattern
                .compile("^((13[0-9])|(147)|(15[^4,\\D])|(177)|(18[0-9]))\\d{8}$");
        // Pattern pattern = Pattern.compile("1\\d{10}");
        Matcher matcher = pattern.matcher(str);

        if (matcher.matches()) {
            return true;
        } else if (str == "" || str.length() < 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 是否电信手机号码
     * 
     * @param str
     * @return
     */
    public static boolean isCTCellphone(String str) {
        /*
         * 133 1349（卫星通信，原中国卫通） 153 180 181 189
         */

        Pattern pattern = Pattern
                .compile("^((133)|(134)|(139)|(153)|(177)|(180)|(181)|(189))\\d{8}$");
        Matcher matcher = pattern.matcher(str);

        if (matcher.matches()) {
            return true;
        } else if (str == "" || str.length() < 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断字符串是否是空或者任意个空格
     * 
     * @param str
     * @return
     */
    public static boolean isNullOrInfiniteEmpty(String str) {
        return str == null || "".equals(str) || str.matches("\\s+");
    }

    /**
     * 生成随机数
     * 
     * @param limits
     *            范围 如9999，代表4位数，999999，代表6位数
     * @return
     */
    public static int getRandom(int limits) {
        Random rand = new Random();
        int i = rand.nextInt();
        i = rand.nextInt(limits);
        System.out.println("com.lgcy.blog：" + "生成随机数----" + i);
        return i;
    }

    /**
     * 判断是否只有数字英文下划线组成
     * 
     * @param str
     * @return true - 是
     */
    public static boolean isEnglishOrNumber(String str) {
        return str.matches("^[0-9a-zA-Z_]{1,}");
    }

    /**
     * 字符串移除空格
     * 
     * @param str
     * @return
     */
    public static String removeAllSpace(String str) {
        String tmpstr = str.replace(" ", "");
        return tmpstr;
    }

    /**
     * 将URL中文转义
     * 
     * @param url
     * @return
     */
    public static String urlEncode(String url) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < url.length(); i++) {
            String strIndex = String.valueOf(url.charAt(i));
            if (isCharacter(strIndex) || " ".equals(strIndex)) {
                try {
                    builder.append(URLEncoder.encode(strIndex, "UTF8"));
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                builder.append(strIndex);
            }
        }
        return builder.toString().replace("+", "%20");
    }

    /**
     * 判断是否是email的正确格式
     * 
     * **/

    public static boolean checkEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-z0-9\\-]+\\.)+))([a-z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();

    }

        /***
     * 
     * 判断QQ格式是否正确
     * ***/
    public static boolean isQQ(String QQ) {
        String phone = "^[1-9]\\d{4,9}$";
        Pattern p = Pattern.compile(phone);
        Matcher m = p.matcher(QQ);
        return m.matches();
    }

    /**
     * 将data字节型数据转换为0~255 (0xFF 即BYTE)。
     * 
     * @param data
     * @return
     */
    public static int getUnsignedByte(byte data) {
        return data & 0x0FF;
    }

    /**
     * 通过给定的字符串获取对应的日期+时间
     * 
     * @param test
     * @return
     */
    public static String getDateTime(String test) {
        Pattern pattern = Pattern
                .compile("(\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2})\\.*");
        Matcher matcher = pattern.matcher(test);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /**
     * 通过给定的字符串获取对应的时间
     * 
     * @param test
     * @return
     */
    public static String getTime(String test) {
        Pattern pattern = Pattern.compile("(\\d{1,2}:\\d{1,2}:\\d{1,2})\\.*");
        Matcher matcher = pattern.matcher(test);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /**
     * 通过给定的字符串获取对应的日期
     * 
     * @param test
     * @return
     */
    public static String getDate(String test) {
        Pattern pattern = Pattern.compile("(\\d{4}-\\d{1,2}-\\d{1,2})\\.*");
        Matcher matcher = pattern.matcher(test);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /**
     * 获取字符串的MD5值
     * 
     * @param string
     * @return
     */
    public static String md5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(
                    string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10)
                hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
}