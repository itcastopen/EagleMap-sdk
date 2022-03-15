package cn.itcast.em.sdk.config;

import cn.hutool.core.util.StrUtil;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/14
 */
public class EagleMapConfig {

    private String host;
    private int port;
    private int timeout;

    public String getUri() {
        return StrUtil.format("http://{}:{}", this.host, this.port);
    }

    public EagleMapConfig(String host, int port, int timeout) {
        this.host = host;
        this.port = port;
        this.timeout = timeout;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
