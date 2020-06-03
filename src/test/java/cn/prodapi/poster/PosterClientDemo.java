package cn.prodapi.poster;

import java.util.HashMap;
import java.util.Map;

public class PosterClientDemo {

    public static void main(String[] args) {

//        PosterClient posterClient = new PosterClient("http://127.0.0.1:9001/", "2NAPIFheaXyL4d2r", "J5GlMp9mzqkTgAiu");
        PosterClient posterClient = new PosterClient("http://127.0.0.1:9001/", "2NAPIFheaXyL4d2r", "00000_J5GlMp9mzqkTgAiu");
//        PosterClient posterClient = new PosterClient("https://poster.prodapi.cn/", "2NAPIFheaXyL4d2r", "J5GlMp9mzqkTgAiu");

        Map<String, String> params = new HashMap<>();
//        params.put("qrcode", "http://demo.qn.prodapi.cn/images/qiniu.png");
//        params.put("bgUrl", "http://demo.qn.prodapi.cn/images/qiniu.png");
//        params.put("bgUrl", "http://test.oss.psoho.cn/upload/20200503/d94f2ba5ef1e4e3593b1a3f77abef3b5.jpg");
//        params.put("bgUrl", "http://test.oss.psoho.cn/upload/20200503/2911771858a94976b38f40d47eddfabe.jpg");
//        params.put("bgUrl", "http://test.oss.psoho.cn/upload/20200504/0294ff55718e4c63a67ded6117e60248.jpg");
        params.put("bgUrl", "http://equipment1.oss-cn-shenzhen.aliyuncs.com/20200519/34cbe14253d347b9b4732cfe25d620ec.jpg");
        params.put("bgUrl", "http://equipment1.oss-cn-shenzhen.aliyuncs.com/20200519/65c1747b4b274e30951d64735142e135.jpg");
        params.put("bgUrl", "http://equipment1.oss-cn-shenzhen.aliyuncs.com/20200519/6fdff97b08a947cf87605fcbc3cd09ad.jpg");
//        params.put("codeNo", "4300002020051911450003");
        params.put("codeNo", "中文测试");
        String posterId = "1";
        String url = posterClient.getUrl(posterId, params);
        System.out.println("url=" + url);
        if (url != null) {
            posterClient.saveToPath(url, "temp.png");
        }

    }

}
