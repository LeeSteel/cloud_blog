package com.lgcy.blog.utils.base;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.List;


/**
 * 
* @ClassName: JsonUtilsController
* @Description: TODO(JSON工具类控制层)
* @author hasee
 * @param <T>
* @date 2019年9月2日
*
 */
public class JsonUtils<T> {
	
	/**
	 * 
	* @Title: json2Obj
	* @Description: TODO(将json字符串转换为实体类对象)
	* @param @param json	JSON字符串
	* @param @return    参数
	* @return Object    返回类型
	* @throws null
	 */
	public static Object json2Obj(String json) {
		try {
			com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
			Object entiy = mapper.readValue(json, Object.class);
			return entiy;
		} catch (com.fasterxml.jackson.core.JsonParseException e) {
			e.printStackTrace();
		} catch (com.fasterxml.jackson.databind.JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
 
	/**
	 * 
	* @Title: toJSONString
	* @Description: TODO(将List对象序列化为JSON文本)
	* @param @param <T>
	* @param @param list	list对象
	* @param @return    参数
	* @return String    返回类型
	* @throws null
	 */
	public static <T> String toJSONString(List<T> list) {
		JSONArray jsonArray = JSONArray.fromObject(list);
 
		return jsonArray.toString();
	}
 
	/**
	 * 
	* @Title: toJSONString
	* @Description: TODO(将对象序列化为JSON字符串)
	* @param @param object	实体对象
	* @param @return    参数
	* @return String    返回类型
	* @throws null
	 */
	public static String toJSONString(Object object) {
		JSONArray jsonArray = JSONArray.fromObject(object);
 
		return jsonArray.toString();
	}
 
	/**
	 * 
	* @Title: obj2Json
	* @Description: TODO(将对象object转换为json字符串.)
	* @param @param object	实体对象
	* @param @return    参数
	* @return String    返回类型
	* @throws null
	 */
	public static String obj2Json(Object object) {
		try {
			com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
			String json = mapper.writeValueAsString(object);
			return json;
		} catch (com.fasterxml.jackson.core.JsonGenerationException e) {
			e.printStackTrace();
		} catch (com.fasterxml.jackson.databind.JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
 
	/**
	 * 
	* @Title: toJSONString
	* @Description: TODO(将JSON对象数组序列化为JSON文本)
	* @param @param jsonArray	JSON集合对象
	* @param @return    参数
	* @return String    返回类型
	* @throws null
	 */
	public static String toJSONString(JSONArray jsonArray) {
		return jsonArray.toString();
	}
 
	/**
	 * 
	* @Title: toJSONString
	* @Description: TODO(将JSON对象序列化为JSON文本)
	* @param @param jsonObject	JSON对象
	* @param @return    参数
	* @return String    返回类型
	* @throws null
	 */
	public static String toJSONString(JSONObject jsonObject) {
		return jsonObject.toString();
	}
 

	/**
	 * 
	* @Title: toJSONArray
	* @Description: TODO(将对象转换为JSON对象数组)
	* @param @param object	实体对象
	* @param @return    参数
	* @return JSONArray    返回类型
	* @throws null
	 */
	public static JSONArray toJSONArray(Object object) {
		return JSONArray.fromObject(object);
	}
 
	/**
	 * 
	* @Title: toJSONObject
	* @Description: TODO(将对象转换为JSON对象)
	* @param @param object	实体对象
	* @param @return    参数
	* @return JSONObject    返回类型
	* @throws null
	 */
	public static JSONObject toJSONObject(Object object) {
		return JSONObject.fromObject(object);
	}
 
	/**
	 * 
	* @Title: toHashMap
	* @Description: TODO(将对象转换为HashMap)
	* @param @param object
	* @param @return    参数
	* @return HashMap    返回类型
	* @throws null
	 */
/*	public static HashMap toHashMap(Object object) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		JSONObject jsonObject = JsonUtils.toJSONObject(object);
		Iterator it = jsonObject.keys();
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			Object value = jsonObject.get(key);
			data.put(key, value);
		}
 
		return data;
	}*/
 
	/**
	 * 
	* @Title: toList
	* @Description: TODO(将对象转换为List)
	* @param @param object
	* @param @return    参数
	* @return List<Map<String,Object>>    返回类型
	* @throws null
	 */
	// 返回非实体类型(Map)的List
/*	public static List<Map<String, Object>> toList(Object object) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		JSONArray jsonArray = JSONArray.fromObject(object);
		for (Object obj : jsonArray) {
			JSONObject jsonObject = (JSONObject) obj;
			Map<String, Object> map = new HashMap<String, Object>();
			Iterator it = jsonObject.keys();
			while (it.hasNext()) {
				String key = (String) it.next();
				Object value = jsonObject.get(key);
				map.put((String) key, value);
			}
			list.add(map);
		}
		return list;
	}*/
 
	/**
	 * 
	* @Title: toList
	* @Description: TODO(将JSON对象数组转换为传入类型的List)
	* @param @param <T>	对象类型
	* @param @param jsonArray
	* @param @param objectClass
	* @param @return    参数
	* @return List<T>    返回类型
	* @throws null
	 */
	public static <T> List<T> toList(JSONArray jsonArray, Class<T> objectClass) {
		return JSONArray.toList(jsonArray, objectClass);
	}
 
	/**
	 * 
	* @Title: toList
	* @Description: TODO(将对象转换为传入类型的List)
	* @param @param <T>
	* @param @param object
	* @param @param objectClass
	* @param @return    参数
	* @return List<T>    返回类型
	* @throws null
	 */
	public static <T> List<T> toList(Object object, Class<T> objectClass) {
		JSONArray jsonArray = JSONArray.fromObject(object);
 
		return JSONArray.toList(jsonArray, objectClass);
	}
}
