package cn.prodapi.api;

import org.apache.commons.io.FilenameUtils;

import java.util.HashMap;
import java.util.Map;

public class PosterClientDemo {

    public static void main(String[] args) {

//        PosterClient posterClient = new PosterClient("http://127.0.0.1:9001/", "t8xAmqoXQliBhMsV");
        PosterClient posterClient = new PosterClient("http://poster.prodapi.cn/", "t8xAmqoXQliBhMsV");

        Map<String, String> params = new HashMap<>();
        params.put("头像", "http://demo.qn.prodapi.cn/images/qiniu.png");
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
