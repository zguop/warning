package com.waitou.warning_lib;

import okhttp3.OkHttpClient;

/**
 * auth aboom
 * date 2019-12-29
 */
public class Warning {

    public String baseUrl;
    public String url;
    public OkHttpClient okHttpClient;

    public Warning(String baseUrl, String url) {
        this.baseUrl = baseUrl;
        this.url = url;
    }

    public Warning(String baseUrl, String url, OkHttpClient okHttpClient) {
        this.baseUrl = baseUrl;
        this.url = url;
        this.okHttpClient = okHttpClient;
    }
}
