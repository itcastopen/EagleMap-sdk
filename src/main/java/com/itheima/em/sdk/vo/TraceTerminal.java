package com.itheima.em.sdk.vo;

import com.itheima.em.sdk.enums.ProviderEnum;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/16
 */
public class TraceTerminal {

    private ProviderEnum provider; //地图服务商
    private Long serverId; //地图服务商中的服务id
    private Long terminalId; //终端id
    private String name; //终端名称
    private String desc; //终端描述
    private String props; //用户自定义字段

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

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TraceTerminal{");
        sb.append("provider=").append(provider);
        sb.append(", serverId=").append(serverId);
        sb.append(", terminalId=").append(terminalId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", desc='").append(desc).append('\'');
        sb.append(", props='").append(props).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
