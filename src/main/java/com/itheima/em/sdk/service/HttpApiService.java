package com.itheima.em.sdk.service;

import cn.hutool.core.convert.Convert;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.Method;

import java.util.Map;

public abstract class HttpApiService {

    public <T> T execute(String url, Method method, Map<String, Object> param, Function<T, HttpResponse> function) {
        HttpRequest httpRequest;
        switch (method) {
            case GET: {
                httpRequest = HttpRequest.get(url);
                break;
            }
            case POST: {
                httpRequest = HttpRequest.post(url);
                break;
            }
            case PUT: {
                httpRequest = HttpRequest.put(url);
                break;
            }
            case DELETE: {
                httpRequest = HttpRequest.delete(url);
                break;
            }
            default: {
                return null;
            }
        }
        //设置请求参数
        setRequestHeader(httpRequest);

        //设置请求参数
        setRequestParam(httpRequest, param);

        try {
            //发起请求
            HttpResponse response = httpRequest
                    .timeout(Convert.toInt(getTimeOut(), 10000))//超时，毫秒
                    .execute();
            return function.callback(response);
        } catch (Exception e) {
            //出现错误，抛出异常进行重试
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置请求头, 默认实现form表单头，如果添加其他的头信息请覆盖实现此方法
     *
     * @param httpRequest
     */
    public void setRequestHeader(HttpRequest httpRequest) {
        httpRequest.header(Header.CONTENT_TYPE, "application/x-www-form-urlencoded");
    }

    /**
     * 设置请求参数
     *
     * @param httpRequest
     * @param param
     */
    protected abstract void setRequestParam(HttpRequest httpRequest, Map<String, Object> param);

    protected abstract int getTimeOut();

    public <T> T doGet(String url, Map<String, Object> param, Function<T, HttpResponse> function) {
        return this.execute(url, Method.GET, param, function);
    }

    public <T> T doPost(String url, Map<String, Object> param, Function<T, HttpResponse> function) {
        return this.execute(url, Method.POST, param, function);
    }

    public <T> T doPut(String url, Map<String, Object> param, Function<T, HttpResponse> function) {
        return this.execute(url, Method.PUT, param, function);
    }

    public <T> T doDelete(String url, Map<String, Object> param, Function<T, HttpResponse> function) {
        return this.execute(url, Method.DELETE, param, function);
    }
}
