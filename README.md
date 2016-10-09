# Maven
maven构建项目，其中tydic-parent起一个容器的作用
## 准备
1. 首先下载JDK和MAVEN包，配置环境变量，详请参见网上
2. Eclipse中添加 m2m MAVEN插件，添加 EGIT 版本控制插件
3. Jetty和JRebel选择性安装

## 开始
1. 创建parent项目，这个只是管理子项目的工程，把内容删除，package打包方式选择pom
2. 创建util/api/persist/service/web,依赖顺序创建顺序一致

## 项目说明

 - util 里面主要封装一些工具类，其他所有项目均可调用
 - api 里面主要是实体类，也可以放一些对外声明的接口，用于RPC调用，其中本项目的model用了mybatis注解，通过在mybatis.cfg.xml中映射了包，包下的所有alias类别名注解将被扫描
 - persist 里面主要是数据库简单的操作封装，不用写实现， 仅有声明，但是，它其中的方法名，必须和映射文件中的id值保持一致
 - service 里面主要是接口实现，本项目中的接口声明也写在该层，其实是不好的，应该将声明放在model层比较好，service尽量抽象， 将业务逻辑清晰展现
 - web 里面主要是控制器，和视图控制

## MAVEN的说明

 - maven的父项目的所有依赖，子项目将会继承，如果某些项目不想继承，可以采用exclude操作排除
 - maven的一些插件需要添加，否则打包将会报错，compiler容器JDK版本surefire执行test的排除操作
 - 添加maven的其他插件，例如jetty可以直接在maven goal中使用jetty：run运行web