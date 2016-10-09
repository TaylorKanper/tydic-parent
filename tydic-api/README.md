# tydic-api

## 说明
本工程主要书写一些对外暴露的接口和实体，方便后期进行第三方调用，例如：阿里的dubbo，网上也有其他的开源框架供RPC调用，其他工程只需要依赖本工程的jar包即可

 - model层书写在本项目，可以采用lombok简化实体的书写，让代码更加简洁
 - 对外暴露的api如果能够抽象，最好将共同的业务逻辑进行抽象，例如分页
 
## lombok
详情参见<a href="https://projectlombok.org">https://projectlombok.org</a>,需要把jar下载下来，在java环境下，将lombok安装到Eclipse中，其他的关于注解的说明可以参考lombok官网，注意项目需要依赖lombok的相关jar

##　接口的说明
对数据库的增删改，写在write包下，对数据库的查询写在read包下进行区分，这也给后面进行数据库的操作日志提供了aop支持，同时也方便程序员进行查看