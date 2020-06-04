package cn.prodapi.poster;
import java.util.HashMap;

public class Test2 {

    public static void main(String[] args) {

        // 创建海报客户端对象
//        PosterClient posterClient = new PosterClient("https://poster.prodapi.cn/", "2NAPIFheaXyL4d2r", "J5GlMp9mzqkTgAiu");
        PosterClient posterClient = new PosterClient("http://127.0.0.1:9001", "2NAPIFheaXyL4d2r", "J5GlMp9mzqkTgAiu");

        // 构造海报参数
        HashMap<String, String> params = new HashMap<>();
        params.put("文本1", "在世间自有山比此山更高。");
        params.put("文本2", "在我心世间始终你好");

        // 海报ID
        String posterId = "13";

        // 获取下载地址
        String url = posterClient.getUrl(posterId, params);
        System.out.println("url=" + url);

        // 保存到本地
        posterClient.saveToPath(url, "temp.png");

    }

}