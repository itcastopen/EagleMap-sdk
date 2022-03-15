package cn.itcast.em.sdk.ops.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.itcast.em.sdk.EagleMapTemplate;
import cn.itcast.em.sdk.config.EagleMapConfig;
import cn.itcast.em.sdk.enums.ServerType;
import cn.itcast.em.sdk.exception.CommonException;
import cn.itcast.em.sdk.ops.DirectionOperations;
import cn.itcast.em.sdk.vo.CoordinateVo;

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
    public String driving(ServerType provider, CoordinateVo origin, CoordinateVo destination, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/direction/driving";
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
    public String driving(ServerType provider, CoordinateVo origin, CoordinateVo destination) {
        return this.driving(provider, origin, destination, null);
    }

    @Override
    public String driving(CoordinateVo origin, CoordinateVo destination) {
        return this.driving(ServerType.NONE, origin, destination, null);
    }

    @Override
    public String driving(CoordinateVo origin, CoordinateVo destination, Map<String, Object> param) {
        return this.driving(ServerType.NONE, origin, destination, param);
    }
}
