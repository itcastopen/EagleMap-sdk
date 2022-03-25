package com.itheima.em.sdk.ops;

import com.itheima.em.sdk.enums.ProviderEnum;
import com.itheima.em.sdk.vo.TraceServer;

import java.util.List;

/**
 * 轨迹服务的管理操作
 *
 * @author zzj
 * @version 1.0
 * @date 2022/3/14
 */
public interface TraceServerOperations {

    /**
     * 创建轨迹服务
     * <p>
     * 使用轨迹功能必须先创建轨迹服务。
     * 百度地图不支持通过接口创建，请通过百度地图的轨迹服务管理系统创建，高德地图支持通过接口创建。
     * 百度地图管理地址：https://lbsyun.baidu.com/trace/admin/service
     *
     * @param name 服务名称
     * @param desc 服务描述，非必须
     * @return 地图服务商的服务id
     */
    Long create(String name, String desc);

    /**
     * 创建轨迹服务
     * <p>
     * 使用轨迹功能必须先创建轨迹服务。
     * 百度地图不支持通过接口创建，请通过百度地图的轨迹服务管理系统创建，高德地图支持通过接口创建。
     * 百度地图管理地址：https://lbsyun.baidu.com/trace/admin/service
     *
     * @param name 服务名称
     * @return 地图服务商的服务id
     */
    Long create(String name);

    /**
     * 删除轨迹服务
     * 百度地图不支持通过接口删除，此方法仅仅是从数据库中删除数据，并不会从百度地图中删除，高德地图支持通过接口删除。
     * 百度地图管理地址：https://lbsyun.baidu.com/trace/admin/service
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @return
     */
    Boolean delete(ProviderEnum provider, Long serverId);

    /**
     * 删除轨迹服务，不指定服务商由系统自动选择
     * 百度地图不支持通过接口删除，此方法仅仅是从数据库中删除数据，并不会从百度地图中删除，高德地图支持通过接口删除。
     * 百度地图管理地址：https://lbsyun.baidu.com/trace/admin/service
     *
     * @param serverId 服务id
     * @return
     */
    Boolean delete(Long serverId);

    /**
     * 更新轨迹服务
     * <p>
     * 百度地图不支持通过接口更新，此方法仅仅是从数据库中更新数据，并不会从百度地图中更新，高德地图支持通过接口更新。
     * 百度地图管理地址：https://lbsyun.baidu.com/trace/admin/service
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @param name     服务名称
     * @param desc     服务描述，非必须
     * @return
     */
    Boolean update(ProviderEnum provider, Long serverId, String name, String desc);

    /**
     * 更新轨迹服务，不指定服务商由系统自动选择
     * <p>
     * 百度地图不支持通过接口更新，此方法仅仅是从数据库中更新数据，并不会从百度地图中更新，高德地图支持通过接口更新。
     * 百度地图管理地址：https://lbsyun.baidu.com/trace/admin/service
     *
     * @param serverId 服务id
     * @param name     服务名称
     * @param desc     服务描述，非必须
     * @return
     */
    Boolean update(Long serverId, String name, String desc);

    /**
     * 更新轨迹服务，不指定服务商由系统自动选择
     * <p>
     * 百度地图不支持通过接口更新，此方法仅仅是从数据库中更新数据，并不会从百度地图中更新，高德地图支持通过接口更新。
     * 百度地图管理地址：https://lbsyun.baidu.com/trace/admin/service
     *
     * @param serverId 服务id
     * @param name     服务名称
     * @return
     */
    Boolean update(Long serverId, String name);

    /**
     * 查询单个轨迹服务
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @return 轨迹服务信息
     */
    TraceServer queryById(ProviderEnum provider, Long serverId);

    /**
     * 查询单个轨迹服务，不指定服务商由系统自动选择
     *
     * @param serverId 服务id
     * @return 轨迹服务信息
     */
    TraceServer queryById(Long serverId);

    /**
     * 查询所有的轨迹服务
     *
     * @param provider 服务商
     * @return 轨迹服务信息列表
     */
    List<TraceServer> queryAll(ProviderEnum provider);

    /**
     * 查询所有的轨迹服务，不指定服务商由系统自动选择
     *
     * @return 轨迹服务信息列表
     */
    List<TraceServer> queryAll();

}
