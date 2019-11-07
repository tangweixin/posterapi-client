
# Fast海报API

一个生成动态海报的神器

### 特性

 * 简单：组件丰富、支持拖拽、复制等操作。
 * 高效：编辑好海报后，能直接生成调用代码。
 * 方便：只要参数不变，不必修改代码，直接在编辑器修改海报即可获得最新的海报

### 简介

项目上线有小半年了，已在多个生产环境使用，最近才有时间整理出来，大家可以放心使用。希望能减少大家编写海报相关业务的工作。

[点击进入编辑器](http://p0.prodapi.cn/#/from_github)

![海报编辑器界面](http://pic.qn.prodapi.cn/typora/hexo/thomas/777ns.jpg)

### 客户端调用示例代码

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

[生成的海报地址](http://p0.prodapi.cn/api/img/16b29b051763eeb08dcc47a0f187be73.jpg)

![http://p0.prodapi.cn/api/img/16b29b051763eeb08dcc47a0f187be73.jpg](http://p0.prodapi.cn/api/img/16b29b051763eeb08dcc47a0f187be73.jpg)

### 类似项目





 