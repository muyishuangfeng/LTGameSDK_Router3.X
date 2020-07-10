package com.gnetop.ltgame.router;

import java.util.HashMap;

/**
 * 请求
 */
public class YRouterRequest {

    private String action;
    private HashMap<String, Object> data;

    private YRouterRequest() {
        this.data = new HashMap<>();
    }

    /**
     * 创建
     */
    public static YRouterRequest create() {
        return new YRouterRequest();
    }

    /**
     * 传递数据
     */
    public YRouterRequest data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    /**
     * 设置动作
     */
    public YRouterRequest action(String action) {
        this.action = action;
        return this;
    }

    /**
     * 获取动作
     */
    public String getAction() {
        return this.action;
    }

    /**
     * 获取数据
     */
    public HashMap<String, Object> getData() {
        return this.data;
    }

}
