package com.waitou.warning_lib;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * auth aboom
 * date 2019-12-29
 */
public class WarningUtils {

    public static void waringPerform(Warning warning) {
        OkHttpClient okHttpClient;
        if (warning.okHttpClient != null) {
            okHttpClient = warning.okHttpClient;
        } else {
            okHttpClient = new OkHttpClient();
        }
        final Request request = new Request.Builder()
                .url(warning.baseUrl + warning.url)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.e("aa", "onFailure e " + e.getMessage());
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                Log.e("aa", "onResponse " );

                if (!response.isSuccessful()) {
                    return;
                }
                ResponseBody responseBody = response.body();
                if (responseBody == null) {
                    return;
                }
                String string = responseBody.string();
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                try {
                    JSONObject resultJson = new JSONObject(string);
                    boolean w = resultJson.getBoolean("warning");
                    if (w) {
                        throw new RuntimeException("error");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
