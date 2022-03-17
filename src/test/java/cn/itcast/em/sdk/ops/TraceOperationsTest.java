package cn.itcast.em.sdk.ops;

import cn.hutool.core.map.MapUtil;
import cn.itcast.em.sdk.EagleMapTemplate;
import cn.itcast.em.sdk.enums.ServerType;
import cn.itcast.em.sdk.vo.PageResult;
import cn.itcast.em.sdk.vo.Trace;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/16
 */
public class TraceOperationsTest {


    private EagleMapTemplate eagleMapTemplate;

    @Before
    public void init() {
        String host = "127.0.0.1";
        this.eagleMapTemplate = new EagleMapTemplate(host);
    }

    @Test
    public void create() {
        Long traceId = this.eagleMapTemplate.opsForTrace()
                .create(ServerType.AMAP, 617418L, 492731778L, "trace_" + System.currentTimeMillis());

        System.out.println(traceId);
    }

    @Test
    public void delete() {
    }

    @Test
    public void upload() {
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
                .upload(617418L, 492731778L, 240L, pointList);
        System.out.println(result);
    }

    @Test
    public void stopTrace() {
        Boolean result = this.eagleMapTemplate.opsForTrace()
                .stopTrace(617418L, 492731778L, 240L, null);
        System.out.println(result);
    }

    @Test
    public void queryTracePageList() {
        PageResult<Trace> tracePageResult = this.eagleMapTemplate.opsForTrace()
                .queryTracePageList(1, 20);
        tracePageResult.getItems()
                .forEach(trace -> System.out.println(trace));
    }

    @Test
    public void queryTraceInfo() {
        Long serverId = 617418L;
        Long terminalId = 492731778L;
        Long traceId = 240L;

        Trace trace = this.eagleMapTemplate.opsForTrace()
                .queryTraceInfo(serverId, terminalId, traceId, null);

        System.out.println(trace);
    }

    @Test
    public void queryTraceImage() {
        String image = this.eagleMapTemplate.opsForTrace()
                .queryTraceImage(ServerType.AMAP, 617418L, 492731778L, 240L, null, null, null);
        System.out.println(image);
    }
}