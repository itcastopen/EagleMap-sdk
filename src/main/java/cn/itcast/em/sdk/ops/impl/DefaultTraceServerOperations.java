package cn.itcast.em.sdk.ops.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.itcast.em.sdk.EagleMapTemplate;
import cn.itcast.em.sdk.config.EagleMapConfig;
import cn.itcast.em.sdk.enums.ProviderEnum;
import cn.itcast.em.sdk.exception.CommonException;
import cn.itcast.em.sdk.ops.TraceServerOperations;
import cn.itcast.em.sdk.vo.TraceServer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 轨迹服务的管理操作
 *
 * @author zzj
 * @version 1.0
 * @date 2022/3/15
 */
public class DefaultTraceServerOperations implements TraceServerOperations {

    private EagleMapTemplate eagleMapTemplate;
    private EagleMapConfig eagleMapConfig;

    public DefaultTraceServerOperations(EagleMapTemplate eagleMapTemplate) {
        this.eagleMapTemplate = eagleMapTemplate;
        this.eagleMapConfig = eagleMapTemplate.getEagleMapConfig();
    }

    @Override
    public Long create(String name, String desc) {
        String url = eagleMapConfig.getUri() + "/api/trace/server";
        Map<String, Object> param = new HashMap<>();
        param.put("provider", ProviderEnum.AMAP.getName());
        param.put("name", name);
        param.put("desc", desc);
        return this.eagleMapTemplate.getJsonHttpApiService().doPost(url, param, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return jsonObject.getLong("data");
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public Long create(String name) {
        return this.create(name, null);
    }

    @Override
    public Boolean delete(ProviderEnum provider, Long serverId) {
        String url = eagleMapConfig.getUri() + "/api/trace/server";
        Map<String, Object> param = new HashMap<>();
        param.put("provider", provider.getName());
        param.put("serverId", serverId);
        return this.eagleMapTemplate.getJsonHttpApiService().doDelete(url, param, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return true;
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return false;
        });
    }

    @Override
    public Boolean delete(Long serverId) {
        return this.delete(ProviderEnum.NONE, serverId);
    }

    @Override
    public Boolean update(ProviderEnum provider, Long serverId, String name, String desc) {
        String url = eagleMapConfig.getUri() + "/api/trace/server";
        Map<String, Object> param = new HashMap<>();
        param.put("provider", provider.getName());
        param.put("serverId", serverId);
        param.put("name", name);
        param.put("desc", desc);
        return this.eagleMapTemplate.getJsonHttpApiService().doPut(url, param, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return true;
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return false;
        });
    }

    @Override
    public Boolean update(Long serverId, String name, String desc) {
        return this.update(ProviderEnum.NONE, serverId, name, desc);
    }

    @Override
    public Boolean update(Long serverId, String name) {
        return this.update(ProviderEnum.NONE, serverId, name, null);
    }

    @Override
    public TraceServer queryById(ProviderEnum provider, Long serverId) {
        String url = eagleMapConfig.getUri() + "/api/trace/server/" + serverId;
        Map<String, Object> param = new HashMap<>();
        param.put("provider", provider.getName());
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, param, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return JSONUtil.toBean(jsonObject.getJSONObject("data"), TraceServer.class);
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public TraceServer queryById(Long serverId) {
        return this.queryById(ProviderEnum.NONE, serverId);
    }

    @Override
    public List<TraceServer> queryAll(ProviderEnum provider) {
        String url = eagleMapConfig.getUri() + "/api/trace/server/";
        Map<String, Object> param = new HashMap<>();
        param.put("provider", provider.getName());
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, param, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return JSONUtil.toList(jsonObject.getJSONArray("data"), TraceServer.class);
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public List<TraceServer> queryAll() {
        return this.queryAll(ProviderEnum.NONE);
    }
}
