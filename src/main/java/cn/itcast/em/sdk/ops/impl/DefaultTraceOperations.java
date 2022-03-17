package cn.itcast.em.sdk.ops.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpException;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.itcast.em.sdk.EagleMapTemplate;
import cn.itcast.em.sdk.config.EagleMapConfig;
import cn.itcast.em.sdk.enums.ServerType;
import cn.itcast.em.sdk.exception.CommonException;
import cn.itcast.em.sdk.ops.TraceOperations;
import cn.itcast.em.sdk.vo.PageResult;
import cn.itcast.em.sdk.vo.Trace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/16
 */
public class DefaultTraceOperations implements TraceOperations {

    private EagleMapTemplate eagleMapTemplate;
    private EagleMapConfig eagleMapConfig;

    public DefaultTraceOperations(EagleMapTemplate eagleMapTemplate) {
        this.eagleMapTemplate = eagleMapTemplate;
        this.eagleMapConfig = eagleMapTemplate.getEagleMapConfig();
    }

    @Override
    public Long create(ServerType provider, Long serverId, Long terminalId, String name) {
        String url = eagleMapConfig.getUri() + "/api/trace";
        Map<String, Object> param = new HashMap<>();
        param.put("provider", provider.getName());
        param.put("serverId", serverId);
        param.put("terminalId", terminalId);
        param.put("name", name);
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
    public Long create(Long serverId, Long terminalId, String name) {
        return this.create(ServerType.NONE, serverId, terminalId, name);
    }

    @Override
    public Boolean delete(ServerType provider, Long serverId, Long terminalId, Long traceId) {
        String url = eagleMapConfig.getUri() + "/api/trace";
        Map<String, Object> param = new HashMap<>();
        param.put("provider", provider.getName());
        param.put("serverId", serverId);
        param.put("terminalId", terminalId);
        param.put("traceId", traceId);
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
    public Boolean delete(Long serverId, Long terminalId, Long traceId) {
        return this.delete(ServerType.NONE, serverId, terminalId, traceId);
    }

    @Override
    public Boolean upload(ServerType provider, Long serverId, Long terminalId, Long traceId, List<Map<String, Object>> pointList) {
        String url = eagleMapConfig.getUri() + "/api/trace/upload";
        Map<String, Object> param = new HashMap<>();
        param.put("provider", provider.getName());
        param.put("serverId", serverId);
        param.put("terminalId", terminalId);
        param.put("traceId", traceId);
        param.put("pointList", pointList);
        return this.eagleMapTemplate.getJsonHttpApiService().doPost(url, param, response -> {
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
    public Boolean upload(Long serverId, Long terminalId, Long traceId, List<Map<String, Object>> pointList) {
        return this.upload(ServerType.NONE, serverId, terminalId, traceId, pointList);
    }

    @Override
    public Boolean stopTrace(ServerType provider, Long serverId, Long terminalId, Long traceId, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/trace/stop";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("serverId", serverId);
        requestParam.put("terminalId", terminalId);
        requestParam.put("traceId", traceId);
        requestParam.put("param", param);
        return this.eagleMapTemplate.getJsonHttpApiService().doPost(url, requestParam, response -> {
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
    public Boolean stopTrace(Long serverId, Long terminalId, Long traceId, Map<String, Object> param) {
        return this.stopTrace(ServerType.NONE, serverId, terminalId, traceId, param);
    }

    @Override
    public PageResult<Trace> queryTracePageList(ServerType provider, Integer page, Integer pageSize) {
        String url = eagleMapConfig.getUri() + "/api/trace/list";
        Map<String, Object> param = new HashMap<>();
        param.put("provider", provider.getName());
        param.put("page", page);
        param.put("pageSize", pageSize);
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, param, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return PageResult.toBean(jsonObject, Trace.class);
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public PageResult<Trace> queryTracePageList(Integer page, Integer pageSize) {
        return this.queryTracePageList(ServerType.NONE, page, pageSize);
    }

    @Override
    public Trace queryTraceInfo(ServerType provider, Long serverId, Long terminalId, Long traceId, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/trace/info";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("serverId", serverId);
        requestParam.put("terminalId", terminalId);
        requestParam.put("traceId", traceId);
        requestParam.put("param", param);
        return this.eagleMapTemplate.getJsonHttpApiService().doPost(url, requestParam, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return JSONUtil.toBean(jsonObject.getJSONObject("data"), Trace.class);
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public Trace queryTraceInfo(Long serverId, Long terminalId, Long traceId, Map<String, Object> param) {
        return this.queryTraceInfo(ServerType.NONE, serverId, terminalId, traceId, param);
    }

    @Override
    public Trace queryOnLineTraceInfo(ServerType provider, Long serverId, Long terminalId, Long traceId, Map<String, Object> param) {
        if (CollUtil.isEmpty(param)) {
            param = new HashMap<>();
        }
        param.put("local", false);
        return this.queryTraceInfo(provider, serverId, terminalId, traceId, param);
    }

    @Override
    public Trace queryOnLineTraceInfo(ServerType provider, Long serverId, Long terminalId, Long traceId) {
        return this.queryOnLineTraceInfo(provider, serverId, terminalId, traceId, null);
    }

    @Override
    public Trace queryOnLineTraceInfo(Long serverId, Long terminalId, Long traceId, Map<String, Object> param) {
        return this.queryOnLineTraceInfo(ServerType.NONE, serverId, terminalId, traceId, param);
    }

    @Override
    public Trace queryOnLineTraceInfo(Long serverId, Long terminalId, Long traceId) {
        return this.queryOnLineTraceInfo(ServerType.NONE, serverId, terminalId, traceId, null);
    }

    @Override
    public String queryTraceImage(ServerType provider, Long serverId, Long terminalId, Long traceId, Integer width, Integer height, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/trace/image";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("serverId", serverId);
        requestParam.put("terminalId", terminalId);
        requestParam.put("traceId", traceId);
        requestParam.put("width", width);
        requestParam.put("height", height);
        requestParam.put("param", JSONUtil.toJsonStr(param));
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, requestParam, response -> {
            if (response.isOk() && StrUtil.equals("1", response.header("status"))) {
                return Base64.encode(response.bodyStream());
            }
            //将响应信息抛出
            throw new CommonException(response.body());
        });
    }

    @Override
    public String queryTraceImage(Long serverId, Long terminalId, Long traceId, Integer width, Integer height, Map<String, Object> param) {
        return this.queryTraceImage(ServerType.NONE, serverId, terminalId, traceId, width, height, param);
    }

    @Override
    public String queryTraceImage(Long serverId, Long terminalId, Long traceId) {
        return this.queryTraceImage(ServerType.NONE, serverId, terminalId, traceId, null, null, null);
    }
}
