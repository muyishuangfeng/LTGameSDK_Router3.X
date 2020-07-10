package com.gnetop.ltgame.router;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 返回数据
 */
public class YRouterResponse {

    public final static int ROUTER_SUCCESS_CODE = 1001;
    public final static int ROUTER_FAIL_CODE = 1002;
    public final static String ROUTER_SUCCESS_DESC = "success";
    public final static String ROUTER_FAIL_DESC = "fail";
    private int statusCode;
    private String statusDesc;
    private Object body;

    /**
     * 设置状态
     */
    public void setStatus(int code, String statusDesc, Object body) {
        this.statusCode = code;
        this.statusDesc = statusDesc;
        this.body = body;
    }

    /**
     * 获取结果
     */
    public JSONObject getResult() {
        JSONObject mResult = null;
        try {
            mResult = new JSONObject()
                    .put("statusCode", statusCode)
                    .put("statusDesc", statusDesc)
                    .put("body", body);
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return mResult;

    }
}
