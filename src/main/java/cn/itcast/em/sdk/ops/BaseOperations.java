package cn.itcast.em.sdk.ops;

import cn.itcast.em.sdk.enums.ServerType;
import cn.itcast.em.sdk.vo.IpResultVo;

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
    IpResultVo queryIp(String ip, Integer type, ServerType provider);

    /**
     * IP定位是一套简单的HTTP接口，根据用户输入的IP地址，能够快速的帮用户定位IP的所在位置。
     *
     * @param ip   IP地址，如：114.242.26.45
     * @param type IP类型,值为 4 或 6，4 表示 IPv4，6 表示 IPv6
     * @return
     */
    IpResultVo queryIp(String ip, Integer type);

    /**
     * IP定位是一套简单的HTTP接口，根据用户输入的IP地址，能够快速的帮用户定位IP的所在位置。
     *
     * @param ip IP地址，如：114.242.26.45
     * @return
     */
    IpResultVo queryIp(String ip);

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
    String staticMapImage(ServerType provider, Double longitude, Double latitude, Integer width, Integer height, Integer zoom, Map<String, Object> param);

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
    String staticMapImage(ServerType provider, Double longitude, Double latitude);

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

}
