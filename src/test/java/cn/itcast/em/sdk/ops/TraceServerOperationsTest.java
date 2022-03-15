package cn.itcast.em.sdk.ops;

import cn.itcast.em.sdk.EagleMapTemplate;
import cn.itcast.em.sdk.enums.ServerType;
import cn.itcast.em.sdk.vo.TraceServer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/15
 */
public class TraceServerOperationsTest {


    private EagleMapTemplate eagleMapTemplate;

    @Before
    public void init() {
        String host = "127.0.0.1";
        this.eagleMapTemplate = new EagleMapTemplate(host);
    }

    @Test
    public void create() {
        Long serverId = this.eagleMapTemplate.opsForTraceServer().create("测试轨迹1", "测试轨迹描述1");
        System.out.println(serverId);
    }

    @Test
    public void delete() {
        Boolean result = this.eagleMapTemplate.opsForTraceServer()
                .delete(634598L);
        System.out.println(result);
    }

    @Test
    public void update() {
        Boolean result = this.eagleMapTemplate.opsForTraceServer()
                .update(634598L, "测试轨迹11", "测试轨迹描述11");
        System.out.println(result);
    }

    @Test
    public void queryById() {
        TraceServer traceServer = this.eagleMapTemplate.opsForTraceServer().queryById(634598L);
        System.out.println(traceServer);
    }

    @Test
    public void queryAll() {
        List<TraceServer> traceServerList =
                this.eagleMapTemplate.opsForTraceServer().queryAll(ServerType.AMAP);
        traceServerList.forEach(traceServer -> System.out.println(traceServer));
    }
}