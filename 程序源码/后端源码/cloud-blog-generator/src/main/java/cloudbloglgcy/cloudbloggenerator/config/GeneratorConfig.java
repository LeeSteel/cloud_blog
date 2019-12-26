package cloudbloglgcy.cloudbloggenerator.config;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @author: 李钢 2580704698@qq.com
 * @date: 2019/10/22 13:22
 * @Copyright: Copyright (c) 2019
 */
public class GeneratorConfig {

    public static Map<String, Object> configMap        = new HashMap<>();
    private static final String       CONFIG_FILE_NAME = "generatorconfig.properties";
    //类加载时初始化
    static
    {
        loadProperties();
    }

    /**
     *
     * @描述: 读取加载配置文件,并初始化
     * @作者: 李钢 ligangcfy@thinkive.com
     * @时间: 2019年8月28日 上午10:53:16
     */
    private static void loadProperties()
    {
        try
        {
            ClassLoader loader = GeneratorConfig.class.getClassLoader();
            Properties properties = new Properties();

            BufferedReader bf = new BufferedReader(new InputStreamReader(loader.getResource(CONFIG_FILE_NAME).openStream(),"UTF-8"));
            properties.load(bf);
            Iterator<Map.Entry<Object, Object>> it = properties.entrySet().iterator();
            while (it.hasNext())
            {
                Map.Entry<String, Object> entry = (Map.Entry) it.next();
                String key = entry.getKey();
                Object value = entry.getValue()  ;
                //把配置文件信息 保存到配置中
                configMap.put(key, value);

            }
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }


    }

    public static Object getValue(String key)
    {
        return configMap.get(key);
    }



    public static String getStringValue(String key)
    {
        return ""+configMap.get(key);
    }

    public static Boolean getBooleanValue(String key)
    {
        return Boolean.valueOf(""+configMap.get(key));
    }
}
