package com.itheima.em.sdk.ops.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itheima.em.sdk.EagleMapTemplate;
import com.itheima.em.sdk.config.EagleMapConfig;
import com.itheima.em.sdk.enums.ProviderEnum;
import com.itheima.em.sdk.exception.CommonException;
import com.itheima.em.sdk.ops.TraceFenceOperations;
import com.itheima.em.sdk.vo.PageResult;
import com.itheima.em.sdk.vo.TraceFence;
import com.itheima.em.sdk.vo.TraceTerminal;

import java.util.HashMap;
import java.util.Map;

/**
 * 电子围栏的功能操作
 *
 * @author zzj
 * @version 1.0
 * @date 2022/3/17
 */
public class DefaultTraceFenceOperations implements TraceFenceOperations {

    private EagleMapTemplate eagleMapTemplate;
    private EagleMapConfig eagleMapConfig;

    public DefaultTraceFenceOperations(EagleMapTemplate eagleMapTemplate) {
        this.eagleMapTemplate = eagleMapTemplate;
        this.eagleMapConfig = eagleMapTemplate.getEagleMapConfig();
    }

    private Long createFence(String url, ProviderEnum provider, Long serverId, String name, String desc, Map<String, Object> param) {
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("serverId", serverId);
        requestParam.put("name", name);
        requestParam.put("desc", desc);
        requestParam.put("param", param);
        return this.eagleMapTemplate.getJsonHttpApiService().doPost(url, requestParam, response -> {
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
    public Long createCircleFence(ProviderEnum provider, Long serverId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/circle";
        return this.createFence(url, provider, serverId, name, desc, param);
    }

    @Override
    public Long createCircleFence(Long serverId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/circle";
        return this.createFence(url, ProviderEnum.NONE, serverId, name, desc, param);
    }

    @Override
    public Long createPolygonFence(ProviderEnum provider, Long serverId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/polygon";
        return this.createFence(url, provider, serverId, name, desc, param);
    }

    @Override
    public Long createPolygonFence(Long serverId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/polygon";
        return this.createFence(url, ProviderEnum.NONE, serverId, name, desc, param);
    }

    @Override
    public Long createPolylineFence(ProviderEnum provider, Long serverId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/polyline";
        return this.createFence(url, provider, serverId, name, desc, param);
    }

    @Override
    public Long createPolylineFence(Long serverId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/polyline";
        return this.createFence(url, ProviderEnum.NONE, serverId, name, desc, param);
    }

    @Override
    public Long createDistrictFence(ProviderEnum provider, Long serverId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/district";
        return this.createFence(url, provider, serverId, name, desc, param);
    }

    @Override
    public Long createDistrictFence(Long serverId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/district";
        return this.createFence(url, ProviderEnum.NONE, serverId, name, desc, param);
    }

    private Boolean updateFence(String url, ProviderEnum provider, Long serverId, Long fenceId, String name, String desc, Map<String, Object> param) {
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("serverId", serverId);
        requestParam.put("fenceId", fenceId);
        requestParam.put("name", name);
        requestParam.put("desc", desc);
        requestParam.put("param", param);
        return this.eagleMapTemplate.getJsonHttpApiService().doPut(url, requestParam, response -> {
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
    public Boolean updateCircleFence(ProviderEnum provider, Long serverId, Long fenceId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/circle";
        return this.updateFence(url, provider, serverId, fenceId, name, desc, param);
    }

    @Override
    public Boolean updateCircleFence(Long serverId, Long fenceId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/circle";
        return this.updateFence(url, ProviderEnum.NONE, serverId, fenceId, name, desc, param);
    }

    @Override
    public Boolean updatePolygonFence(ProviderEnum provider, Long serverId, Long fenceId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/polygon";
        return this.updateFence(url, provider, serverId, fenceId, name, desc, param);
    }

    @Override
    public Boolean updatePolygonFence(Long serverId, Long fenceId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/polygon";
        return this.updateFence(url, ProviderEnum.NONE, serverId, fenceId, name, desc, param);
    }

    @Override
    public Boolean updatePolylineFence(ProviderEnum provider, Long serverId, Long fenceId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/polyline";
        return this.updateFence(url, provider, serverId, fenceId, name, desc, param);
    }

    @Override
    public Boolean updatePolylineFence(Long serverId, Long fenceId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/polyline";
        return this.updateFence(url, ProviderEnum.NONE, serverId, fenceId, name, desc, param);
    }

    @Override
    public Boolean updateDistrictFence(ProviderEnum provider, Long serverId, Long fenceId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/district";
        return this.updateFence(url, provider, serverId, fenceId, name, desc, param);
    }

    @Override
    public Boolean updateDistrictFence(Long serverId, Long fenceId, String name, String desc, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/fence/district";
        return this.updateFence(url, ProviderEnum.NONE, serverId, fenceId, name, desc, param);
    }

    @Override
    public Boolean deleteFence(ProviderEnum provider, Long serverId, Long... fenceIds) {
        String url = eagleMapConfig.getUri() + "/api/fence";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("serverId", serverId);
        requestParam.put("fenceIds", fenceIds);
        return this.eagleMapTemplate.getJsonHttpApiService().doDelete(url, requestParam, response -> {
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
    public Boolean deleteFence(Long serverId, Long... fenceIds) {
        return this.deleteFence(ProviderEnum.NONE, serverId, fenceIds);
    }

    private Boolean executeBindOrUnBind(String url, ProviderEnum provider, Long serverId, Long fenceId, Long... terminalIds) {
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("serverId", serverId);
        requestParam.put("fenceId", fenceId);
        requestParam.put("terminalIds", terminalIds);
        return this.eagleMapTemplate.getJsonHttpApiService().doPost(url, requestParam, response -> {
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
    public Boolean bindTerminalFence(ProviderEnum provider, Long serverId, Long fenceId, Long... terminalIds) {
        String url = eagleMapConfig.getUri() + "/api/fence/bind";
        return this.executeBindOrUnBind(url, provider, serverId, fenceId, terminalIds);
    }

    @Override
    public Boolean bindTerminalFence(Long serverId, Long fenceId, Long... terminalIds) {
        String url = eagleMapConfig.getUri() + "/api/fence/bind";
        return this.executeBindOrUnBind(url, ProviderEnum.NONE, serverId, fenceId, terminalIds);
    }

    @Override
    public Boolean unbindTerminalFence(ProviderEnum provider, Long serverId, Long fenceId, Long... terminalIds) {
        String url = eagleMapConfig.getUri() + "/api/fence/unbind";
        return this.executeBindOrUnBind(url, provider, serverId, fenceId, terminalIds);
    }

    @Override
    public Boolean unbindTerminalFence(Long serverId, Long fenceId, Long... terminalIds) {
        String url = eagleMapConfig.getUri() + "/api/fence/unbind";
        return this.executeBindOrUnBind(url, ProviderEnum.NONE, serverId, fenceId, terminalIds);
    }

    @Override
    public PageResult<TraceTerminal> queryTerminalFenceList(ProviderEnum provider, Long serverId, Long fenceId, Integer page, Integer pageSize) {
        String url = eagleMapConfig.getUri() + "/api/fence/terminal";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("serverId", serverId);
        requestParam.put("fenceId", fenceId);
        requestParam.put("page", page);
        requestParam.put("pageSize", pageSize);
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, requestParam, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return PageResult.toBean(jsonObject, TraceTerminal.class);
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public PageResult<TraceTerminal> queryTerminalFenceList(Long serverId, Long fenceId, Integer page, Integer pageSize) {
        return this.queryTerminalFenceList(ProviderEnum.NONE, serverId, fenceId, page, pageSize);
    }

    @Override
    public PageResult<TraceFence> queryFenceList(ProviderEnum provider, Integer page, Integer pageSize) {
        String url = eagleMapConfig.getUri() + "/api/fence/list";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("page", page);
        requestParam.put("pageSize", pageSize);
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, requestParam, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return PageResult.toBean(jsonObject, TraceFence.class);
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public PageResult<TraceFence> queryFenceList(Integer page, Integer pageSize) {
        return this.queryFenceList(ProviderEnum.NONE, page, pageSize);
    }

    @Override
    public TraceFence queryByFenceId(ProviderEnum provider, Long serverId, Long fenceId) {
        String url = eagleMapConfig.getUri() + "/api/fence";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("serverId", serverId);
        requestParam.put("fenceId", fenceId);
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, requestParam, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return JSONUtil.toBean(jsonObject.getJSONObject("data"), TraceFence.class);
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public TraceFence queryByFenceId(Long serverId, Long fenceId) {
        return this.queryByFenceId(ProviderEnum.NONE, serverId, fenceId);
    }

    @Override
    public Boolean queryTerminalStatus(ProviderEnum provider, Long serverId, Long fenceId, Long terminalId) {
        String url = eagleMapConfig.getUri() + "/api/fence/status";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("serverId", serverId);
        requestParam.put("fenceId", fenceId);
        requestParam.put("terminalId", terminalId);
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, requestParam, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return jsonObject.getBool("data");
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public Boolean queryTerminalStatus(Long serverId, Long fenceId, Long terminalId) {
        return this.queryTerminalStatus(ProviderEnum.NONE, serverId, fenceId, terminalId);
    }
}
