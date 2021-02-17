package com.ohei.framework.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 提供Json格式字符串与对象之间的相互转化
 */
@Slf4j
public final class JsonUtil {

    // 全局对象映射（线程安全）
    private static final ObjectMapper mapper = new ObjectMapper();
    // 全局对象映射（HTML专用，线程安全）
    private static final ObjectMapper mapperForHtml = new ObjectMapper();
    //日期格式化为时间戳
    private static final ObjectMapper mapperForTimeStamp = new ObjectMapper();

    // 不可创建本类实例
    private JsonUtil() {
    }

    static {
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // 设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapperForHtml.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapperForTimeStamp.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        mapperForTimeStamp.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    public static String toJsonWithTimestamp(Object obj) {
        if (null != obj) {
            try {
                return mapperForTimeStamp.writeValueAsString(obj);
            } catch (IOException e) {
                log.error("toJson ERROR: ", e);
            }
        }
        return null;
    }


    /**
     * 将对象转化为Json格式字符串
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        if (null != obj) {
            try {
                return mapper.writeValueAsString(obj);
            } catch (IOException e) {
                log.error("toJson ERROR: ", e);
                return null;
            }
        }
        return null;
    }

    /**
     * 将对象转化为Json格式字符串
     *
     * @param obj
     * @return
     */
    public static byte[] toJsonBytes(Object obj) {
        if (null != obj) {
            try {
                return mapper.writeValueAsBytes(obj);
            } catch (IOException e) {
                log.error("toJson ERROR: ", e);
                return null;
            }
        }
        return null;
    }

    /**
     * 将对象转化为Json格式字符串，并进行html编码
     *
     * @param obj
     * @return
     */
    public static String toJsonForHtml(Object obj) throws Exception {
        return mapperForHtml.writeValueAsString(obj);
    }

    /**
     * 将Json格式字符串转化为对象
     *
     * @param <T>
     * @param json
     * @param type
     * @return
     */
    public static <T> T toObject(String json, Class<T> type) {
        if (StringUtils.isNotBlank(json)) {
            try {
                return mapper.readValue(json, type);
            } catch (Exception e) {
                log.error("toObject ERROR: ", e);
                return null;
            }
        }
        return null;
    }

    /**
     * 将json字节数组转成java对象
     *
     * @param bytes
     * @param type
     * @return
     */
    public static <T> T toObject(byte[] bytes, Class<T> type) {
        if (bytes != null && bytes.length > 0) {
            try {
                return mapper.readValue(bytes, type);
            } catch (Exception e) {
                log.error("toObject ERROR: ", e);
                return null;
            }
        }
        return null;
    }

    /**
     * 将Json格式字符串转化为集合
     *
     * @param <T>
     * @param json
     * @param type
     * @return
     */
    public static <T> T toObject(String json, TypeReference<T> type) {
        if (StringUtils.isNotBlank(json)) {
            try {
                return mapper.readValue(json, type);
            } catch (Exception e) {
                log.error("toObject ERROR: ", e);
                return null;
            }
        }
        return null;
    }

    /**
     * 将Json格式字符串转化为JsonNode
     *
     * @param json
     * @return
     */
    public static JsonNode toJsonNode(String json) {
        if (StringUtils.isNotBlank(json)) {
            try {
                return mapper.readTree(json);
            } catch (Exception e) {
                log.error("toObject ERROR: ", e);
                return null;
            }
        }
        return null;
    }

    /**
     * 将Json字节数组转化为集合
     *
     * @param <T>
     * @param type
     * @return
     */
    public static <T> T toObject(byte[] bytes, TypeReference<T> type) {
        if (bytes != null && bytes.length > 0) {
            try {
                return mapper.readValue(bytes, type);
            } catch (Exception e) {
                log.error("toObject ERROR: ", e);
                return null;
            }
        }
        return null;
    }

    public static <T> List<T> toList(String json, Class<T> t) {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, t);
        try {
            return mapper.readValue(json, javaType);
        } catch (Exception e) {
            log.error("toJson toList: ", e);
            return null;
        }
    }

    /**
     * 将Json格式字符串转化为集合
     *
     * @param <T>
     * @param json
     * @return
     */
    public static <T> T toMapObject(String json) {
        if (StringUtils.isNotBlank(json)) {
            try {
                MapType type = mapper.getTypeFactory().constructMapType(Map.class, String.class, Object.class);
                return mapper.readValue(json, type);
            } catch (Exception e) {
                log.error("toJson toMapObject: ", e);
                return null;
            }
        }
        return null;
    }

    /**
     * 将Json格式字符串转化map
     *
     * @param json
     * @return
     */
    public static <T1, T2> Map<T1, T2> toMapObject(String json, Class<T1> keyClazz, Class<T2> valueClazz) {
        if (StringUtils.isNotBlank(json)) {
            try {
                return mapper.readValue(json, TypeFactory.defaultInstance().constructMapType(Map.class, keyClazz, valueClazz));
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        return null;
    }

    public static <T1, T2> Map<T1, List<T2>> toMapObject(String json, Class<T1> keyClazz, Class<T2> valueClazz, @SuppressWarnings("rawtypes") Class<List> collectionClazz) {
        if (StringUtils.isNotBlank(json)) {
            try {
                JavaType setType = mapper.getTypeFactory().constructCollectionType(collectionClazz, valueClazz);
                JavaType keyType = mapper.getTypeFactory().constructType(keyClazz);
                return mapper.readValue(json, TypeFactory.defaultInstance().constructMapType(Map.class, keyType, setType));
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static <T1, T2, T3> Map<T1, Map<T2, T3>> toMapObject(String json, Class<T1> keyClazz, Class<T2> valueKey, Class<T3> valueClazz, @SuppressWarnings("rawtypes") Class<? extends Map> mapClass) {
        if (StringUtils.isNotBlank(json)) {
            try {
                JavaType setType = mapper.getTypeFactory().constructMapType(mapClass, valueKey, valueClazz);
                JavaType keyType = mapper.getTypeFactory().constructType(keyClazz);
                return mapper.readValue(json, TypeFactory.defaultInstance().constructMapType(Map.class, keyType, setType));
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static ObjectNode createObjectNode() {
        return mapper.createObjectNode();
    }

    public static <T> T toObject(JsonNode jsonNode, Class<T> clazz) {
        try {
            return mapper.readValues(jsonNode.traverse(), clazz).next();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> T mapToObject(Map<String, Object> map, Class<T> tClass) {
        if (map == null) {
            return null;
        }
        return mapperForTimeStamp.convertValue(map, tClass);
    }

    public static Map<String, Object> objectToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        return mapperForTimeStamp.convertValue(obj, TypeFactory.defaultInstance().constructMapType(Map.class, String.class, Object.class));
    }

    @SuppressWarnings("unchecked")
    public static <P, C> P toJavaBean(String json, Class<P> parent, Class<C> child) {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(parent, child);
        try {
            return mapper.readValue(json, javaType);
        } catch (Exception e) {
            log.error("toJavaBean: ", e);
            return null;
        }
    }
}