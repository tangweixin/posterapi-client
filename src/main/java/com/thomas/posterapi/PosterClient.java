package com.thomas.posterapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 海报客户端
 *
 * @author thomas
 * @date 2019-07-19
 */
public class PosterClient {

    final static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(6, TimeUnit.SECONDS)
            .build();

    final static String URL = "http://p0.prodapi.cn/api/link";

    final static String USER_AGENT = "PosterClient-V1.0.0";

    public static Builder newBulder(String accessKey, String posterId) {
        return new Builder(accessKey, posterId);
    }

    private PosterClient() {
    }

    private Map<String, String> map = new HashMap<>();

    public static class Builder {

        PosterClient client = new PosterClient();

        public Builder(String accessKey, String posterId) {
            client.map.put("accessKey", accessKey);
            client.map.put("posterId", posterId);
        }

        public Builder add(String name, String value) {
            client.map.put(name, value);
            return this;
        }

        public PosterClient build() {
            return client;
        }

    }

    private String url = null;

    /**
     * 获取海报的URL地址
     *
     * @return
     */
    public String get() {
        if (url != null) {
            return url;
        }
        try {
            MediaType mediaType = MediaType.parse("application/json");
            String json = JSON.toJSONString(map, true);
            RequestBody body = RequestBody.create(mediaType, json);
            Request request = new Request.Builder()
                    .url(URL)
                    .post(body)
                    .addHeader("User-Agent", USER_AGENT)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            String jsonR = response.body().string();
            JSONObject o = JSONObject.parseObject(jsonR);
            String url = null;
            if (o.getInteger("code") == 0) {
                url = o.getString("url");
            } else {
                System.out.println(jsonR);
            }
            this.url = url;
            return url;
        } catch (Exception e) {
            throw new RuntimeException("获取海报异常", e);
        }
    }

    /**
     * 下载海报
     *
     * @return 海报的字节数组
     */
    public byte[] down() {
        if (url == null) {
            this.get();
        }
        if (url != null) {
            // 执行获取逻辑
            try {
                Request request = new Request.Builder()
                        .url(url)
                        .addHeader("User-Agent", USER_AGENT)
                        .get()
                        .build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().bytes();
            } catch (Exception e) {
                throw new RuntimeException("下载海报异常", e);
            }
        }
        return null;
    }

}
