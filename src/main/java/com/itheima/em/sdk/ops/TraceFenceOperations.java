package com.itheima.em.sdk.ops;

import com.itheima.em.sdk.enums.ProviderEnum;
import com.itheima.em.sdk.vo.PageResult;
import com.itheima.em.sdk.vo.TraceFence;
import com.itheima.em.sdk.vo.TraceTerminal;

import java.util.Map;

/**
 * 电子围栏的功能操作
 *
 * @author zzj
 * @version 1.0
 * @date 2022/3/14
 */
public interface TraceFenceOperations {

    /**
     * 创建圆形电子围栏
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Long createCircleFence(ProviderEnum provider, Long serverId, String name, String desc, Map<String, Object> param);

    /**
     * 创建圆形电子围栏，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId 服务id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Long createCircleFence(Long serverId, String name, String desc, Map<String, Object> param);


    /**
     * 创建多边形围栏
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Long createPolygonFence(ProviderEnum provider, Long serverId, String name, String desc, Map<String, Object> param);

    /**
     * 创建多边形围栏，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId 服务id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Long createPolygonFence(Long serverId, String name, String desc, Map<String, Object> param);

    /**
     * 创建线形围栏
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Long createPolylineFence(ProviderEnum provider, Long serverId, String name, String desc, Map<String, Object> param);

    /**
     * 创建线形围栏，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId 服务id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Long createPolylineFence(Long serverId, String name, String desc, Map<String, Object> param);

    /**
     * 创建行政区划围栏
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Long createDistrictFence(ProviderEnum provider, Long serverId, String name, String desc, Map<String, Object> param);

    /**
     * 创建行政区划围栏，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId 服务id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Long createDistrictFence(Long serverId, String name, String desc, Map<String, Object> param);

    /**
     * 更新圆形围栏
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @param fenceId  围栏id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Boolean updateCircleFence(ProviderEnum provider, Long serverId, Long fenceId, String name, String desc, Map<String, Object> param);

    /**
     * 更新圆形围栏，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId 服务id
     * @param fenceId  围栏id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Boolean updateCircleFence(Long serverId, Long fenceId, String name, String desc, Map<String, Object> param);

    /**
     * 更新多边形围栏
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @param fenceId  围栏id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Boolean updatePolygonFence(ProviderEnum provider, Long serverId, Long fenceId, String name, String desc, Map<String, Object> param);

    /**
     * 更新多边形围栏，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId 服务id
     * @param fenceId  围栏id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Boolean updatePolygonFence(Long serverId, Long fenceId, String name, String desc, Map<String, Object> param);

    /**
     * 更新线形围栏
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @param fenceId  围栏id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Boolean updatePolylineFence(ProviderEnum provider, Long serverId, Long fenceId, String name, String desc, Map<String, Object> param);

    /**
     * 更新线形围栏，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId 服务id
     * @param fenceId  围栏id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Boolean updatePolylineFence(Long serverId, Long fenceId, String name, String desc, Map<String, Object> param);


    /**
     * 更新行政区划围栏
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @param fenceId  围栏id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Boolean updateDistrictFence(ProviderEnum provider, Long serverId, Long fenceId, String name, String desc, Map<String, Object> param);

    /**
     * 更新行政区划围栏，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId 服务id
     * @param fenceId  围栏id
     * @param name     围栏名称
     * @param desc     描述
     * @param param    参数具体参数参考官方文档：
     *                 百度地图：https://lbsyun.baidu.com/index.php?title=yingyan/api/v3/geofence
     *                 高德地图：https://lbs.amap.com/api/track/lieying-kaifa/api/track_fence
     * @return 创建成功，返回围栏id
     */
    Boolean updateDistrictFence(Long serverId, Long fenceId, String name, String desc, Map<String, Object> param);


    /**
     * 删除围栏
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @param fenceIds 围栏id列表
     * @return 是否成功
     */
    Boolean deleteFence(ProviderEnum provider, Long serverId, Long... fenceIds);

    /**
     * 删除围栏，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId 服务id
     * @param fenceIds 围栏id列表
     * @return 是否成功
     */
    Boolean deleteFence(Long serverId, Long... fenceIds);

    /**
     * 绑定终端到电子围栏中
     *
     * @param provider    服务商
     * @param serverId    服务id
     * @param fenceId     围栏id
     * @param terminalIds 终端id列表
     * @return 是否成功
     */
    Boolean bindTerminalFence(ProviderEnum provider, Long serverId, Long fenceId, Long... terminalIds);

    /**
     * 绑定终端到电子围栏中，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId    服务id
     * @param fenceId     围栏id
     * @param terminalIds 终端id列表
     * @return 是否成功
     */
    Boolean bindTerminalFence(Long serverId, Long fenceId, Long... terminalIds);

    /**
     * 解绑电子围栏中的终端
     *
     * @param provider    服务商
     * @param serverId    服务id
     * @param fenceId     围栏id
     * @param terminalIds 终端id列表
     * @return 是否成功
     */
    Boolean unbindTerminalFence(ProviderEnum provider, Long serverId, Long fenceId, Long... terminalIds);

    /**
     * 解绑电子围栏中的终端，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId    服务id
     * @param fenceId     围栏id
     * @param terminalIds 终端id列表
     * @return 是否成功
     */
    Boolean unbindTerminalFence(Long serverId, Long fenceId, Long... terminalIds);

    /**
     * 分页查询围栏中的终端列表
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @param fenceId  围栏id
     * @param page     页数
     * @param pageSize 页面大小
     * @return 分页数据
     */
    PageResult<TraceTerminal> queryTerminalFenceList(ProviderEnum provider, Long serverId, Long fenceId, Integer page, Integer pageSize);


    /**
     * 分页查询围栏中的终端列表，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId 服务id
     * @param fenceId  围栏id
     * @param page     页数
     * @param pageSize 页面大小
     * @return 分页数据
     */
    PageResult<TraceTerminal> queryTerminalFenceList(Long serverId, Long fenceId, Integer page, Integer pageSize);

    /**
     * 分页查询围栏列表
     *
     * @param provider 服务商
     * @param page     页数
     * @param pageSize 页面大小
     * @return 分页数据
     */
    PageResult<TraceFence> queryFenceList(ProviderEnum provider, Integer page, Integer pageSize);

    /**
     * 分页查询围栏列表，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param page     页数
     * @param pageSize 页面大小
     * @return 分页数据
     */
    PageResult<TraceFence> queryFenceList(Integer page, Integer pageSize);

    /**
     * 根据围栏id查询围栏信息
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @param fenceId  围栏id
     * @return 围栏对象数据
     */
    TraceFence queryByFenceId(ProviderEnum provider, Long serverId, Long fenceId);

    /**
     * 根据围栏id查询围栏信息，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId 服务id
     * @param fenceId  围栏id
     * @return 围栏对象数据
     */
    TraceFence queryByFenceId(Long serverId, Long fenceId);

    /**
     * 查询终端在围栏中的状态
     *
     * @param serverId   服务id
     * @param fenceId    围栏id
     * @param terminalId 终端id
     * @return 是否在围栏中
     */
    Boolean queryTerminalStatus(ProviderEnum provider, Long serverId, Long fenceId, Long terminalId);

    /**
     * 查询终端在围栏中的状态，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId   服务id
     * @param fenceId    围栏id
     * @param terminalId 终端id
     * @return 是否在围栏中
     */
    Boolean queryTerminalStatus(Long serverId, Long fenceId, Long terminalId);

}
