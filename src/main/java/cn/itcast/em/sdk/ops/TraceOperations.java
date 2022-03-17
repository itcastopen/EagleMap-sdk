package cn.itcast.em.sdk.ops;

import cn.itcast.em.sdk.enums.ServerType;
import cn.itcast.em.sdk.vo.PageResult;
import cn.itcast.em.sdk.vo.Trace;

import java.util.List;
import java.util.Map;

/**
 * 轨迹相关的功能
 *
 * @author zzj
 * @version 1.0
 * @date 2022/3/14
 */
public interface TraceOperations {

    /**
     * 创建轨迹
     *
     * @param provider   服务商
     * @param serverId   轨迹所属的服务id
     * @param terminalId 轨迹所属的终端id
     * @param name       轨迹名称
     * @return
     */
    Long create(ServerType provider, Long serverId, Long terminalId, String name);

    /**
     * 创建轨迹，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId   轨迹所属的服务id
     * @param terminalId 轨迹所属的终端id
     * @param name       轨迹名称
     * @return 轨迹id
     */
    Long create(Long serverId, Long terminalId, String name);

    /**
     * 删除轨迹
     *
     * @param provider   服务提供商
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @return 是否成功
     */
    Boolean delete(ServerType provider, Long serverId, Long terminalId, Long traceId);

    /**
     * 删除轨迹，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @return 是否成功
     */
    Boolean delete(Long serverId, Long terminalId, Long traceId);

    /**
     * 上传轨迹点
     *
     * @param provider   服务提供商
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @param pointList  轨迹点列表
     * @return 是否成功
     */
    Boolean upload(ServerType provider, Long serverId, Long terminalId, Long traceId, List<Map<String, Object>> pointList);

    /**
     * 上传轨迹点，不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @param pointList  轨迹点列表
     * @return 是否成功
     */
    Boolean upload(Long serverId, Long terminalId, Long traceId, List<Map<String, Object>> pointList);

    /**
     * 停止运动，该方法会将轨迹中的轨迹点数据持久化本地数据库中
     *
     * @param provider   服务提供商
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @param param      其他的请求参数，用于查询轨迹详情的参数
     * @@return 是否成功
     */
    Boolean stopTrace(ServerType provider, Long serverId, Long terminalId, Long traceId, Map<String, Object> param);

    /**
     * 停止运动，该方法会将轨迹中的轨迹点数据持久化本地数据库中
     * 不指定服务商由EagleMap选择，默认高德地图
     *
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @param param      其他的请求参数，用于查询轨迹详情的参数
     * @@return 是否成功
     */
    Boolean stopTrace(Long serverId, Long terminalId, Long traceId, Map<String, Object> param);

    /**
     * 分页查询轨迹列表，按照轨迹创建时间倒序排序
     *
     * @param provider 服务提供商
     * @param page     页数
     * @param pageSize 页面大小
     * @return 轨迹列表数据
     */
    PageResult<Trace> queryTracePageList(ServerType provider, Integer page, Integer pageSize);

    /**
     * 分页查询轨迹列表，按照轨迹创建时间倒序排序
     * 不指定服务商由EagleMap选择，默认高德地图
     *
     * @param page     页数
     * @param pageSize 页面大小
     * @return 轨迹列表数据
     */
    PageResult<Trace> queryTracePageList(Integer page, Integer pageSize);

    /**
     * 查询轨迹详情，优先查询本地数据库，如本地库中没有数据，再查询地图服务商
     * 可以通过param参数中的local参数进行控制，默认为true，如果不希望查询本地库，就将其设置为false
     *
     * @param provider   服务提供商
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @param param      其他的请求参数，用于查询轨迹详情的参数
     * @return 轨迹信息
     */
    Trace queryTraceInfo(ServerType provider, Long serverId, Long terminalId, Long traceId, Map<String, Object> param);

    /**
     * 查询轨迹详情，优先查询本地数据库，如本地库中没有数据，再查询地图服务商
     * 可以通过param参数中的local参数进行控制，默认为true，如果不希望查询本地库，就将其设置为false
     *
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @param param      其他的请求参数，用于查询轨迹详情的参数
     * @return 轨迹信息
     */
    Trace queryTraceInfo(Long serverId, Long terminalId, Long traceId, Map<String, Object> param);

    /**
     * 查询轨迹详情，不查询本地数据库，直接从地图服务商查询
     * 百度地图是按照时间查询的，每次查询时都设置当前时间为结束时间，并且百度不支持查询超过24小时的轨迹点数据
     * 超过24小时的建议先将轨迹停止，再通过本地查询
     *
     * @param provider   服务提供商
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @param param      其他的请求参数，用于查询轨迹详情的参数
     * @return
     */
    Trace queryOnLineTraceInfo(ServerType provider, Long serverId, Long terminalId, Long traceId, Map<String, Object> param);

    /**
     * 查询轨迹详情，不查询本地数据库，直接从地图服务商查询
     * 百度地图是按照时间查询的，每次查询时都设置当前时间为结束时间，并且百度不支持查询超过24小时的轨迹点数据
     * 超过24小时的建议先将轨迹停止，再通过本地查询
     *
     * @param provider   服务提供商
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @return
     */
    Trace queryOnLineTraceInfo(ServerType provider, Long serverId, Long terminalId, Long traceId);

    /**
     * 查询轨迹详情，不查询本地数据库，直接从地图服务商查询
     * 百度地图是按照时间查询的，每次查询时都设置当前时间为结束时间，并且百度不支持查询超过24小时的轨迹点数据
     * 超过24小时的建议先将轨迹停止，再通过本地查询
     *
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @param param      其他的请求参数，用于查询轨迹详情的参数
     * @return
     */
    Trace queryOnLineTraceInfo(Long serverId, Long terminalId, Long traceId, Map<String, Object> param);

    /**
     * 查询轨迹详情，不查询本地数据库，直接从地图服务商查询
     * 百度地图是按照时间查询的，每次查询时都设置当前时间为结束时间，并且百度不支持查询超过24小时的轨迹点数据
     * 超过24小时的建议先将轨迹停止，再通过本地查询
     *
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @return
     */
    Trace queryOnLineTraceInfo(Long serverId, Long terminalId, Long traceId);

    /**
     * 查询轨迹缩略图
     *
     * @param provider   服务商
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @param width      图片宽度，默认：300
     * @param height     图片高度，默认：300
     * @param param      其他的请求参数，用于查询轨迹详情的参数
     * @return base64图片数据，在网页中 <img src="data:image/jpg;base64,xxxxxxxxxxxxxxxxx"/> 显示
     */
    String queryTraceImage(ServerType provider, Long serverId, Long terminalId, Long traceId, Integer width, Integer height, Map<String, Object> param);

    /**
     * 查询轨迹缩略图
     *
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @param width      图片宽度，默认：300
     * @param height     图片高度，默认：300
     * @param param      其他的请求参数，用于查询轨迹详情的参数
     * @return base64图片数据，在网页中 <img src="data:image/jpg;base64,xxxxxxxxxxxxxxxxx"/> 显示
     */
    String queryTraceImage(Long serverId, Long terminalId, Long traceId, Integer width, Integer height, Map<String, Object> param);

    /**
     * 查询轨迹缩略图
     *
     * @param serverId   服务id
     * @param terminalId 终端id
     * @param traceId    轨迹id
     * @return base64图片数据，在网页中 <img src="data:image/jpg;base64,xxxxxxxxxxxxxxxxx"/> 显示
     */
    String queryTraceImage(Long serverId, Long terminalId, Long traceId);

}
