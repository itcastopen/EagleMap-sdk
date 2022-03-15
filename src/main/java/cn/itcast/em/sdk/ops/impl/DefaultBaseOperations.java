package cn.itcast.em.sdk.ops.impl;

import cn.hutool.core.util.CoordinateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.itcast.em.sdk.EagleMapTemplate;
import cn.itcast.em.sdk.config.EagleMapConfig;
import cn.itcast.em.sdk.enums.CoordinateType;
import cn.itcast.em.sdk.enums.ServerType;
import cn.itcast.em.sdk.exception.CommonException;
import cn.itcast.em.sdk.ops.BaseOperations;
import cn.itcast.em.sdk.vo.CoordinateVo;
import cn.itcast.em.sdk.vo.IpResultVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/14
 */
public class DefaultBaseOperations implements BaseOperations {

    private EagleMapTemplate eagleMapTemplate;
    private EagleMapConfig eagleMapConfig;

    public DefaultBaseOperations(EagleMapTemplate eagleMapTemplate) {
        this.eagleMapTemplate = eagleMapTemplate;
        this.eagleMapConfig = eagleMapTemplate.getEagleMapConfig();
    }

    /**
     * IP定位是一套简单的HTTP接口，根据用户输入的IP地址，能够快速的帮用户定位IP的所在位置。
     *
     * @param ip       IP地址，如：114.242.26.45
     * @param type     IP类型,值为 4 或 6，4 表示 IPv4，6 表示 IPv6
     * @param provider 服务提供商，必须大写，如：BAIDU,AMAP,NONE，默认：高德地图
     * @return
     */
    @Override
    public IpResultVo queryIp(String ip, Integer type, ServerType provider) {
        String url = eagleMapConfig.getUri() + "/api/ip";
        Map<String, Object> param = new HashMap<>();
        param.put("ip", ip);
        param.put("type", type);
        param.put("provider", provider.getName());
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, param, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return JSONUtil.toBean(jsonObject.getJSONObject("data"), IpResultVo.class);
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    /**
     * IP定位是一套简单的HTTP接口，根据用户输入的IP地址，能够快速的帮用户定位IP的所在位置。
     *
     * @param ip   IP地址，如：114.242.26.45
     * @param type IP类型,值为 4 或 6，4 表示 IPv4，6 表示 IPv6
     * @return
     */
    @Override
    public IpResultVo queryIp(String ip, Integer type) {
        return this.queryIp(ip, type, ServerType.NONE);
    }

    /**
     * IP定位是一套简单的HTTP接口，根据用户输入的IP地址，能够快速的帮用户定位IP的所在位置。
     *
     * @param ip IP地址，如：114.242.26.45
     * @return
     */
    @Override
    public IpResultVo queryIp(String ip) {
        return this.queryIp(ip, 4, ServerType.NONE);
    }

    @Override
    public String staticMapImage(ServerType provider, Double longitude, Double latitude, Integer width, Integer height, Integer zoom, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/static/map";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("location", new CoordinateVo(longitude, latitude));
        requestParam.put("width", width);
        requestParam.put("height", height);
        requestParam.put("zoom", zoom);
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
    public String staticMapImage(Double longitude, Double latitude, Integer width, Integer height, Integer zoom, Map<String, Object> param) {
        return this.staticMapImage(ServerType.NONE, longitude, latitude, width, height, zoom, param);
    }

    @Override
    public String staticMapImage(Double longitude, Double latitude, Integer zoom, Map<String, Object> param) {
        return this.staticMapImage(ServerType.NONE, longitude, latitude, 750, 300, zoom, param);
    }

    @Override
    public String staticMapImage(Double longitude, Double latitude, Map<String, Object> param) {
        return this.staticMapImage(ServerType.NONE, longitude, latitude, 750, 300, 10, param);
    }

    @Override
    public String staticMapImage(Double longitude, Double latitude) {
        return this.staticMapImage(ServerType.NONE, longitude, latitude, 750, 300, 10, null);
    }

    @Override
    public String staticMapImage(ServerType provider, Double longitude, Double latitude) {
        return this.staticMapImage(provider, longitude, latitude, 750, 300, 10, null);
    }

    @Override
    public List<CoordinateVo> convertToGcj02(ServerType provider, CoordinateType fromType, CoordinateVo... coordinateVos) {
        String url = eagleMapConfig.getUri() + "/api/coordinate/convert/gcj02";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("fromType", fromType);
        requestParam.put("coordinates", coordinateVos);

        return this.eagleMapTemplate.getJsonHttpApiService().doPost(url, requestParam, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return jsonObject.getJSONArray("data")
                            .stream().map(o -> {
                                JSONObject json = (JSONObject) o;
                                return new CoordinateVo(json.getDouble("longitude"), json.getDouble("latitude"));
                            }).collect(Collectors.toList());
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public List<CoordinateVo> convertToGcj02(CoordinateType fromType, CoordinateVo... coordinateVos) {
        return this.convertToGcj02(ServerType.NONE, fromType, coordinateVos);
    }

    @Override
    public List<CoordinateVo> baiduConvertToGcj02(CoordinateVo... coordinateVos) {
        return this.convertToGcj02(ServerType.NONE, CoordinateType.BAIDU, coordinateVos);
    }

    @Override
    public CoordinateVo convert(ServerType provider, CoordinateType fromType, CoordinateType toType, CoordinateVo coordinateVo) {
        String url = eagleMapConfig.getUri() + "/api/coordinate/convert";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("fromType", fromType);
        requestParam.put("toType", toType);
        requestParam.put("coordinate", coordinateVo);

        return this.eagleMapTemplate.getJsonHttpApiService().doPost(url, requestParam, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return JSONUtil.toBean(jsonObject.getJSONObject("data"), CoordinateVo.class);
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public CoordinateVo convert(CoordinateType fromType, CoordinateType toType, CoordinateVo coordinateVo) {
        return this.convert(ServerType.NONE, fromType, toType, coordinateVo);
    }

    @Override
    public boolean outOfChina(Double longitude, Double latitude) {
        return CoordinateUtil.outOfChina(longitude, latitude);
    }

    @Override
    public CoordinateVo wgs84ToGcj02(Double longitude, Double latitude) {
        return new CoordinateVo(CoordinateUtil.wgs84ToGcj02(longitude, latitude));
    }

    @Override
    public CoordinateVo wgs84ToBd09(Double longitude, Double latitude) {
        return new CoordinateVo(CoordinateUtil.wgs84ToBd09(longitude, latitude));
    }

    @Override
    public CoordinateVo gcj02ToWgs84(Double longitude, Double latitude) {
        return new CoordinateVo(CoordinateUtil.gcj02ToWgs84(longitude, latitude));
    }

    @Override
    public CoordinateVo bd09ToGcj02(Double longitude, Double latitude) {
        return new CoordinateVo(CoordinateUtil.bd09ToGcj02(longitude, latitude));
    }

    @Override
    public CoordinateVo gcj02ToBd09(Double longitude, Double latitude) {
        return new CoordinateVo(CoordinateUtil.gcj02ToBd09(longitude, latitude));
    }
}
