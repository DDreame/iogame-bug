package com.worrior.common.utils;

import com.alibaba.fastjson2.JSONObject;
import lombok.experimental.UtilityClass;

/***
 * @description : Json相关工具类
 * @author : 梦某人
 * @date : 2022/11/7 16:21 
 */
@UtilityClass
public class JsonUtils {
    /**
     * 检查是否为JsonObject
     * @param content
     * @return
     */
    public static boolean isJsonObject(String content){
        try {
            Object result = JSONObject.parseObject(content);
            if(result != null){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
