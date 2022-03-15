package cn.itcast.em.sdk.vo;

import cn.itcast.em.sdk.enums.ServerType;

import java.util.Date;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/15
 */
public class TraceServer {

    private ServerType provider; //地图服务商
    private Long serverId; //地图服务商中的服务id
    private String name; //服务名称
    private String desc; //服务描述
    private Boolean status; //服务描述
    private Date created;
    private Date updated;

    public ServerType getProvider() {
        return provider;
    }

    public void setProvider(ServerType provider) {
        this.provider = provider;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TraceServer{");
        sb.append("provider=").append(provider);
        sb.append(", serverId=").append(serverId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", desc='").append(desc).append('\'');
        sb.append(", status=").append(status);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append('}');
        return sb.toString();
    }
}
