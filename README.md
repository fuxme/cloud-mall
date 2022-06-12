
# 技术选型
### 中间件
功能 | 组件 | 替代方案
--- | --- | ---
注册中心 | naocs | eureka、consul、zookeeper
配置中心 | nacos | apollo、Spring Cloud Config
熔断 | sentinel |Resilience4j
熔断监控 | sentinel | dashboard
网关 | Spring Cloud Gateway |
链路追踪 | Spring Cloud Sleuth+zipkin | SkyWalking
监控 | Prometheus、Grafana |
日志 | Loki |
虚拟化 | k8s/k3s |
CI/CD | drone |
版本控制 | gitea | 
数据库 | Sqlite/MySQL | 
对象存储 | Minio/S3 | 


### 开发框架

功能 | 组件 | 替代方案
--- | --- | ---
服务调用 | feign | dubbo、resttempate
负载均衡 | Spring Cloud Loadbalancer |
网关 | Spring Cloud Gateway |
前端 | Vue + Element |

# 分包
- app：应用服务
  - app-account：用户服务
  - app-product：商品服务
  - app-trade：交易服务
- infra：基础库封装，拿来即用
  - dependencies：依赖管理
  - starter-db：ORM 封装
  - starter-web：web 封装
    - 全局异常处理
    - 自定义校验注解
    - 跨域拦截
  - starter-cache：缓存封装
  - starter-mq：MQ 封装
  - starter-protect：高可用工具封装
  - starter-observe：可观测性封装
  - starter-app：应用服务封装，每新增一个服务时，将此包作为父包即拥有了作为一个微服务该有的基本功能
- ops：运维
- ui：前端页面


# 业务模块划分
功能 | 名称 | 描述
--- | --- | ---
后台管理 | admin |
平台服务 | platform | 用户、权限、菜单、配置等基础功能
商品 | product |
交易 | trade | 


