package com.itheima.em.sdk.ops;

import com.itheima.em.sdk.enums.ProviderEnum;
import com.itheima.em.sdk.vo.PageResult;
import com.itheima.em.sdk.vo.TraceTerminal;

import java.util.Map;

/**
 * 轨迹终端管理
 *
 * @author zzj
 * @version 1.0
 * @date 2022/3/14
 */
public interface TraceTerminalOperations {


    /**
     * 创建终端
     *
     * @param provider 服务提供商
     * @param serverId 服务id
     * @param name     终端名称
     * @param desc     终端描述
     * @param props    自定义字段，具体参考百度/高德文档
     * @return 终端id
     */
    Long create(ProviderEnum provider, Long serverId, String name, String desc, Map<String, Object> props);

    /**
     * 创建终端，不指定服务id，EagleMap会选择一个可用的服务，如果没有可用的服务将自动创建（仅限高德地图，百度地图不会自动创建服务）
     *
     * @param provider 服务提供商
     * @param name     终端名称
     * @param desc     终端描述
     * @param props    自定义字段，具体参考百度/高德文档
     * @return 终端id
     */
    Long create(ProviderEnum provider, String name, String desc, Map<String, Object> props);

    /**
     * 创建终端，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId 服务id
     * @param name     终端名称
     * @param desc     终端描述
     * @param props    自定义字段，具体参考百度/高德文档
     * @return 终端id
     */
    Long create(Long serverId, String name, String desc, Map<String, Object> props);

    /**
     * 创建终端，不指定服务商由EagleMap选择，默认高德地图
     * 不指定服务id，EagleMap会选择一个可用的服务，如果没有可用的服务将自动创建（仅限高德地图，百度地图不会自动创建服务）
     *
     * @param name  终端名称
     * @param desc  终端描述
     * @param props 自定义字段，具体参考百度/高德文档
     * @return 终端id
     */
    Long create(String name, String desc, Map<String, Object> props);

    /**
     * 创建终端
     *
     * @param provider 服务提供商
     * @param serverId 服务id
     * @param name     终端名称
     * @param desc     终端描述
     * @return 终端id
     */
    Long create(ProviderEnum provider, Long serverId, String name, String desc);

    /**
     * 创建终端,不指定服务id，EagleMap会选择一个可用的服务，如果没有可用的服务将自动创建（仅限高德地图，百度地图不会自动创建服务）
     *
     * @param provider 服务提供商
     * @param name     终端名称
     * @param desc     终端描述
     * @return 终端id
     */
    Long create(ProviderEnum provider, String name, String desc);

    /**
     * 创建终端
     *
     * @param serverId 服务id
     * @param name     终端名称
     * @param desc     终端描述
     * @return 终端id
     */
    Long create(Long serverId, String name, String desc);

    /**
     * 创建终端，不指定服务商由EagleMap选择，默认高德地图
     * 不指定服务id，EagleMap会选择一个可用的服务，如果没有可用的服务将自动创建（仅限高德地图，百度地图不会自动创建服务）
     *
     * @param name 终端名称
     * @param desc 终端描述
     * @return 终端id
     */
    Long create(String name, String desc);

    /**
     * 删除终端
     *
     * @param provider   服务商
     * @param serverId   服务id
     * @param terminalId 终端id
     * @return 是否成功
     */
    Boolean delete(ProviderEnum provider, Long serverId, Long terminalId);

    /**
     * 删除终端，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId   服务id
     * @param terminalId 终端id
     * @return 是否成功
     */
    Boolean delete(Long serverId, Long terminalId);

    /**
     * 更新轨迹终端，百度地图不支持修改终端名称
     *
     * @param provider   服务商
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param name       迹终名称
     * @param desc       迹终描述
     * @param props      自定义参数
     * @return 是否成功
     */
    Boolean update(ProviderEnum provider, Long serverId, Long terminalId, String name, String desc, Map<String, Object> props);

    /**
     * 更新轨迹终端，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param name       迹终名称
     * @param desc       迹终描述
     * @param props      自定义参数
     * @return 是否成功
     */
    Boolean update(Long serverId, Long terminalId, String name, String desc, Map<String, Object> props);

    /**
     * 更新轨迹终端
     *
     * @param provider   服务商
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param name       迹终名称
     * @param desc       迹终描述
     * @return 是否成功
     */
    Boolean update(ProviderEnum provider, Long serverId, Long terminalId, String name, String desc);

    /**
     * 更新轨迹终端，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param name       迹终名称
     * @param desc       迹终描述
     * @return 是否成功
     */
    Boolean update(Long serverId, Long terminalId, String name, String desc);

    /**
     * 更新轨迹终端
     *
     * @param provider   服务商
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param name       迹终名称
     * @return 是否成功
     */
    Boolean update(ProviderEnum provider, Long serverId, Long terminalId, String name);

    /**
     * 更新轨迹终端，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param name       迹终名称
     * @return 是否成功
     */
    Boolean update(Long serverId, Long terminalId, String name);

    /**
     * 查询终端列表
     *
     * @param provider   服务商
     * @param serverId   服务id
     * @param terminalId 终端id，非必须，如果指定就按照终端id查询，否则查询列表
     * @param name       迹终名称，非必须，如果指定就按照终端名称查询，否则查询列表
     * @param page       页数，默认：1
     * @param pageSize   页面大小，默认：50
     * @return 分页结果数据
     */
    PageResult<TraceTerminal> queryList(ProviderEnum provider, Long serverId, Long terminalId, String name, Integer page, Integer pageSize);

    /**
     * 查询终端列表
     *
     * @param provider 服务商
     * @param serverId 服务id
     * @param page     页数
     * @param pageSize 页面大小
     * @return 分页结果数据
     */
    PageResult<TraceTerminal> queryList(ProviderEnum provider, Long serverId, Integer page, Integer pageSize);

    /**
     * 查询终端列表，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId 服务id
     * @param page     页数
     * @param pageSize 页面大小
     * @return 分页结果数据
     */
    PageResult<TraceTerminal> queryList(Long serverId, Integer page, Integer pageSize);

    /**
     * 查询终端在某个轨迹中的最新位置
     *
     * @param provider   服务商
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @return 服务商响应的数据
     */
    String queryLastPoint(ProviderEnum provider, Long serverId, Long terminalId, Long traceId);

    /**
     * 查询终端在某个轨迹中的最新位置
     *
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @return 服务商响应的数据
     */
    String queryLastPoint(Long serverId, Long terminalId, Long traceId);

}
