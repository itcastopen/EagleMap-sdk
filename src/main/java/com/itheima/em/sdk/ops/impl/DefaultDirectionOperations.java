package com.itheima.em.sdk.ops.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itheima.em.sdk.EagleMapTemplate;
import com.itheima.em.sdk.config.EagleMapConfig;
import com.itheima.em.sdk.enums.ProviderEnum;
import com.itheima.em.sdk.exception.CommonException;
import com.itheima.em.sdk.ops.DirectionOperations;
import com.itheima.em.sdk.vo.Coordinate;

import java.util.HashMap;
import java.util.Map;

/**
 * 路线规划相关业务
 *
 * @author zzj
 * @version 1.0
 * @date 2022/3/15
 */
public class DefaultDirectionOperations implements DirectionOperations {

    private EagleMapTemplate eagleMapTemplate;
    private EagleMapConfig eagleMapConfig;

    public DefaultDirectionOperations(EagleMapTemplate eagleMapTemplate) {
        this.eagleMapTemplate = eagleMapTemplate;
        this.eagleMapConfig = eagleMapTemplate.getEagleMapConfig();
    }

    @Override
    public String driving(ProviderEnum provider, Coordinate origin, Coordinate destination, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/direction/driving";
        return this.execute(url, provider, origin, destination, param);
    }

    @Override
    public String driving(ProviderEnum provider, Coordinate origin, Coordinate destination) {
        return this.driving(provider, origin, destination, null);
    }

    @Override
    public String driving(Coordinate origin, Coordinate destination) {
        return this.driving(ProviderEnum.NONE, origin, destination, null);
    }

    @Override
    public String driving(Coordinate origin, Coordinate destination, Map<String, Object> param) {
        return this.driving(ProviderEnum.NONE, origin, destination, param);
    }

    private String execute(String url, ProviderEnum provider, Coordinate origin, Coordinate destination, Map<String, Object> param) {
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("origin", origin);
        requestParam.put("destination", destination);
        requestParam.put("param", param);
        return this.eagleMapTemplate.getJsonHttpApiService().doPost(url, requestParam, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return jsonObject.getStr("data");
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public String walking(ProviderEnum provider, Coordinate origin, Coordinate destination, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/direction/walking";
        return this.execute(url, provider, origin, destination, param);
    }

    @Override
    public String walking(ProviderEnum provider, Coordinate origin, Coordinate destination) {
        return this.walking(provider, origin, destination, null);
    }

    @Override
    public String walking(Coordinate origin, Coordinate destination) {
        return this.walking(ProviderEnum.NONE, origin, destination, null);
    }

    @Override
    public String walking(Coordinate origin, Coordinate destination, Map<String, Object> param) {
        return this.walking(ProviderEnum.NONE, origin, destination, param);
    }

    @Override
    public String bicycling(ProviderEnum provider, Coordinate origin, Coordinate destination, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/direction/bicycling";
        return this.execute(url, provider, origin, destination, param);
    }

    @Override
    public String bicycling(ProviderEnum provider, Coordinate origin, Coordinate destination) {
        return this.bicycling(provider, origin, destination, null);
    }

    @Override
    public String bicycling(Coordinate origin, Coordinate destination) {
        return this.bicycling(ProviderEnum.NONE, origin, destination, null);
    }

    @Override
    public String bicycling(Coordinate origin, Coordinate destination, Map<String, Object> param) {
        return this.bicycling(ProviderEnum.NONE, origin, destination, null);
    }
}
