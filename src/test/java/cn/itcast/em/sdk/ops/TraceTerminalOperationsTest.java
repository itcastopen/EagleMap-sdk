package cn.itcast.em.sdk.ops;

import cn.itcast.em.sdk.EagleMapTemplate;
import cn.itcast.em.sdk.enums.ProviderEnum;
import cn.itcast.em.sdk.vo.PageResult;
import cn.itcast.em.sdk.vo.TraceTerminal;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/16
 */
public class TraceTerminalOperationsTest {

    private EagleMapTemplate eagleMapTemplate;

    @Before
    public void init() {
        String host = "127.0.0.1";
        this.eagleMapTemplate = new EagleMapTemplate(host);
    }

    @Test
    public void create() {
        Long id = this.eagleMapTemplate.opsForTraceTerminal()
                .create(ProviderEnum.BAIDU, 231526L, "测试终端1", "测试终端描述1", null);
        System.out.println(id);
    }

    @Test
    public void delete() {
        Boolean result = this.eagleMapTemplate.opsForTraceTerminal()
                .delete(ProviderEnum.BAIDU, 231526L, 1503942717096951808L);
        System.out.println(result);
    }

    @Test
    public void update() {
        //百度地图不支持修改终端名称
        Boolean result = this.eagleMapTemplate.opsForTraceTerminal()
                .update(ProviderEnum.BAIDU, 231526L, 1503942717096951808L, "测试终端111", "测试终端描述111", null);
        System.out.println(result);
    }

    @Test
    public void queryList() {
        PageResult<TraceTerminal> pageResult = this.eagleMapTemplate.opsForTraceTerminal()
                .queryList(ProviderEnum.BAIDU, 231526L, 1, 20);
        System.out.println(pageResult);
    }

    @Test
    public void queryLastPointAmap() {
        Long serverId = 617418L;
        Long terminalId = 492666422L;
        Long traceId = 260L;
        String data = this.eagleMapTemplate.opsForTraceTerminal()
                .queryLastPoint(ProviderEnum.AMAP, serverId, terminalId, traceId);
        System.out.println(data);
    }

    @Test
    public void queryLastPointBaidu() {
        Long serverId = 231517L;
        Long terminalId = 1498562156533092352L;
        Long traceId = 1498572699788587008L;
        String data = this.eagleMapTemplate.opsForTraceTerminal()
                .queryLastPoint(ProviderEnum.BAIDU, serverId, terminalId, traceId);
        System.out.println(data);
    }
}