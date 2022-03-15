package cn.itcast.em.sdk.ops;

import cn.itcast.em.sdk.enums.ServerType;
import cn.itcast.em.sdk.vo.CoordinateVo;

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
     * 骑行路径规划用于规划骑行通勤方案，规划时不会考虑路况；考虑天桥、单行线、封路等情况。
     *
     * @param provider    服务提供商，必须大写，默认为：高德地图
     * @param origin      起点坐标
     * @param destination 终点坐标
     * @param param       请求参数，不同服务商参数不同：
     *                    百度地图参考：https://lbsyun.baidu.com/index.php?title=webapi/directionlite-v1#service-page-anchor-1-0
     *                    高德地图参考：https://lbs.amap.com/api/webservice/guide/api/direction#driving
     * @return
     */
    String driving(ServerType provider, CoordinateVo origin, CoordinateVo destination, Map<String, Object> param);

    /**
     * 骑行路径规划用于规划骑行通勤方案，规划时不会考虑路况；考虑天桥、单行线、封路等情况。
     *
     * @param provider    服务提供商，必须大写，默认为：高德地图
     * @param origin      起点坐标
     * @param destination 终点坐标
     * @return
     */
    String driving(ServerType provider, CoordinateVo origin, CoordinateVo destination);

    /**
     * 骑行路径规划用于规划骑行通勤方案，规划时不会考虑路况；考虑天桥、单行线、封路等情况。
     *
     * @param origin      起点坐标
     * @param destination 终点坐标
     * @return
     */
    String driving(CoordinateVo origin, CoordinateVo destination);

    /**
     * 骑行路径规划用于规划骑行通勤方案，规划时不会考虑路况；考虑天桥、单行线、封路等情况。
     *
     * @param origin      起点坐标
     * @param destination 终点坐标
     * @param param       请求参数，不同服务商参数不同：
     *                    百度地图参考：https://lbsyun.baidu.com/index.php?title=webapi/directionlite-v1#service-page-anchor-1-0
     *                    高德地图参考：https://lbs.amap.com/api/webservice/guide/api/direction#driving
     * @return
     */
    String driving(CoordinateVo origin, CoordinateVo destination, Map<String, Object> param);
}
