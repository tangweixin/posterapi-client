# Fast海报API 

## 简介

[Fast海报API编辑器使用文档](docs/Fast海报API编辑器使用文档.md)

![海报编辑器界面](http://pic.qn.prodapi.cn/typora/hexo/thomas/5sf8x.jpg)


## 客户端调用示例代码

```java
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
```
