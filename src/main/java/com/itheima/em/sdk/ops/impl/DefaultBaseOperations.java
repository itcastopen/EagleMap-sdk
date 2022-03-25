package com.itheima.em.sdk.ops.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.CoordinateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.itheima.em.sdk.EagleMapTemplate;
import com.itheima.em.sdk.config.EagleMapConfig;
import com.itheima.em.sdk.enums.CoordinateEnum;
import com.itheima.em.sdk.enums.ProviderEnum;
import com.itheima.em.sdk.exception.CommonException;
import com.itheima.em.sdk.ops.BaseOperations;
import com.itheima.em.sdk.vo.Coordinate;
import com.itheima.em.sdk.vo.GeoResult;
import com.itheima.em.sdk.vo.IpResult;

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
    public IpResult queryIp(String ip, Integer type, ProviderEnum provider) {
        String url = eagleMapConfig.getUri() + "/api/ip";
        Map<String, Object> param = new HashMap<>();
        param.put("ip", ip);
        param.put("type", type);
        param.put("provider", provider.getName());
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, param, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return JSONUtil.toBean(jsonObject.getJSONObject("data"), IpResult.class);
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
    public IpResult queryIp(String ip, Integer type) {
        return this.queryIp(ip, type, ProviderEnum.NONE);
    }

    /**
     * IP定位是一套简单的HTTP接口，根据用户输入的IP地址，能够快速的帮用户定位IP的所在位置。
     *
     * @param ip IP地址，如：114.242.26.45
     * @return
     */
    @Override
    public IpResult queryIp(String ip) {
        return this.queryIp(ip, 4, ProviderEnum.NONE);
    }

    @Override
    public String staticMapImage(ProviderEnum provider, Double longitude, Double latitude, Integer width, Integer height, Integer zoom, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/static/map";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("location", new Coordinate(longitude, latitude));
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
        return this.staticMapImage(ProviderEnum.NONE, longitude, latitude, width, height, zoom, param);
    }

    @Override
    public String staticMapImage(Double longitude, Double latitude, Integer zoom, Map<String, Object> param) {
        return this.staticMapImage(ProviderEnum.NONE, longitude, latitude, 750, 300, zoom, param);
    }

    @Override
    public String staticMapImage(Double longitude, Double latitude, Map<String, Object> param) {
        return this.staticMapImage(ProviderEnum.NONE, longitude, latitude, 750, 300, 10, param);
    }

    @Override
    public String staticMapImage(Double longitude, Double latitude) {
        return this.staticMapImage(ProviderEnum.NONE, longitude, latitude, 750, 300, 10, null);
    }

    @Override
    public String staticMapImage(ProviderEnum provider, Double longitude, Double latitude) {
        return this.staticMapImage(provider, longitude, latitude, 750, 300, 10, null);
    }

    @Override
    public List<Coordinate> convertToGcj02(ProviderEnum provider, CoordinateEnum fromType, Coordinate... coordinates) {
        String url = eagleMapConfig.getUri() + "/api/coordinate/convert/gcj02";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("fromType", fromType);
        requestParam.put("coordinates", coordinates);

        return this.eagleMapTemplate.getJsonHttpApiService().doPost(url, requestParam, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return jsonObject.getJSONArray("data")
                            .stream().map(o -> {
                                JSONObject json = (JSONObject) o;
                                return new Coordinate(json.getDouble("longitude"), json.getDouble("latitude"));
                            }).collect(Collectors.toList());
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public List<Coordinate> convertToGcj02(CoordinateEnum fromType, Coordinate... coordinates) {
        return this.convertToGcj02(ProviderEnum.NONE, fromType, coordinates);
    }

    @Override
    public List<Coordinate> baiduConvertToGcj02(Coordinate... coordinates) {
        return this.convertToGcj02(ProviderEnum.NONE, CoordinateEnum.BAIDU, coordinates);
    }

    @Override
    public Coordinate convert(ProviderEnum provider, CoordinateEnum fromType, CoordinateEnum toType, Coordinate coordinate) {
        String url = eagleMapConfig.getUri() + "/api/coordinate/convert";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("fromType", fromType);
        requestParam.put("toType", toType);
        requestParam.put("coordinate", coordinate);

        return this.eagleMapTemplate.getJsonHttpApiService().doPost(url, requestParam, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return JSONUtil.toBean(jsonObject.getJSONObject("data"), Coordinate.class);
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public Coordinate convert(CoordinateEnum fromType, CoordinateEnum toType, Coordinate coordinate) {
        return this.convert(ProviderEnum.NONE, fromType, toType, coordinate);
    }

    @Override
    public boolean outOfChina(Double longitude, Double latitude) {
        return CoordinateUtil.outOfChina(longitude, latitude);
    }

    @Override
    public Coordinate wgs84ToGcj02(Double longitude, Double latitude) {
        return new Coordinate(CoordinateUtil.wgs84ToGcj02(longitude, latitude));
    }

    @Override
    public Coordinate wgs84ToBd09(Double longitude, Double latitude) {
        return new Coordinate(CoordinateUtil.wgs84ToBd09(longitude, latitude));
    }

    @Override
    public Coordinate gcj02ToWgs84(Double longitude, Double latitude) {
        return new Coordinate(CoordinateUtil.gcj02ToWgs84(longitude, latitude));
    }

    @Override
    public Coordinate bd09ToGcj02(Double longitude, Double latitude) {
        return new Coordinate(CoordinateUtil.bd09ToGcj02(longitude, latitude));
    }

    @Override
    public Coordinate gcj02ToBd09(Double longitude, Double latitude) {
        return new Coordinate(CoordinateUtil.gcj02ToBd09(longitude, latitude));
    }

    @Override
    public GeoResult geoCode(ProviderEnum provider, String address, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/geo/code";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("address", address);
        if (CollUtil.isNotEmpty(param)) {
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                requestParam.put(entry.getKey(), entry.getValue());
            }
        }
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, requestParam, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return JSONUtil.toBean(jsonObject.getJSONObject("data"), GeoResult.class);
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public GeoResult geoCode(String address, Map<String, Object> param) {
        return this.geoCode(ProviderEnum.NONE, address, param);
    }

    @Override
    public GeoResult geoCode(String address) {
        return this.geoCode(ProviderEnum.NONE, address, null);
    }

    @Override
    public GeoResult geoDecode(ProviderEnum provider, Double longitude, Double latitude, Map<String, Object> param) {
        String url = eagleMapConfig.getUri() + "/api/geo/decode";
        Map<String, Object> requestParam = new HashMap<>();
        requestParam.put("provider", provider.getName());
        requestParam.put("longitude", longitude);
        requestParam.put("latitude", latitude);
        if (CollUtil.isNotEmpty(param)) {
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                requestParam.put(entry.getKey(), entry.getValue());
            }
        }
        return this.eagleMapTemplate.getFormHttpApiService().doGet(url, requestParam, response -> {
            if (response.isOk()) {
                JSONObject jsonObject = JSONUtil.parseObj(response.body());
                if (jsonObject.getInt("code") == 0) {
                    return JSONUtil.toBean(jsonObject.getJSONObject("data"), GeoResult.class);
                }
                //将响应信息抛出
                throw new CommonException(jsonObject.getStr("msg"));
            }
            return null;
        });
    }

    @Override
    public GeoResult geoDecode(Double longitude, Double latitude, Map<String, Object> param) {
        return this.geoDecode(ProviderEnum.NONE, longitude, latitude, param);
    }

    @Override
    public GeoResult geoDecode(Double longitude, Double latitude) {
        return this.geoDecode(ProviderEnum.NONE, longitude, latitude, null);
    }
}
