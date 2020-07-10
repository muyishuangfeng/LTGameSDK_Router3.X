package com.gnetop.ltgame.router;

import android.content.Context;

import com.gnetop.ltgame.router.util.YLog;

import java.util.HashMap;

public class YRouter {

    private static volatile YRouter sInstance;
    private HashMap<String, YAction> mActions = null;

    private YRouter() {
        mActions = new HashMap<>();
    }

    /**
     * 单例
     */
    public static YRouter getInstance() {
        if (sInstance == null) {
            synchronized (YRouter.class) {
                if (sInstance == null) {
                    sInstance = new YRouter();
                }
            }
        }
        return sInstance;
    }

    /**
     * 注册
     */
    public void registerAction(String action, YAction mYAction) {
        if (mActions.containsKey(action)) {
            YLog.e(YLog.TAG, "SRouter/registerAction():action has register!");
            return;
        }
        mActions.put(action, mYAction);
    }

    /**
     * 发送消息
     */
    public YRouterResponse sendMessage(Context context, YRouterRequest mRequest) {
        YRouterResponse mResponse = new YRouterResponse();
        YAction mAction = findRequest(mRequest);
        if (mAction != null) {
            Object object = mAction.startAction(context, mRequest.getData());
            mResponse.setStatus(YRouterResponse.ROUTER_SUCCESS_CODE,
                    YRouterResponse.ROUTER_SUCCESS_DESC,
                    object);
        } else {
            mResponse.setStatus(YRouterResponse.ROUTER_FAIL_CODE,
                    YRouterResponse.ROUTER_FAIL_DESC,
                    "can not find this action,check to see if you have been registered!");
        }
        return mResponse;

    }

    /**
     * 找到请求
     */
    public YAction findRequest(YRouterRequest request) {
        String action = request.getAction();
        if (mActions.containsKey(action)) {
            return mActions.get(action);
        }
        return null;
    }

}
