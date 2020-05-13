package cn.prodapi.api;

import org.apache.commons.io.FilenameUtils;

import java.util.HashMap;
import java.util.Map;

public class PosterClientDemo {

    public static void main(String[] args) {

//        PosterClient posterClient = new PosterClient("http://127.0.0.1:9001/", "t8xAmqoXQliBhMsV");
        PosterClient posterClient = new PosterClient("http://127.0.0.1:9001/", "ADD2F37C19FAD36D73D225AA9E6C2968");
//        PosterClient posterClient = new PosterClient("https://poster.prodapi.cn/", "t8xAmqoXQliBhMsV");

//        Map<String, String> params = new HashMap<>();
//        params.put("头像", "http://demo.qn.prodapi.cn/images/qiniu.png");
//        params.put("说明文字", "功能还不够完善，需要多多改进");
//        params.put("图片1", "/storage/upload/c00416a0985212.png");
//        String posterId = "1";
//        String url = posterClient.getUrl(posterId, params);
//        System.out.println("url=" + url);
//        if (url != null) {
//            posterClient.saveToPath(url, "temp." + FilenameUtils.getExtension(url));
//        }


        Map<String, String> params = new HashMap<>();
//        params.put("qrcode", "http://demo.qn.prodapi.cn/images/qiniu.png");
//        params.put("bgUrl", "http://demo.qn.prodapi.cn/images/qiniu.png");
//        params.put("bgUrl", "http://test.oss.psoho.cn/upload/20200503/d94f2ba5ef1e4e3593b1a3f77abef3b5.jpg");
//        params.put("bgUrl", "http://test.oss.psoho.cn/upload/20200503/2911771858a94976b38f40d47eddfabe.jpg");
//        params.put("bgUrl", "http://test.oss.psoho.cn/upload/20200504/0294ff55718e4c63a67ded6117e60248.jpg");
        params.put("说明文字", "功能还不够完善，需要多多改进");
        params.put("图片1", "/storage/upload/c00416a0985212.png");
        String posterId = "1";
        String url = posterClient.getUrl(posterId, params);
        System.out.println("url=" + url);
        if (url != null) {
            posterClient.saveToPath(url, "temp." + FilenameUtils.getExtension(url));
        }

    }

}
