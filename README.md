<p align="center">
  <a href="https://github.com/alibaba/Chat2DB">
    <img width="100" src="document/logo.ico">
  </a>
</p>
<h1 align="center">Chat2DB</h1>

<div align="center">

一个集成了AIGC的数据库客户端工具

[![License](https://img.shields.io/github/license/alibaba/fastjson2?color=4D7A97&logo=apache)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Java support](https://img.shields.io/badge/Java-17+-green?logo=java&logoColor=white)](https://openjdk.java.net/)
[![GitHub release](https://img.shields.io/github/release/alibaba/ali-dbhub)](https://github.com/alibaba/ali-dbhub/releases)
[![GitHub Stars](https://img.shields.io/github/stars/alibaba/ali-dbhub)](https://github.com/alibaba/ali-dbhub/stargazers)
[![GitHub Forks](https://img.shields.io/github/forks/alibaba/ali-dbhub)](https://github.com/alibaba/ali-dbhub/fork)
[![GitHub Contributors](https://img.shields.io/github/contributors/alibaba/ali-dbhub)](https://github.com/alibaba/ali-dbhub/graphs/contributors)

语言： 中文 | [English](README_EN.md)
</div>

## 📖 简介
&emsp; &emsp;Chat2DB 是一款有开源免费的多数据库客户端工具，支持windows、mac本地安装，也支持服务器端部署，web网页访问。和传统的数据库客户端软件Navicat、DBeaver 相比Chat2DB集成了AIGC的能力，能够将自然语言转换为SQL，也可以将SQL转换为自然语言，可以给出研发人员SQL的优化建议，极大的提升人员的效率，是AI时代数据库研发人员的利器，未来即使不懂SQL的运营业务也可以使用快速查询业务数据、生成报表能力。
## ✨ 特性
- 🌈 AI智能助手，支持自然语言转SQL、SQL转自然语言、SQL优化建议
- 👭 支持团队协作，研发无需知道线上数据库密码，解决企业数据库账号安全问题
- ⚙️ 强大的数据管理能力，支持数据表、视图、存储过程、函数、触发器、索引、序列、用户、角色、授权等管理
- 🔌 强大的扩展能力，目前已经支持MySQL、PostgreSQL、Oracle、SQLServer、ClickHouse、OceanBase、H2、SQLite等等，未来会支持更多的数据库
- 🛡 前端使用 Electron 开发，提供 Windows、Mac、Linux 客户端、网页版本一体化的解决方案
- 🎁 支持环境隔离、线上、日常数据权限分离

## ⏬ 下载安装
| 描述                   | 下载地址                                                                                                                                                                                                                                       |
|-----------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Windows               | [https://oss-chat2db.alibaba.com/release/1.0.5/Chat2DB%20Setup%201.0.5.exe](https://oss-chat2db.alibaba.com/release/1.0.5/Chat2DB%20Setup%201.0.5.exe) |
| MacOS ARM64 (Apple芯片) | [https://oss-chat2db.alibaba.com/release/1.0.5/Chat2DB-1.0.5-arm64.dmg](https://oss-chat2db.alibaba.com/release/1.0.5/Chat2DB-1.0.5-arm64.dmg) |
| MacOS X64 (Intel芯片)   | [https://oss-chat2db.alibaba.com/release/1.0.5/Chat2DB-1.0.5.dmg](https://oss-chat2db.alibaba.com/release/1.0.5/Chat2DB-1.0.5.dmg) |       
| Jar包                  | [https://oss-chat2db.alibaba.com/release/1.0.5/ali-dbhub-server-start.jar](https://oss-chat2db.alibaba.com/release/1.0.5/ali-dbhub-server-start.jar) |                                                                                                                

## 🌰 使用Demo
- 创建数据源
<a><img src="https://gw.alicdn.com/imgextra/i3/O1CN01PlpLYy1hIq5aMugpg_!!6000000004255-0-tps-3446-1750.jpg" width="100%"/></a>
- 数据源管理
<a><img src="https://gw.alicdn.com/imgextra/i2/O1CN01DpzZJL1T7w2Xv9VMl_!!6000000002336-0-tps-3410-1662.jpg" width="100%"/></a>
- SQL控制台
<a><img src="https://gw.alicdn.com/imgextra/i2/O1CN01aidnkx1Oo0LJ1Pdty_!!6000000001751-0-tps-3440-1736.jpg" width="100%"/></a>
- AI智能助手
<a><img src="https://gw.alicdn.com/imgextra/i4/O1CN01iaSXot1W6VeaDFbK2_!!6000000002739-0-tps-3430-1740.jpg" width="100%"/></a>


## 📦 Docker部署

```bash
  docker pull chat2db/chat2db:latest
  // 前台运行,运行后不能关闭命令行
  docker run -ti --name=chat2db -p 10824:10824 chat2db/chat2db:latest
  // 后台运行,运行后可以关闭命令行
  docker run --name=chat2db -p 10824:10824 chat2db/chat2db:latest
  // 这里正常会提示 Tomcat started on port(s): 10824 (http) with context path 就可以结束了
  
  // 如果这里提示  The container name "/chat2db" is already in use by container, 代表已经存在容器了 运行
  docker run chat2db
  // 如果想更新chat2db 则需要先rm 再运行
  docker rm chat2db
```
## 🎯 运行环境
注意：
如果需要本地调试
- java运行 <a href="https://adoptopenjdk.net/" target="_blank">Open JDK 17</a>
- Node运行环境Node16 <a href="https://nodejs.org/" target="_blank">Node.js</a>.
## 💻 本地调试
- git clone到本地
```bash
$ git clone git@github.com:alibaba/Chat2DB.git
```
- 前端安装
```bash
$ cd Chat2DB/ali-dbhub-client
$ npm install # 安装npm 
$ npm run build:prod # 把js打包生成到后端的source目录
```
- 后端调试
```bash
$ cd ../ali-dbhub-server
$ mvn clean install # 需要安装maven 3.8以上版本
$ cd ali-dbhub-server/ali-dbhub-server-start/target/
$ java -jar -Dchatgpt.apiKey=xxxxx ali-dbhub-server-start.jar  # 启动应用 chatgpt.apiKey 需要输入ChatGPT的key,如果不输入无法使用AIGC功能
$ # 打开 http://localhost:7001 开启调试
```

- 前端调试
```bash
$ cd Chat2DB/ali-dbhub-client
$ npm install 
$ npm run start
$ # 打开 http://localhost:8001 开启前端调试
```
但是前端调试需要映射下资源，可以下载[XSwitch](https://chrome.google.com/webstore/detail/idkjhjggpffolpidfkikidcokdkdaogg),添加以下配置文件
``` json
{
  "proxy": [
    [
      "http://127.0.0.1:7001/static/front/(.*)",
      "http://127.0.0.1:8001/$1",
    ],
    [
      "http://127.0.0.1:7001/(.*).js$",
      "http://127.0.0.1:8001/$1.js",
    ],
    [
      "http://127.0.0.1:7001/(.*).css$",
      "http://127.0.0.1:8001/$1.css",
    ]
  ],
}
```



## 📑 文档

* <a href="https://github.com/alibaba/ali-dbhub/wiki">WIKI</a>
* <a href="https://github.com/alibaba/ali-dbhub/issues">Issue tracker</a>

## ☎️ 联系我们

如果觉得对你有帮助请点个star吧。

<a><img src="https://gw.alicdn.com/imgextra/i1/O1CN01VBaYST1MFzhUY9QP6_!!6000000001406-0-tps-723-731.jpg" width="40%"/></a>

微信：yxccw132  钉钉：9135032392

## ❤️ 致谢
感谢所有为Chat2DB贡献力量的同学们~

<a href="https://github.com/alibaba/ali-dbhub/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=alibaba/Chat2DB" />
</a>


