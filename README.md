
# Fast海报API

### 一个生成动态海报的神器

### 

#### 特性
 * 快 
    * 开发快，编辑好海报后，直接生成调用代码
    * 生成海报快，
 * 稳
    * 底层的绘图


### 简介

[Fast海报API使用文档](docs/Fast海报API使用文档.md)

[编辑器地址](http://p0.prodapi.cn/#/)

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

 
## 备注

项目上线有小半年了，已在多个生产环境使用，最近才有时间开源出来，大家可以放心使用，希望能减少大家编写海报相关业务的工作。有什么好的想法，欢迎大家和我联系



 