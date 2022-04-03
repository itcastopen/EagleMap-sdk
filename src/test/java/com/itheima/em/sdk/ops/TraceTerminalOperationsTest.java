package com.itheima.em.sdk.ops;

import com.itheima.em.sdk.EagleMapTemplate;
import com.itheima.em.sdk.enums.ProviderEnum;
import com.itheima.em.sdk.vo.PageResult;
import com.itheima.em.sdk.vo.TraceTerminal;
import org.junit.Before;
import org.junit.Test;

public class TraceTerminalOperationsTest {

    private EagleMapTemplate eagleMapTemplate;

    @Before
    public void init() {
        String host = "127.0.0.1";
        this.eagleMapTemplate = new EagleMapTemplate(host);
    }

    @Test
    public void create() { //创建终端
        Long id = this.eagleMapTemplate.opsForTraceTerminal()
                .create(ProviderEnum.BAIDU, 231526L, "测试终端1", "测试终端描述1", null);
        System.out.println(id);
    }

    @Test
    public void delete() { //删除终端
        Boolean result = this.eagleMapTemplate.opsForTraceTerminal()
                .delete(ProviderEnum.BAIDU, 231526L, 1503942717096951808L);
        System.out.println(result);
    }

    @Test
    public void update() { //更新终端
        //百度地图不支持修改终端名称
        Boolean result = this.eagleMapTemplate.opsForTraceTerminal()
                .update(ProviderEnum.BAIDU, 231526L, 1503942717096951808L, "测试终端111", "测试终端描述111", null);
        System.out.println(result);
    }

    @Test
    public void queryList() { //查询终端列表
        PageResult<TraceTerminal> pageResult = this.eagleMapTemplate.opsForTraceTerminal()
                .queryList(ProviderEnum.BAIDU, 231526L, 1, 20);
        System.out.println(pageResult);
    }

    @Test
    public void queryLastPointAmap() { //查询终端在某个轨迹中的最新位置
        Long serverId = 617418L;
        Long terminalId = 492666422L;
        Long traceId = 260L;
        String data = this.eagleMapTemplate.opsForTraceTerminal()
                .queryLastPoint(ProviderEnum.AMAP, serverId, terminalId, traceId);
        System.out.println(data);
    }

    @Test
    public void queryLastPointBaidu() { //查询终端在某个轨迹中的最新位置
        Long serverId = 231517L;
        Long terminalId = 1498562156533092352L;
        Long traceId = 1498572699788587008L;
        String data = this.eagleMapTemplate.opsForTraceTerminal()
                .queryLastPoint(ProviderEnum.BAIDU, serverId, terminalId, traceId);
        System.out.println(data);
    }
}