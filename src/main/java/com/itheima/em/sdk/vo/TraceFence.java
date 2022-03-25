package com.itheima.em.sdk.vo;

import com.itheima.em.sdk.enums.FenceEnum;
import com.itheima.em.sdk.enums.ProviderEnum;

/**
 * 电子围栏
 *
 * @author zzj
 * @version 1.0
 * @date 2022/3/17
 */
public class TraceFence {

    private ProviderEnum provider; //地图服务商
    private Long serverId; //地图服务商中的服务id
    private Long fenceId; //地图服务商的围栏id
    private String name; //围栏名称
    private String desc; //围栏描述
    private FenceEnum type; //电子围栏类型，1-圆形，2-多边形，3-线性，4-行政区
    private String param; //创建围栏的参数

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

    public Long getFenceId() {
        return fenceId;
    }

    public void setFenceId(Long fenceId) {
        this.fenceId = fenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public FenceEnum getType() {
        return type;
    }

    public void setType(FenceEnum type) {
        this.type = type;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TraceFence{");
        sb.append("provider=").append(provider);
        sb.append(", serverId=").append(serverId);
        sb.append(", fenceId=").append(fenceId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", desc='").append(desc).append('\'');
        sb.append(", type=").append(type);
        sb.append(", param='").append(param).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
