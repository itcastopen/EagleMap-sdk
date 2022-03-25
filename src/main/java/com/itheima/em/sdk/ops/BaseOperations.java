package com.itheima.em.sdk.ops;

import com.itheima.em.sdk.enums.CoordinateEnum;
import com.itheima.em.sdk.enums.ProviderEnum;
import com.itheima.em.sdk.vo.Coordinate;
import com.itheima.em.sdk.vo.IpResult;

import java.util.List;
import java.util.Map;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/14
 */
public interface BaseOperations {

    /**
     * IP定位是一套简单的HTTP接口，根据用户输入的IP地址，能够快速的帮用户定位IP的所在位置。
     *
     * @param ip       IP地址，如：114.242.26.45
     * @param type     IP类型,值为 4 或 6，4 表示 IPv4，6 表示 IPv6
     * @param provider 服务提供商，必须大写，如：BAIDU,AMAP,NONE，默认：高德地图
     * @return
     */
    IpResult queryIp(String ip, Integer type, ProviderEnum provider);

    /**
     * IP定位是一套简单的HTTP接口，根据用户输入的IP地址，能够快速的帮用户定位IP的所在位置。
     *
     * @param ip   IP地址，如：114.242.26.45
     * @param type IP类型,值为 4 或 6，4 表示 IPv4，6 表示 IPv6
     * @return
     */
    IpResult queryIp(String ip, Integer type);

    /**
     * IP定位是一套简单的HTTP接口，根据用户输入的IP地址，能够快速的帮用户定位IP的所在位置。
     *
     * @param ip IP地址，如：114.242.26.45
     * @return
     */
    IpResult queryIp(String ip);

    /**
     * 查询静态地图
     *
     * @param provider  服务提供商
     * @param longitude 经度 （gcj02）
     * @param latitude  纬度（gcj02）
     * @param width     图片的宽度，默认：750
     * @param height    图片的宽度，默认：300
     * @param zoom      地图缩放比，默认：10
     * @param param     百度/高德的可选参数，如需要请根据官方文档添加参数
     *                  百度：https://lbsyun.baidu.com/index.php?title=static
     *                  高德：https://lbs.amap.com/api/webservice/guide/api/staticmaps
     * @return
     */
    String staticMapImage(ProviderEnum provider, Double longitude, Double latitude, Integer width, Integer height, Integer zoom, Map<String, Object> param);

    /**
     * 查询静态地图，指定服务商
     * 图片的宽度，默认：750, 图片的宽度，默认：300
     * 地图缩放比，默认：10
     * 无需额外参数
     *
     * @param provider  服务提供商
     * @param longitude 经度 （gcj02）
     * @param latitude  纬度（gcj02）
     * @return
     */
    String staticMapImage(ProviderEnum provider, Double longitude, Double latitude);

    /**
     * 查询静态地图，默认服务商由EagleMap选择
     *
     * @param longitude 经度 （gcj02）
     * @param latitude  纬度（gcj02）
     * @param width     图片的宽度，默认：750
     * @param height    图片的宽度，默认：300
     * @param zoom      地图缩放比，默认：10
     * @param param     百度/高德的可选参数，如需要请根据官方文档添加参数
     *                  百度：https://lbsyun.baidu.com/index.php?title=static
     *                  高德：https://lbs.amap.com/api/webservice/guide/api/staticmaps
     * @return
     */
    String staticMapImage(Double longitude, Double latitude, Integer width, Integer height, Integer zoom, Map<String, Object> param);

    /**
     * 查询静态地图，默认服务商由EagleMap选择，图片的宽度，默认：750, 图片的宽度，默认：300
     *
     * @param longitude 经度 （gcj02）
     * @param latitude  纬度（gcj02）
     * @param zoom      地图缩放比，默认：10
     * @param param     百度/高德的可选参数，如需要请根据官方文档添加参数
     *                  百度：https://lbsyun.baidu.com/index.php?title=static
     *                  高德：https://lbs.amap.com/api/webservice/guide/api/staticmaps
     * @return
     */
    String staticMapImage(Double longitude, Double latitude, Integer zoom, Map<String, Object> param);

    /**
     * 查询静态地图，默认服务商由EagleMap选择，
     * 图片的宽度，默认：750, 图片的宽度，默认：300
     * 地图缩放比，默认：10
     *
     * @param longitude 经度 （gcj02）
     * @param latitude  纬度（gcj02）
     * @param param     百度/高德的可选参数，如需要请根据官方文档添加参数
     *                  百度：https://lbsyun.baidu.com/index.php?title=static
     *                  高德：https://lbs.amap.com/api/webservice/guide/api/staticmaps
     * @return
     */
    String staticMapImage(Double longitude, Double latitude, Map<String, Object> param);

    /**
     * 查询静态地图，默认服务商由EagleMap选择，
     * 图片的宽度，默认：750, 图片的宽度，默认：300
     * 地图缩放比，默认：10
     * 无需额外参数
     *
     * @param longitude 经度 （gcj02）
     * @param latitude  纬度（gcj02）
     * @return
     */
    String staticMapImage(Double longitude, Double latitude);

    /**
     * 将源坐标体系的坐标转化为gcj02
     *
     * @param provider      指定提供方
     * @param fromType      源类型
     * @param coordinates 待转化的坐标值列表
     * @return
     */
    List<Coordinate> convertToGcj02(ProviderEnum provider, CoordinateEnum fromType, Coordinate... coordinates);

    /**
     * 将源坐标体系的坐标转化为gcj02，不指定提供商由EagleMap自动选择
     *
     * @param fromType      源类型
     * @param coordinates 待转化的坐标值列表
     * @return
     */
    List<Coordinate> convertToGcj02(CoordinateEnum fromType, Coordinate... coordinates);

    /**
     * 将百度的坐标转化为gcj02，不指定提供商由EagleMap自动选择
     *
     * @param coordinates 待转化的坐标值列表
     * @return
     */
    List<Coordinate> baiduConvertToGcj02(Coordinate... coordinates);

    /**
     * 指定坐标体系转化
     *
     * @param provider     指定提供方
     * @param fromType     原坐标类型
     * @param toType       目标坐标类型
     * @param coordinate 待转化的坐标值
     * @return
     */
    Coordinate convert(ProviderEnum provider, CoordinateEnum fromType, CoordinateEnum toType, Coordinate coordinate);

    /**
     * 指定坐标体系转化，不指定提供商由EagleMap自动选择
     *
     * @param fromType     原坐标类型
     * @param toType       目标坐标类型
     * @param coordinate 待转化的坐标值
     * @return
     */
    Coordinate convert(CoordinateEnum fromType, CoordinateEnum toType, Coordinate coordinate);

    /**
     * 为了使用方便基于hutool工具的封装
     * 判断坐标是否在国外<br>
     * 火星坐标系 (GCJ-02)只对国内有效，国外无需转换
     *
     * @param longitude 经度
     * @param latitude  纬度
     * @return 坐标是否在国外
     */
    boolean outOfChina(Double longitude, Double latitude);

    /**
     * 为了使用方便基于hutool工具的封装
     * WGS84 转换为 火星坐标系 (GCJ-02)
     *
     * @param longitude 经度值
     * @param latitude  维度值
     * @return 火星坐标 (GCJ-02)
     */
    Coordinate wgs84ToGcj02(Double longitude, Double latitude);

    /**
     * 为了使用方便基于hutool工具的封装
     * WGS84 坐标转为 百度坐标系 (BD-09) 坐标
     *
     * @param longitude 经度值
     * @param latitude  维度值
     * @return bd09 坐标
     */
    Coordinate wgs84ToBd09(Double longitude, Double latitude);

    /**
     * 为了使用方便基于hutool工具的封装
     * 火星坐标系 (GCJ-02) 转换为 WGS84
     *
     * @param longitude 经度坐标
     * @param latitude  维度坐标
     * @return WGS84 坐标
     */
    Coordinate gcj02ToWgs84(Double longitude, Double latitude);

    /**
     * 为了使用方便基于hutool工具的封装
     * 百度坐标系 (BD-09) 与 火星坐标系 (GCJ-02)的转换
     * 即 百度 转 谷歌、高德
     *
     * @param longitude 经度值
     * @param latitude  纬度值
     * @return GCJ-02 坐标
     */
    Coordinate bd09ToGcj02(Double longitude, Double latitude);

    /**
     * 为了使用方便基于hutool工具的封装
     * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换
     *
     * @param longitude 经度值
     * @param latitude  纬度值
     * @return BD-09 坐标
     */
    Coordinate gcj02ToBd09(Double longitude, Double latitude);

}
