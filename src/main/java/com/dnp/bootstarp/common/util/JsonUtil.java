package com.dnp.bootstarp.common.util;

import org.json.JSONObject;

/**
 * Created by huazai on 2017/8/10.
 */
public class JsonUtil {
    /**
     * 创建分页json对象
     *
     * @param total 信息总条数
     * @param rows  信息分页集合
     * @return jsonobject
     */
    public static JSONObject createPage(Integer total, Object rows) {
        JSONObject pageJson = new JSONObject();
        pageJson.put("total", total);
        pageJson.put("rows", rows);
        return  pageJson;
    }
}
