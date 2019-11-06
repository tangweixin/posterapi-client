package com.thomas.demo;

import com.thomas.posterapi.PosterClient;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author thomas
 * @date 2019-08-09
 */
public class PosterClientDemo {

    public static void main(String[] args) throws IOException {

        String accessKey = "27a171c8e02b4888832095efab1ec761";
        String posterId = "10008";
        PosterClient client = PosterClient.newBulder(accessKey, posterId)
                .add("title", "NO. 10009")
                .add("img", "http://pic.qn.prodapi.cn/typora/hexo/thomas/b36oc.jpg")
                .add("qrcodeUrl", "http://p0.prodapi.cn/#/")
                .build();

        // 获取海报下载地址
        String url = client.get();
        System.out.println(url);

        // 下载海报
        byte[] data = client.down();
        FileUtils.writeByteArrayToFile(new File("a.jpg"), data);

    }

}
