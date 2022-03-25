package com.itheima.em.sdk.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.itheima.em.sdk.config.EagleMapConfig;

import java.util.Map;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/14
 */
public class JsonHttpApiService extends HttpApiService {

    private EagleMapConfig eagleMapConfig;

    public JsonHttpApiService(EagleMapConfig eagleMapConfig) {
        this.eagleMapConfig = eagleMapConfig;
    }

    @Override
    protected void setRequestParam(HttpRequest httpRequest, Map<String, Object> param) {
        //设置form表单参数
        httpRequest.body(JSONUtil.toJsonStr(param));
    }

    @Override
    protected int getTimeOut() {
        return this.eagleMapConfig.getTimeout();
    }
}
