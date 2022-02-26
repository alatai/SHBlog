[日本語紹介](https://github.com/alatai/SHBlog/tree/japanese)

# SHBlog
SAI HOU's blog site.

## 技术选型
### blog_server（后台管理 + 数据接口）
#### Maven构建
* Springboot（2.6.3)
  * Springboot Jpa
  * thymeleaf
* MySQL（5.8)
* Redis（6.2.3）
* Bootstrap（4.6)
* Vue（2.6.14)
* Shiro（1.8.0）
* ...

**详情参见pom.xml文件**

### blog_client（用户系统)
#### Vue cli构建
* Vue（2.6.14）
* Vuex（3.6.2）
* bootstrap-vue（2.21.2）
* ...

**详情参见package.json**

## 项目启动注意
### blog_server
* 注意请先启动Redis服务
  * 下载安装：https://redis.io/download
* 启动Springboot服务

### blog_client
* 安装配置Node.js、npm
  * 本项目Node.js（v14.18.3.)
    * 下载安装：https://nodejs.org/en/
  * 本项目npm（6.14.15）
    * 安装Node.js时附带安装
* 安装项目依赖：npm install
* 启动服务：npm run serve
