package cn.itcast.em.sdk.ops.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.itcast.em.sdk.EagleMapTemplate;
import cn.itcast.em.sdk.config.EagleMapConfig;
import cn.itcast.em.sdk.enums.ProviderEnum;
import cn.itcast.em.sdk.exception.CommonException;
import cn.itcast.em.sdk.ops.TraceTerminalOperations;
import cn.itcast.em.sdk.vo.PageResult;
import cn.itcast.em.sdk.vo.TraceTerminal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/16
 */
public class DefaultTraceTerminalOperations implements TraceTerminalOperations {

    private EagleMapTemplate eagleMapTemplate;
    private EagleMapConfig eagleMapConfig;

    public DefaultTraceTerminalOperations(EagleMapTemplate eagleMapTemplate) {
        this.eagleMapTemplate = eagleMapTemplate;
        this.eagleMapConfig = eagleMapTemplate.getEagleMapConfig();
    }

    @Override
    public Long create(ProviderEnum provider, Long serverId, String name, String desc, Map<String, Object> props) {
        String url = eagleMapConfig.getUri() + "/api/trace/terminal";
        Map<String, Object> param = new HashMap<>();
        param.put("provider", provider.getName());
        param.put("serverId", serverId);
        param.put("name", name);
        param.put("desc", desc);
        param.put("props", props);
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
    public Long create(ProviderEnum provider, String name, String desc, Map<String, Object> props) {
        return this.create(provider, null, name, desc, props);
    }

    @Override
    public Long create(Long serverId, String name, String desc, Map<String, Object> props) {
        return this.create(ProviderEnum.NONE, serverId, name, desc, props);
    }

    @Override
    public Long create(String name, String desc, Map<String, Object> props) {
        return this.create(ProviderEnum.NONE, null, name, desc, props);
    }

    @Override
    public Long create(ProviderEnum provider, Long serverId, String name, String desc) {
        return this.create(ProviderEnum.NONE, serverId, name, desc, null);
    }

    @Override
    public Long create(ProviderEnum provider, String name, String desc) {
        return this.create(ProviderEnum.NONE, null, name, desc, null);
    }

    @Override
    public Long create(Long serverId, String name, String desc) {
        return this.create(ProviderEnum.NONE, serverId, name, desc, null);
    }

    @Override
    public Long create(String name, String desc) {
        return this.create(ProviderEnum.NONE, null, name, desc, null);
    }

    @Override
    public Boolean delete(ProviderEnum provider, Long serverId, Long terminalId) {
        String url = eagleMapConfig.getUri() + "/api/trace/terminal";
        Map<String, Object> param = new HashMap<>();
        param.put("provider", provider.getName());
        param.put("serverId", serverId);
        param.put("terminalId", terminalId);
        return this.eagleMapTemplate.getJsonHttpApiService().doDelete(url, param, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return true;
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public Boolean delete(Long serverId, Long terminalId) {
        return this.delete(ProviderEnum.NONE, serverId, terminalId);
    }

    @Override
    public Boolean update(ProviderEnum provider, Long serverId, Long terminalId, String name, String desc, Map<String, Object> props) {
        String url = eagleMapConfig.getUri() + "/api/trace/terminal";
        Map<String, Object> param = new HashMap<>();
        param.put("provider", provider.getName());
        param.put("serverId", serverId);
        param.put("terminalId", terminalId);
        param.put("name", name);
        param.put("desc", desc);
        param.put("props", props);
        return this.eagleMapTemplate.getJsonHttpApiService().doPut(url, param, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return true;
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public Boolean update(Long serverId, Long terminalId, String name, String desc, Map<String, Object> props) {
        return this.update(ProviderEnum.NONE, serverId, terminalId, name, desc, props);
    }

    @Override
    public Boolean update(ProviderEnum provider, Long serverId, Long terminalId, String name, String desc) {
        return this.update(provider, serverId, terminalId, name, desc, null);
    }

    @Override
    public Boolean update(Long serverId, Long terminalId, String name, String desc) {
        return this.update(ProviderEnum.NONE, serverId, terminalId, name, desc, null);
    }

    @Override
    public Boolean update(ProviderEnum provider, Long serverId, Long terminalId, String name) {
        return this.update(provider, serverId, terminalId, name, null, null);
    }

    @Override
    public Boolean update(Long serverId, Long terminalId, String name) {
        return this.update(ProviderEnum.NONE, serverId, terminalId, name, null, null);
    }

    @Override
    public PageResult<TraceTerminal> queryList(ProviderEnum provider, Long serverId, Long terminalId, String name, Integer page, Integer pageSize) {
        String url = eagleMapConfig.getUri() + "/api/trace/terminal";
        Map<String, Object> param = new HashMap<>();
        param.put("provider", provider.getName());
        param.put("serverId", serverId);
        param.put("terminalId", terminalId);
        param.put("name", name);
        param.put("page", page);
        param.put("pageSize", pageSize);
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, param, response -> {
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
    public PageResult<TraceTerminal> queryList(ProviderEnum provider, Long serverId, Integer page, Integer pageSize) {
        return this.queryList(provider, serverId, null, null, page, pageSize);
    }

    @Override
    public PageResult<TraceTerminal> queryList(Long serverId, Integer page, Integer pageSize) {
        return this.queryList(ProviderEnum.NONE, serverId, null, null, page, pageSize);
    }

    @Override
    public String queryLastPoint(ProviderEnum provider, Long serverId, Long terminalId, Long traceId) {
        String url = eagleMapConfig.getUri() + "/api/trace/terminal/last/point";
        Map<String, Object> param = new HashMap<>();
        param.put("provider", provider.getName());
        param.put("serverId", serverId);
        param.put("terminalId", terminalId);
        param.put("traceId", traceId);
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, param, response -> {
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
    public String queryLastPoint(Long serverId, Long terminalId, Long traceId) {
        return this.queryLastPoint(ProviderEnum.NONE, serverId, terminalId, traceId);
    }
}
