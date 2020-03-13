package cn.prodapi.api;

import org.apache.commons.io.FilenameUtils;

import java.util.HashMap;
import java.util.Map;

public class PosterClientDemo {

    public static void main(String[] args) {

        PosterClient posterClient = new PosterClient("http://127.0.0.1:9001/", "t8xAmqoXQliBhMsV");
        Map<String, String> params = new HashMap<>();
        params.put("qrcode", "http://www.baidu.com/");
        params.put("text", "小可爱");
        params.put("headImg", "http://");
        Integer posterId = 1;
        String url = posterClient.getUrl(posterId, params);
        System.out.println("url=" + url);
        if (url != null) {
            posterClient.saveToPath(url, FilenameUtils.getName(url));
        }

    }

}
