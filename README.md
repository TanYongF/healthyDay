
# 基于Restful的健康积分管理系统


## 0. 使用指南(适合Windows、Linux)

### 1. Docker方式（推荐 >...<）
1. 安装Mysql、Redis

2. 创建数据库，执行ddl.sql文件生成数据库

3. 复制 `application-demo.yml`， 修改其中mysql连接配置和Redis配置后上传至服务器任意目录下

4. 在`applicationf-demo.yml`目录下执行命令：

   ```shell
   # 如下列命令测试可以正常运行，那么在后面加上参数 -d 即可后台运行
   docker run --name healthy --network host registry.cn-shanghai.aliyuncs.com/sleepytans/webapp:1.0 
   ```

5. 访问 `http://ip:8093`即可访问网站

### 2.直接运行(IDEA)
   导入项目然后，
   1. 根目录下的`pom.xml`来构建maven项目
   2. 配置项目目录下的 `application-demo.yml`文件中的redis和mysql数据库地址
   3. 执行`src/CourseDesignApplication.java`中的主方法



互联网平台积分体系是一个独立、完整的系统模块，主要用于激励和回馈用户在平台的消费行为和活动行为，通过积分体系可以激发与引导用户在平台的活跃行为，逐步形成用户对平台的依赖性和习惯性，提升用户对平台的黏度和使用率。

本项目已经完成部署，部署环境是`Centos`，JDK版本要求`1.8+`。

- 本设计文档由`Markdown`格式撰写，通过[Markdown快速学习](https://www.runoob.com/markdown/md-tutorial.html)速成
- 本项目由`Git`工具协同管理，可以通过[Git速成](https://www.runoob.com/git/git-basic-operations.html)学习
- 本项目成员包括 ： 张雨桐、仲储林、[谭永锋](https://tans.fun)
- **项目地址** ： [积分系统项目地址](http://win.pmease.cn/projects/coursedesign-B19040229)
- **部署网站**： https://points.tans.fun
- 项目难点与解决思路：[南邮课程设计积分系统](https://tans.fun/archives/%E7%AD%96%E7%95%A5%E6%A8%A1%E5%BC%8F%E5%9C%A8%E7%A7%AF%E5%88%86%E7%B3%BB%E7%BB%9F%E4%B8%AD%E7%9A%84%E5%BA%94%E7%94%A8)

## 一、需求分析

需要明确对于哪些积分项目是我们需要实现，并且可以考虑其他的扩展积分项目。

### 0. 基础功能

系统基本功能。

| 功能             | 说明                                                         | 完成情况 | 测试情况  |
| ---------------- | ------------------------------------------------------------ | -------- | --------- |
| 登陆登出功能     | 用户基本登陆功能                                             | 已完成 ✔️ | 测试通过✔️ |
| 注册功能         | 用户基本注册功能                                             | 已完成 ✔️ | 测试通过✔️ |
| 个人界面展示     | 用户个人信息、积分、并发症等信息展示                         | 已完成 ✔️ | 测试通过✔️ |
| 个人积分记录展示 | 个人积分记录展示                                             | 已完成 ✔️ | 测试通过✔️ |
| 健康界面         | 胰岛素血糖等含量图表展示、当日胰岛含量、血糖含量、健康评级等 | 已完成 ✔️ | 测试通过✔️ |
| 活动界面         | 用户可以参加的扩展活动在这里展示                             | 已完成 ✔️ | 测试通过✔️ |
| 系统首页         | 有关此系统的文档等                                           |          |           |

### 1.用户成长积分

用户成长积分主要通过登陆平台、填写个人资料、记录血糖、填写并发症记录等方式获取。通过这些关键行为，一方面增加了用户使用产品的时长，提升了用户的留存率；另一方面长时间停留的用户也为平台转化提供了机会，从而实现最终的变现。

本系统可以实现的成长积分项目如下。

| 积分项目 | 分值 |      约束      | 完成情况 | 测试情况 |
| -------- | ---- | --------------- | -------- | -------- |
| 登陆平台 |  1   | 每日首次 | 已完成 ✔️ | 测试通过✔️ |
| 填写血糖 | 1 | 一月三次 | 已完成 ✔️ | 测试通过✔️ |
| 填写胰岛素含量 | 2 | 一月一次 | 已完成 ✔️ | 测试通过✔️ |
| 完善用户信息 | 3 | 一年一次 | 已完成 ✔️ | 测试通过✔️ |
| 填写并发症信息 | 2 | 一月一次 | 已完成 ✔️ | 测试通过✔️ |
| 用户健康报表（评估报告） | 0 | 无限制 | 已完成✔️ | 测试通过✔️ |

### 2.用户可兑换积分

有多种兑换积分的方式可供用户选择：完成门诊随访、参加扩展活动和参加科研招募等。这些兑换方式对于用户来说，这不仅促使他们积极每日签到，而且调动用户的积极性。这样一来，用户活跃度不断提高，而店铺与用户之间的联系也更加稳固、紧密。加上店铺的其它营销活动及推广技巧的开展与辅助，店铺转化率持续上升，盈利也将也不断增长。

本系统可以实现的兑换积分功能项目如下。

|   积分项目   | 分值 |  约束  | 完成情况 | 测试情况 |
| ----------- | ---- | ------ | ----------- | ----------- |
| 完成门诊随访 |  3   | 无限制 | 已完成✔️ | 测试通过✔️ |
| 参加扩展活动  | 5   |  无限制  | 已完成✔️ | 测试通过✔️ |
| 参加科研招募  | 8   |  无限制  | 已完成✔️ | 测试通过✔️ |

## 二、项目设计

此项目主要是针对用户健康积分设计的健康系统（最大程度实现了前后端分离，但是部分页面还是由后端渲染），在解决基本功能的同时，也做了以下优化：

- 使用`Redis`等中间件来实现**分布式`Session`**、**静态页面缓存**、**对象缓存**等性能优化。
- 实现前后端分离，前端通过`Ajax`来进行异步请求接口来请求数据并进行渲染。
- 前端请求密码和后端密码存库都有MD5加盐加密过程，全程保护用户信息安全。
- 前端增加大量图表和卡片增加**数据可视化**，优化用户体验。

### 2.1 项目技术栈

**前端部分**：HTML、CSS、JQuery、Materialize组件库

**语言部分**：Java、JavaScript、HTML等

**框架部分**：SpringBoot、SpringMVC、Mybatis等

**数据库部分**：Mysql

**中间件**：Redis缓存

**项目协同**：Git

**API接口文档**：APIFox

### 2.2 表设计


本节主要是描述对数据库表的设计，以及对应相关实体（以`Mysql`为准）。

参考教程：

1. [Mysql数据类型](https://www.runoob.com/mysql/mysql-data-types.html)
1. [JDBC数据对应关系](https://blog.csdn.net/GongchuangSu/article/details/51956567)

部分要点:

1. 积分获取时间失效时间统一使用`DateTime`类型
2. 由于此项目用户名为手机号，Id一律使用`Bigint`格式并且长度为11位
3. 尽量不使用外键约束，否则会存在联表操作增加耦合性增加后期系统的维护难度。
4. 合理使用索引，同一表中不应加过多索引。对于数据汇总功能，不要导出冗余信息。

#### 2.2.1用户表

此表格用于存储用户基本信息

| 字段名称        | 字段数据类型 | 字段注释            | 备注                              |
| --------------- | ------------ | ------------------- | --------------------------------- |
| id              | bigint       | 用户ID              | 主键 （本项目主要代表用户手机号） |
| nickname        | varchar(20)  | 用户昵称            |                                   |
| gender          | byte         | 性别                | 0 ： female 1 ：male              |
| password        | varchar(255) | 经过md5加密后的密码 | 注意使用用户salt进行md5加密       |
| head            | varchar(255) | 头像链接            | OSS地址                           |
| register_date   | Date         | 注册日期            |                                   |
| lastLoginf_date | Date         | 最近一次登陆时间    |                                   |
| email           | varchar(255) | 用户邮箱地址        |                                   |
| info            | varchar(255) | 用户个人信息        |                                   |
| complication    | varchar(255) | 用户并发症记录      | 注意积分联系                      |

#### 2.2.2 血糖记录表 `blood_sugar_record`

此表格用于统计**用户的并发症**

| 字段名称    | 字段数据类型 | 字段注释     | 是否索引    | 备注 |
| ----------- | ------------ | ------------ | ----------- | ---- |
| id          | bigint       | 自增ID       | primary key |      |
| user_id     | bigint       | 用户手机号   | unique key  |      |
| value       | decimal      | 用户血糖记录 |             |      |
| record_time | datetime     | 填写时间     |             |      |
#### 2.2.3 胰岛素记录表 `insulin_record`

此表格用于统计用户的**血糖情况**

| 字段名称    | 字段数据类型 | 字段注释     | 是否索引    | 备注 |
| ----------- | ------------ | ------------ | ----------- | ---- |
| id          | bigint       | 自增ID       | primary key |      |
| user_id     | bigint       | 用户手机号   |             |      |
| value       | decimal      | 用户血糖记录 |             |      |
| record_time | datetime     | 填写时间     |             |      |

#### 2.2.4  积分日志表 `credit_transaction`

此表格用于记录用户的积分获取信息

| 字段名称     | 字段数据类型 | 字段注释     | 是否索引    | 备注                |
| ------------ | ------------ | ------------ | ----------- | ------------------- |
| id           | bigint       | 自增id       | primary key | 主键                |
| user_id      | bigint       | 用户手机号   |             | 外键，与user表关联  |
| event_id     | bigint       | 事件ID       |             | 外键，与event表关联 |
| create_time  | date         | 积分创建时间 |             |                     |
| expired_time | date         | 积分销毁事件 |             | 主要针对可兑换积分  |
#### 2.2.5 拓展活动表 activity
可兑换积分中的**拓展活动**表，后台可以动态添加活动，并且可以自定义活动积分等

| 序号 | 名称 | 描述 | 类型 | 键 |
| :--: | :--: | :--: | :--: | :--: |
| 1 | `id` | 主键 | bigint unsigned | PRI |
| 2 | `info` | 活动简介 | varchar(255) |  |
| 3 | `dead_date` | 活动时间 | date |  |
| 4 | `event_id` | 触发事件积分 | bigint |  |
| 5 | `organiser` | 举办企业 | varchar(100) |  |
| 6 | `address` | 活动地址 | varchar(100) |  |
| 7 | `page_photo` | 主题图片 | varchar(200) |  |

#### 2.2.8 事件表

| 序号 | 名称 | 描述 | 类型 | 键 | 为空 | 额外 | 默认值 |
| :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: |
| 1 | `id` | 主键 | bigint | PRI | NO | | |
| 2 | `info` | 事件说明 | varchar(100) | | NO | | |
| 3 | `type` | 积分类型 0:成长积分 1：可兑换积分 | bit(1) | | NO | | 0 |
| 4 | `points` | 积分值 | int | | NO | | 0 |
| 5 | `max_frequency_per_day` | 积分每日限制，为0即不限制 | int | | NO | | 0 |
| 6 | `max_frequency_per_month` | 积分每月限制，为0即不限制 | int | | NO | | 0 |
| 7 | `max_frequency_per_year` | 积分每年限制，为0即不限制 | int | | NO | | 0 |
| 8 | `effective_day` | 生效时长，单位：day | int | | NO | | 0 |

## 三、接口文档

此项目使用ApiFox来进行接口文档进行测试并管理。

**积分系统项目在线文档地址** ： [在线接口文档](https://www.apifox.cn/apidoc/shared-33be4a68-d17c-41b1-b26a-80c3ff7c6a45/api-20111667)

## 四、其他资料

1. [策略模式](https://blog.csdn.net/u010185805/article/details/116998482)
1. [前端构建图例](https://www.processon.com/view/link/6279170d1efad40df02ee683)
1. [Echarts学习](https://echarts.apache.org/zh/index.html)
1. [Materializecss学习](http://archives.materializecss.com/0.100.2/grid.html)
1. [JQuery学习](https://www.runoob.com/jquery/jquery-tutorial.html)
1. [投票项目（参考）](https://github.com/TanYongF/SimpleVotingSystem)