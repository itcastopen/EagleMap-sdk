package cn.itcast.em.sdk.vo;

import cn.itcast.em.sdk.enums.ProviderEnum;

import java.util.Date;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/16
 */
public class Trace {
    private ProviderEnum provider; //地图服务商
    private Long serverId; //所属的服务id
    private Long terminalId; //所属的终端id
    private Long traceId; //地图服务商的轨迹id
    private String name; //轨迹名称
    private Integer status; //状态，0-运动中，1-已结束
    private Date startTime; //开始时间
    private Date endTime; //结束时间
    private Integer size; //轨迹点数量
    private Double distance; //此段轨迹的里程数，单位：米
    private Long time; //轨迹持续时间，单位：毫秒
    private String startPoint; //起点坐标，经纬度，逗号分隔
    private String endPoint; //终点坐标，经纬度，逗号分隔
    private String pointList; //轨迹点数据，json格式

    public ProviderEnum getProvider() {
        return provider;
    }

    public void setProvider(ProviderEnum provider) {
        this.provider = provider;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public Long getTraceId() {
        return traceId;
    }

    public void setTraceId(Long traceId) {
        this.traceId = traceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getPointList() {
        return pointList;
    }

    public void setPointList(String pointList) {
        this.pointList = pointList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Trace{");
        sb.append("provider=").append(provider);
        sb.append(", serverId=").append(serverId);
        sb.append(", terminalId=").append(terminalId);
        sb.append(", traceId=").append(traceId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", status=").append(status);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", size=").append(size);
        sb.append(", distance=").append(distance);
        sb.append(", time=").append(time);
        sb.append(", startPoint='").append(startPoint).append('\'');
        sb.append(", endPoint='").append(endPoint).append('\'');
        sb.append(", pointList='").append(pointList).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
