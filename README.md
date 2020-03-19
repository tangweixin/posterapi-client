
# prodapi海报设计器

快速开发海报、节省宝贵时间。

### 特性

 * 简单：组件丰富、支持拖拽、复制、预览、下载等功能。
 * 高效：编辑好海报后，能直接生成调用代码。
 * 便捷：只要参数名称不变，不必修改任何代码，直接在编辑器修改海报保存即可获得最新的海报效果

### 简介

在海报设计器设计好海报，即可生成调用代码，节省海报开发的时间。

如果后期海报需要调整，直接在设计器调整，保存海报即可，无需修改代码。

[点击进入编辑器](http://poster.prodapi.cn/index.html#/from_github)

![海报编辑器界面](http://pic.qn.prodapi.cn/typora/hexo/thomas/ibz1k.jpg)

### 客户端调用示例代码

```java
PosterClient posterClient = new PosterClient("http://poster.prodapi.cn/", "t8xAmqoXQliBhMsV");

Map<String, String> params = new HashMap<>();
params.put("头像", "http://demo.qn.prodapi.cn/images/qiniu.png");
params.put("说明文字", "世上无难事");
params.put("图片1", "/storage/upload/c00416a0985212.png");
String posterId = "1";
// 获取海报链接
String url = posterClient.getUrl(posterId, params);
System.out.println("url=" + url);
if (url != null) {
    // 保存海报
    posterClient.saveToPath(url, "temp." + FilenameUtils.getExtension(url));
}
```


生成的海报地址
[http://poster.prodapi.cn/view/8052e3790832d48affc2374ff68b6824.png](http://poster.prodapi.cn/view/8052e3790832d48affc2374ff68b6824.png)

![http://poster.prodapi.cn/view/8052e3790832d48affc2374ff68b6824.png](http://poster.prodapi.cn/view/8052e3790832d48affc2374ff68b6824.png)

### 类似项目






 