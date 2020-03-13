package cn.prodapi.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author thomas
 */
public class PosterClient {

    final static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(6, TimeUnit.SECONDS)
            .build();
    private static final String USER_AGENT = "PosterClient-V2.0.0";

    /**
     * 接入点
     */
    private String endpoint;
    /**
     * 访问KEY
     */
    private String accessKey;

    public PosterClient(String endpoint, String accessKey) {

        this.accessKey = accessKey;

        endpoint = endpoint.trim();
        if (endpoint.endsWith("/")) {
            endpoint = endpoint.substring(0, endpoint.length() - 1);
        }
        this.endpoint = endpoint;

    }

    /**
     * 获取海报访问地址
     *
     * @param posterId 海报ID
     * @param params   参数列表
     * @return String
     */
    public String getUrl(String posterId, Map<String, String> params) {
        if (params == null) {
            params = new HashMap<>();
        }
        params.put("accessKey", this.accessKey);
        params.put("posterId", posterId);

        String url = this.endpoint + "/api/link";

        MediaType mediaType = MediaType.parse("application/json");
        String json = JSON.toJSONString(params, true);
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("User-Agent", USER_AGENT)
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            String jsonR = response.body().string();
            JSONObject o = JSONObject.parseObject(jsonR);
            if (o.getInteger("code") == 0) {
                url = o.getString("url");
            } else {
                System.out.println(jsonR);
            }
            return endpoint + url;
        } catch (IOException e) {
            throw new RuntimeException("获取海报链接异常", e);
        }
    }

    /**
     * 获取海报数据
     *
     * @param url
     * @return
     */
    public byte[] getData(String url) {
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("User-Agent", USER_AGENT)
                    .get()
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().bytes();
        } catch (Exception e) {
            throw new RuntimeException("获取海报数据异常", e);
        }
    }

    /**
     * 保存海报到文件
     *
     * @param url
     * @param path
     */
    public void saveToPath(String url, String path) {
        try {
            byte[] data = getData(url);
            FileUtils.writeByteArrayToFile(new File(path), data);
        } catch (IOException e) {
            new RuntimeException("保存海报到文件", e);
        }
    }

}
