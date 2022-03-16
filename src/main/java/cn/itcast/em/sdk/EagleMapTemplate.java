package cn.itcast.em.sdk;

import cn.itcast.em.sdk.config.EagleMapConfig;
import cn.itcast.em.sdk.ops.BaseOperations;
import cn.itcast.em.sdk.ops.DirectionOperations;
import cn.itcast.em.sdk.ops.TraceServerOperations;
import cn.itcast.em.sdk.ops.TraceTerminalOperations;
import cn.itcast.em.sdk.ops.impl.DefaultBaseOperations;
import cn.itcast.em.sdk.ops.impl.DefaultDirectionOperations;
import cn.itcast.em.sdk.ops.impl.DefaultTraceServerOperations;
import cn.itcast.em.sdk.ops.impl.DefaultTraceTerminalOperations;
import cn.itcast.em.sdk.service.FormHttpApiService;
import cn.itcast.em.sdk.service.JsonHttpApiService;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/14
 */
public class EagleMapTemplate {

    private EagleMapConfig eagleMapConfig;
    private FormHttpApiService formHttpApiService;
    private JsonHttpApiService jsonHttpApiService;
    private BaseOperations baseOperations;
    private DirectionOperations directionOperations;
    private TraceServerOperations traceServerOperations;
    private TraceTerminalOperations traceTerminalOperations;

    /**
     * 对于地图基础服务进行操作
     *
     * @return
     */
    public BaseOperations opsForBase() {
        return this.baseOperations;
    }

    /**
     * 对于地图中路线规划的操作
     *
     * @return
     */
    public DirectionOperations opsForDirection() {
        return this.directionOperations;
    }

    /**
     * 对于地图中轨迹服务的操作
     *
     * @return
     */
    public TraceServerOperations opsForTraceServer() {
        return this.traceServerOperations;
    }

    /**
     * 对于地图中轨迹服务的操作
     *
     * @return
     */
    public TraceTerminalOperations opsForTraceTerminal() {
        return this.traceTerminalOperations;
    }

    public EagleMapTemplate(String host, int port, int timeout) {
        this.eagleMapConfig = new EagleMapConfig(host, port, timeout);
        this.formHttpApiService = new FormHttpApiService(this.eagleMapConfig);
        this.jsonHttpApiService = new JsonHttpApiService(this.eagleMapConfig);
        this.baseOperations = new DefaultBaseOperations(this);
        this.directionOperations = new DefaultDirectionOperations(this);
        this.traceServerOperations = new DefaultTraceServerOperations(this);
        this.traceTerminalOperations = new DefaultTraceTerminalOperations(this);
    }

    public EagleMapTemplate(String host, int port) {
        this(host, port, 10000);
    }

    public EagleMapTemplate(String host) {
        this(host, 8484, 10000);
    }

    public EagleMapConfig getEagleMapConfig() {
        return eagleMapConfig;
    }

    public FormHttpApiService getFormHttpApiService() {
        return formHttpApiService;
    }

    public JsonHttpApiService getJsonHttpApiService() {
        return jsonHttpApiService;
    }
}
