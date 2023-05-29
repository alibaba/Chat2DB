<p align="center">
  <a href="https://github.com/alibaba/Chat2DB">
    <img width="100" src="document/image/logo.ico">
  </a>
</p>
<h1 align="center">Chat2DB</h1>

<div align="center">

General-purpose database tools and SQL clients with AGI (ChatGPT)

[![MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/alibaba/ali-dbhub/blob/main/LICENSE)
[![GitHub release](https://img.shields.io/github/release/alibaba/ali-dbhub)](https://github.com/alibaba/ali-dbhub/releases)
[![GitHub Stars](https://img.shields.io/github/stars/alibaba/ali-dbhub)](https://github.com/alibaba/ali-dbhub/stargazers)
[![GitHub Forks](https://img.shields.io/github/forks/alibaba/ali-dbhub)](https://github.com/alibaba/ali-dbhub/fork)
[![GitHub Contributors](https://img.shields.io/github/contributors/alibaba/ali-dbhub)](https://github.com/alibaba/ali-dbhub/graphs/contributors)

Languages： English | [中文](README.md)
</div>

## 📖 Introduction
&emsp; &emsp;Chat2DB is a multi-database client tool that is open-source and free from Alibaba. It supports local installation on Windows and Mac, as well as server-side deployment and web page access. Compared to traditional database client software such as Navicat and DBeaver, Chat2DB integrates AIGC's capabilities and is able to convert natural language into SQL. It can also convert SQL into natural language and provide optimization suggestions for SQL to greatly enhance the efficiency of developers. It is a tool for database developers in the AI era, and even non-SQL business operators in the future can use it to quickly query business data and generate reports.
## ✨ Features
- 🌈 AI intelligent assistant, supporting natural language to SQL conversion, SQL to natural language conversion, and SQL optimization suggestions
- 👭 Support team collaboration, developers do not need to know the online database password, solving the problem of enterprise database account security
- ⚙️ Powerful data management capability, supporting management of data tables, views, stored procedures, functions, triggers, indexes, sequences, users, roles, authorizations, etc.
- 🔌 Powerful extension capability, currently supporting MySQL, PostgreSQL, Oracle, SQLServer, ClickHouse, OceanBase, H2, SQLite, etc., and more databases will be supported in the future
- 🛡 Front-end development using Electron, providing a solution that integrates Windows, Mac, Linux clients, and web versions
- 🎁 Support environment isolation, online, and daily data permission separation


## ⏬ Download and Install

| Description   | Size                                                                                                                                                   | Download                                                                                                                                                                                                                                        |
|---------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| 
| Windows       | [https://oss-chat2db.alibaba.com/release/1.0.5/Chat2DB%20Setup%201.0.5.exe](https://oss-chat2db.alibaba.com/release/1.0.3/Chat2DB%20Setup%201.0.3.exe) |
| MacOS ARM64   | [https://oss-chat2db.alibaba.com/release/1.0.5/Chat2DB-1.0.5-arm64.dmg](https://oss-chat2db.alibaba.com/release/1.0.3/Chat2DB-1.0.3-arm64.dmg)         |
| MacOS X64     | [https://oss-chat2db.alibaba.com/release/1.0.5/Chat2DB-1.0.5.dmg](https://oss-chat2db.alibaba.com/release/1.0.3/Chat2DB-1.0.3.dmg)                     |
| Jar package   | [https://oss-chat2db.alibaba.com/release/1.0.5/ali-dbhub-server-start.jar](https://oss-chat2db.alibaba.com/release/1.0.3/ali-dbhub-server-start.jar)   |


## 🌰 Demo
- Create data source
  <a><img src="https://gw.alicdn.com/imgextra/i3/O1CN01PlpLYy1hIq5aMugpg_!!6000000004255-0-tps-3446-1750.jpg" width="100%"/></a>
- Data source management
  <a><img src="https://gw.alicdn.com/imgextra/i2/O1CN01DpzZJL1T7w2Xv9VMl_!!6000000002336-0-tps-3410-1662.jpg" width="100%"/></a>
- SQL console
  <a><img src="https://gw.alicdn.com/imgextra/i2/O1CN01aidnkx1Oo0LJ1Pdty_!!6000000001751-0-tps-3440-1736.jpg" width="100%"/></a>
- AI intelligent assistant
  <a><img src="https://gw.alicdn.com/imgextra/i4/O1CN01iaSXot1W6VeaDFbK2_!!6000000002739-0-tps-3430-1740.jpg" width="100%"/></a>


## 📦 Docker installation

```bash
docker pull chat2db/chat2db:latest
```

## 🎯 Operating Environment
Note: If local debugging is required
- Java runtime Open JDK 17
- JRE reference packaging and deployment method of jre.
- Node runtime environment Node16 Node.js.

## 💻 Local Debugging
- git clone to local
```bash
$ git clone git@github.com:alibaba/Chat2DB.git
```
- Front-End installation
```bash
$ cd Chat2DB/ali-dbhub-client
$ npm install # Mounting front-end dependency
$ npm run build:prod # Package js to the source directory on the back end
```
- Backend debug
```bash
$ cd ../ali-dbhub-server
$ mvn clean install # maven 3.8 or later needs to be installed
$ cd ali-dbhub-server/ali-dbhub-server-start/target/
$ java -jar -Dchatgpt.apiKey=xxxxx ali-dbhub-server-start.jar  # To launch the chat application, you need to enter the ChatGPT key for the chatgpt.apiKey. Without entering it, you won't be able to use the AIGC function.
$ # open http://127.0.0.1:10821 to start debug Note: Front-end installation is required
```

- Front-End debug
```bash
$ cd Chat2DB/ali-dbhub-client
$ npm install 
$ npm run start 
$ # open http://127.0.0.1:10821  to start Front-End debug
$ # Note Front-end page completely depends on the service, so front-end students need to debug the back-end project
```
But front debugging need mapping of resources, you can download [XSwitch](https://chrome.google.com/webstore/detail/idkjhjggpffolpidfkikidcokdkdaogg), add the following configuration file
``` json
{
  "proxy": [
    [
      "http://127.0.0.1:10821/(.*).js$",
      "http://127.0.0.1:8001/$1.js",
    ],
    [
      "http://127.0.0.1:10821/(.*).css$",
      "http://127.0.0.1:8001/$1.css",
    ],
    [
      "http://127.0.0.1:10821/static/front/(.*)",
      "http://127.0.0.1:8001/$1",
    ],
    [
      "http://127.0.0.1:10821/static/(.*)$",
      "http://127.0.0.1:8001/static/$1",
    ],
  ],
}

```

## 📑 Documentation

* <a href="https://github.com/alibaba/ali-dbhub/wiki">WIKI</a>
* <a href="https://github.com/alibaba/ali-dbhub/issues">Issue tracker</a>

## ☎️ Contact Us
<a><img src="https://gw.alicdn.com/imgextra/i1/O1CN01VBaYST1MFzhUY9QP6_!!6000000001406-0-tps-723-731.jpg" width="40%"/></a>

微信：yxccw132  钉钉：9135032392

## ❤️ Acknowledgements
Thanks to all the students who contributed to Chat2DB~

<a href="https://github.com/alibaba/ali-dbhub/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=alibaba/ali-dbhub" />
</a>


