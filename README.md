### Web系统框架课程设计
***
#### 实验室预约系统后端设计
允许教师灵活预约课程实验时间的实验室预约系统

**角色**

实验室管理员
实验室管理，添加实验室，实验室编号，机器数量，描述(机器配置等)
教师管理，教师信息的CURD

教师
课程实验管理，添加课程名称，学生数量，学时数
实验室预约

**完成情况**

主要基于springboot 2.3.7框架实现， mybatis-plus框架实现数据的CRUD。
用户密码采用bcrypt非对称加密算法加密保存。
基于Spring Testing实现单元/集成测试，基于IDEA测试脚本实现HTTP请求测试。实现业务管理，网关2个微服务，使用了cache缓存，2个微服务注册在nacos。
其中网关服务主要是进行一个转发，将网关收到的请求转发到具体业务处理的服务中。

将后端服务部署在阿里云上，配置了openjdk11/MySQL8，两个微服务通过docker-compose
编排管理在同一桥接网络实现互交，通过配置容器环境变量实现开发/生产环境的隔离。2个微服务
注册在独立的nacos docker容器。

启动服务之前先启动nacos，还可以本地访问swagger文档，基于swagger文档进行测试
