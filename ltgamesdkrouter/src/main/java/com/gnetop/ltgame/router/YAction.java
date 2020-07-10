package com.gnetop.ltgame.router;

import android.content.Context;

import java.util.HashMap;

/**
 * 动作
 */
public abstract class YAction {
    /**
     * 发送动作
     *
     * @param context     上下文
     * @param requestData 请求数据
     */
    public abstract Object startAction(Context context, HashMap<String, Object> requestData);
}
