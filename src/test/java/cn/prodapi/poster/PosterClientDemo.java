package cn.prodapi.poster;

import java.util.HashMap;

public class PosterClientDemo {

    public static void main(String[] args) {

        // 创建海报客户端对象
//        PosterClient posterClient = new PosterClient("https://poster.prodapi.cn/", "2NAPIFheaXyL4d2r", "J5GlMp9mzqkTgAiu");
        PosterClient posterClient = new PosterClient("http://127.0.0.1:9001", "KWmJm7nLTCexrHx0", "jOxt7B5R26jZ3l3yw3pS");

        //
        HashMap<String, String> params = new HashMap<>();
        params.put("qrcode", "http://demo.qn.prodapi.cn/images/qiniu.png");
        params.put("codeNo", "4300002020052022640018");
        params.put("logo", "/storage/upload/d37e42880dabaf44.png");

        // 海报ID
        String posterId = "1";

        // 获取下载地址
        String url = posterClient.getUrl(posterId, params);
        System.out.println("url=" + url);

        // 保存到本地
        posterClient.saveToPath(url, "temp.png");

    }

}
