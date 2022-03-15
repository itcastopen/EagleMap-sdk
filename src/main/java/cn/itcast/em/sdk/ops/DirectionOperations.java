package cn.itcast.em.sdk.ops;

import cn.itcast.em.sdk.enums.ServerType;
import cn.itcast.em.sdk.vo.Coordinate;

import java.util.Map;

/**
 * 路线规划相关业务
 *
 * @author zzj
 * @version 1.0
 * @date 2022/3/14
 */
public interface DirectionOperations {

    /**
     * 驾车路径规划 API 可以规划以小客车、轿车通勤出行的方案，并且返回通勤方案的数据。
     *
     * @param provider    服务提供商，必须大写，默认为：高德地图
     * @param origin      起点坐标
     * @param destination 终点坐标
     * @param param       请求参数，不同服务商参数不同：
     *                    百度地图参考：https://lbsyun.baidu.com/index.php?title=webapi/directionlite-v1#service-page-anchor-1-0
     *                    高德地图参考：https://lbs.amap.com/api/webservice/guide/api/direction#driving
     * @return 百度/高德响应的数据
     */
    String driving(ServerType provider, Coordinate origin, Coordinate destination, Map<String, Object> param);

    /**
     * 驾车路径规划 API 可以规划以小客车、轿车通勤出行的方案，并且返回通勤方案的数据。
     *
     * @param provider    服务提供商，必须大写，默认为：高德地图
     * @param origin      起点坐标
     * @param destination 终点坐标
     * @return 百度/高德响应的数据
     */
    String driving(ServerType provider, Coordinate origin, Coordinate destination);

    /**
     * 驾车路径规划 API 可以规划以小客车、轿车通勤出行的方案，并且返回通勤方案的数据。
     *
     * @param origin      起点坐标
     * @param destination 终点坐标
     * @return 百度/高德响应的数据
     */
    String driving(Coordinate origin, Coordinate destination);

    /**
     * 驾车路径规划 API 可以规划以小客车、轿车通勤出行的方案，并且返回通勤方案的数据。
     *
     * @param origin      起点坐标
     * @param destination 终点坐标
     * @param param       请求参数，不同服务商参数不同：
     *                    百度地图参考：https://lbsyun.baidu.com/index.php?title=webapi/directionlite-v1#service-page-anchor-1-0
     *                    高德地图参考：https://lbs.amap.com/api/webservice/guide/api/direction#driving
     * @return 百度/高德响应的数据
     */
    String driving(Coordinate origin, Coordinate destination, Map<String, Object> param);

    /**
     * 骑行路线规划
     *
     * @param provider    服务提供商，必须大写，默认为：高德地图
     * @param origin      起点坐标
     * @param destination 终点坐标
     * @param param       请求参数，不同服务商参数不同：
     *                    高德：https://lbs.amap.com/api/webservice/guide/api/newroute#t7
     *                    百度：https://lbsyun.baidu.com/index.php?title=webapi/directionlite-v1#service-page-anchor-1-1
     * @return 百度/高德响应的数据
     */
    String walking(ServerType provider, Coordinate origin, Coordinate destination, Map<String, Object> param);

    /**
     * 骑行路线规划
     *
     * @param provider    服务提供商，必须大写，默认为：高德地图
     * @param origin      起点坐标
     * @param destination 终点坐标
     * @return 百度/高德响应的数据
     */
    String walking(ServerType provider, Coordinate origin, Coordinate destination);

    /**
     * 骑行路线规划
     *
     * @param origin      起点坐标
     * @param destination 终点坐标
     * @return 百度/高德响应的数据
     */
    String walking(Coordinate origin, Coordinate destination);

    /**
     * 骑行路线规划
     *
     * @param origin      起点坐标
     * @param destination 终点坐标
     * @param param       请求参数，不同服务商参数不同：
     *                    高德：https://lbs.amap.com/api/webservice/guide/api/newroute#t7
     *                    百度：https://lbsyun.baidu.com/index.php?title=webapi/directionlite-v1#service-page-anchor-1-1
     * @return 百度/高德响应的数据
     */
    String walking(Coordinate origin, Coordinate destination, Map<String, Object> param);

    /**
     * 骑行路线规划
     *
     * @param provider    服务提供商，必须大写，默认为：高德地图
     * @param origin      起点经纬度
     * @param destination 目的地经纬度
     * @param param       百度/高德的可选参数，如需要请根据官方文档添加参数
     *                    高德：https://lbs.amap.com/api/webservice/guide/api/newroute#t7
     *                    百度：https://lbsyun.baidu.com/index.php?title=webapi/directionlite-v1#service-page-anchor-1-1
     * @return 百度/高德响应的数据
     */
    String bicycling(ServerType provider, Coordinate origin, Coordinate destination, Map<String, Object> param);

    /**
     * 骑行路线规划
     *
     * @param provider    服务提供商，必须大写，默认为：高德地图
     * @param origin      起点经纬度
     * @param destination 目的地经纬度
     * @return 百度/高德响应的数据
     */
    String bicycling(ServerType provider, Coordinate origin, Coordinate destination);

    /**
     * 骑行路线规划
     *
     * @param origin      起点经纬度
     * @param destination 目的地经纬度
     * @return 百度/高德响应的数据
     */
    String bicycling(Coordinate origin, Coordinate destination);

    /**
     * 骑行路线规划
     *
     * @param origin      起点经纬度
     * @param destination 目的地经纬度
     * @param param       百度/高德的可选参数，如需要请根据官方文档添加参数
     *                    高德：https://lbs.amap.com/api/webservice/guide/api/newroute#t7
     *                    百度：https://lbsyun.baidu.com/index.php?title=webapi/directionlite-v1#service-page-anchor-1-1
     * @return 百度/高德响应的数据
     */
    String bicycling(Coordinate origin, Coordinate destination, Map<String, Object> param);


}

