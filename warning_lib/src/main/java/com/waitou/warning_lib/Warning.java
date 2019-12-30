package com.waitou.warning_lib;

import okhttp3.OkHttpClient;

/**
 * auth aboom
 * date 2019-12-29
 */
public class Warning {
    public String url;
    public String jsonKey;
    public OkHttpClient okHttpClient;

    public Warning(String url) {
        this.url = url;
    }

    public Warning(String url, String jsonKey) {
        this.url = url;
        this.jsonKey = jsonKey;
    }

    public Warning(String url, String jsonKey, OkHttpClient okHttpClient) {
        this.url = url;
        this.jsonKey = jsonKey;
        this.okHttpClient = okHttpClient;

    }
}
