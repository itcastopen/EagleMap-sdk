package com.itheima.em.sdk.ops;

import cn.hutool.core.map.MapUtil;
import com.itheima.em.sdk.EagleMapTemplate;
import com.itheima.em.sdk.enums.ProviderEnum;
import com.itheima.em.sdk.vo.PageResult;
import com.itheima.em.sdk.vo.Trace;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraceOperationsTest {


    private EagleMapTemplate eagleMapTemplate;

    @Before
    public void init() {
        String host = "127.0.0.1";
        this.eagleMapTemplate = new EagleMapTemplate(host);
    }

    @Test
    public void create() { //创建轨迹
        Long serverId = 617418L;
        Long terminalId = 492666422L;

        Long traceId = this.eagleMapTemplate.opsForTrace()
                .create(ProviderEnum.AMAP, serverId, terminalId, "trace_" + System.currentTimeMillis());

        System.out.println(traceId);
    }

    @Test
    public void delete() { //删除轨迹
        Long serverId = 617418L;
        Long terminalId = 492666422L;
        Long traceId = 260L;
        Boolean result = this.eagleMapTemplate.opsForTrace()
                .delete(serverId, terminalId, traceId);
        System.out.println(result);
    }

    @Test
    public void upload() { //上传轨迹点
        Long serverId = 617418L;
        Long terminalId = 492666422L;
        Long traceId = 260L;

        List<Map<String, Object>> pointList = new ArrayList<>();
        long time = System.currentTimeMillis();
        pointList.add(MapUtil.builder(new HashMap<String, Object>())
                .put("location", "116.343982,40.060585")
                .put("locatetime", time - 50000)
                .put("speed", "")
                .build());

        pointList.add(MapUtil.builder(new HashMap<String, Object>())
                .put("location", "116.343961,40.059769")
                .put("locatetime", time - 40000)
                .put("speed", "")
                .build());

        pointList.add(MapUtil.builder(new HashMap<String, Object>())
                .put("location", "116.341879,40.059392")
                .put("locatetime", time - 30000)
                .put("speed", "")
                .build());

        pointList.add(MapUtil.builder(new HashMap<String, Object>())
                .put("location", "116.340377,40.059145")
                .put("locatetime", time - 30000)
                .put("speed", "")
                .build());

        pointList.add(MapUtil.builder(new HashMap<String, Object>())
                .put("location", "116.340077,40.060705")
                .put("locatetime", time - 20000)
                .put("speed", "")
                .build());

        pointList.add(MapUtil.builder(new HashMap<String, Object>())
                .put("location", "116.344132,40.061937")
                .put("locatetime", time - 10000)
                .put("speed", "")
                .build());

        Boolean result = this.eagleMapTemplate.opsForTrace()
                .upload(ProviderEnum.AMAP, serverId, terminalId, traceId, pointList);
        System.out.println(result);
    }

    @Test
    public void stopTrace() { //停止轨迹
        Boolean result = this.eagleMapTemplate.opsForTrace()
                .stopTrace(617418L, 492731778L, 240L, null);
        System.out.println(result);
    }

    @Test
    public void queryTracePageList() { //分页查询轨迹列表
        PageResult<Trace> tracePageResult = this.eagleMapTemplate.opsForTrace()
                .queryTracePageList(1, 20);
        tracePageResult.getItems()
                .forEach(trace -> System.out.println(trace));
    }

    @Test
    public void queryTraceInfo() { //查询轨迹详情
        Long serverId = 617418L;
        Long terminalId = 492666422L;
        Long traceId = 260L;

        Trace trace = this.eagleMapTemplate.opsForTrace()
                .queryTraceInfo(serverId, terminalId, traceId, null);

        System.out.println(trace);
    }

    @Test
    public void queryTraceImage() { //查询轨迹缩略图
        String image = this.eagleMapTemplate.opsForTrace()
                .queryTraceImage(ProviderEnum.AMAP, 617418L, 492731778L, 240L, null, null, null);
        System.out.println(image);
    }
}