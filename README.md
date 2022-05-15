# 积分管理系统

互联网平台积分体系是一个独立、完整的系统模块，主要用于激励和回馈用户在平台的消费行为和活动行为，通过积分体系可以激发与引导用户在平台的活跃行为，逐步形成用户对平台的依赖性和习惯性，提升用户对平台的黏度和使用率。

- 本设计文档由`Markdown`格式撰写，通过[Markdown快速学习](https://www.runoob.com/markdown/md-tutorial.html)速成

- 本项目由`Git`工具协同管理，可以通过[Git速成](https://www.runoob.com/git/git-basic-operations.html)学习
- 本项目成员包括 ： 张雨桐、王雪臣、[谭永锋](https://tans.fun)
- **项目地址** ： [积分系统项目地址](http://win.pmease.cn/projects/coursedesign-B19040229)
- 接口文档：[积分系统接口文档](https://www.apifox.cn/apidoc/shared-33be4a68-d17c-41b1-b26a-80c3ff7c6a45/api-20111667)
## 一、需求分析

需要明确对于哪些积分项目是我们需要实现，并且可以考虑其他的扩展积分项目。

### 1.用户成长积分

用户成长积分主要通过登陆平台、填写个人资料、记录血糖、填写并发症记录等方式获取。通过这些关键行为，一方面增加了用户使用产品的时长，提升了用户的留存率；另一方面长时间停留的用户也为平台转化提供了机会，从而实现最终的变现。

本系统可以实现的成长积分项目如下。

| 积分项目 | 分值 |      约束       |
| -------- | ---- | --------------- |
| 登陆平台 |  1   | 每日首次登陆获得 |
| 填写血糖 | 1 | 一月三次 |
| 填写胰岛素含量 | 2 | 一月一次 |

### 2.用户可兑换积分

有多种兑换积分的方式可供用户选择：完成门诊随访、参加扩展活动和参加科研招募等。这些兑换方式对于用户来说，这不仅促使他们积极每日签到，而且调动用户的积极性。这样一来，用户活跃度不断提高，而店铺与用户之间的联系也更加稳固、紧密。加上店铺的其它营销活动及推广技巧的开展与辅助，店铺转化率持续上升，盈利也将也不断增长。

本系统可以实现的兑换积分功能项目如下。

|   积分项目   | 分值 |  约束  |
| ----------- | ---- | ------ |
| 完成门诊随访 |  3   | 无限制 |
| 参加扩展活动  | 5   |  无限制  |
| 参加科研招募  | 8   |  无限制  |

## 二、项目设计

### 2.1 项目技术栈

**前端部分**：HTML、CSS、Jquery。总体使用materialize风格

**语言部分**：Java、JavaScript、HTML等

**框架部分**：SpringBoot、SpringMVC

**数据库部分**：Mysql

**中间件**：Redis

**项目协同**：Git

**API接口测试工具**：APIFox

### 2.2 表设计


本节主要是描述对数据库表的设计，以及对应相关实体（以`Mysql`为准）。

参考教程：

1. [Mysql数据类型](https://www.runoob.com/mysql/mysql-data-types.html)
1. [JDBC数据对应关系](https://blog.csdn.net/GongchuangSu/article/details/51956567)

几个要求:

1. 由于无时区差异，因此时间统一使用`DateTime`格式
2. 由于此项目用户名为手机号，Id一律使用`Bigint`格式
3. 严格不使用外键约束，否则会增加表的耦合性
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
| user_id     | bigint       | 用户手机号   | unique key  |      |
| value       | decimal      | 用户血糖记录 |             |      |
| record_time | datetime     | 填写时间     |             |      |
#### 2.2.4  登陆日志表 `login_record`

此表格用于记录用户的登录信息

| 字段名称   | 字段数据类型 | 字段注释   | 是否索引    | 备注 |
| ---------- | ------------ | ---------- | ----------- | ---- |
| id         | bigint       | 自增id     | primary key |      |
| user_id    | bigint       | 用户手机号 |             |      |
| login_time | date         | 登陆时间   |             |      |
| ip         | varchar      | 登陆IP     |             |      |
| device     | varchar      | 登陆设备   |             |      |
#### 2.2.5 活动表 `activity_record`

此表格用于统计用户的课外活动

| 字段名称 | 字段数据类型 | 字段注释   | 是否索引                 | 备注 |
| -------- | ------------ | ---------- | ------------------------ | ---- |
| id       | bigint       | 自增ID     | primary key              |      |
| user_id  | bigint       | 用户手机号 | 联合索引(user_id + date) |      |
| info     | varchar      | 活动简介   |                          |      |
| date     | date         | 时间       |                          |      |
| type     | int          | 活动类型   |                          |      |
#### 2.2.6 科研招募表

此表格用于统计科研招募信息

| 字段名称 | 字段数据类型 | 字段注释 | 是否索引 | 备注 |
| -------- | ------------ | -------- | -------- | ---- |
|          |              |          |          |      |
|          |              |          |          |      |
|          |              |          |          |      |
|          |              |          |          |      |
|          |              |          |          |      |
#### 2.2.7 门诊随访表

此表格用于统计门诊随访信息

| 字段名称 | 字段数据类型 | 字段注释 | 是否索引 | 备注 |
| -------- | ------------ | -------- | -------- | ---- |
|          |              |          |          |      |
|          |              |          |          |      |
|          |              |          |          |      |
|          |              |          |          |      |
|          |              |          |          |      |

## 三、接口文档

此项目使用API fox来进行文档管理。

**积分系统项目在线文档地址** ： [在线接口文档](https://www.apifox.cn/apidoc/shared-33be4a68-d17c-41b1-b26a-80c3ff7c6a45/api-20111667)

## 四、其他资料

1. [策略模式](https://blog.csdn.net/u010185805/article/details/116998482)
1. [前端构建图例](https://www.processon.com/view/link/6279170d1efad40df02ee683)
1. [Echarts学习](![img](file:///C:\Users\tan13\AppData\Roaming\Tencent\QQTempSys\[5UQ[BL(6~BS2JV6W}N6[%S.png)https://echarts.apache.org/zh/index.html)
1. [Materializecss学习](http://archives.materializecss.com/0.100.2/grid.html)
1. [Jqery学习](https://www.runoob.com/jquery/jquery-tutorial.html)
1. [投票项目（参考）](https://github.com/TanYongF/SimpleVotingSystem)
