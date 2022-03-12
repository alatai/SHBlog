# SHBlog
SAI HOU's blog site.

## 技術の選択
### blog_server（管理サイト + API CALL）
#### バックエンド：Mavenで構築しました
* Spring Boot（2.6.3)
  * Spring Boot JPA
  * thymeleaf
* Shiro（1.8.0）
* MySQL（5.8)
* Redis（6.2.3）
* ...

**詳細：pom.xml**

#### ページ
* Vue（2.6.14)
* Bootstrap（4.6)
* AdminLTE（3.2)
* ...

### blog_client（一般的なユーザ向け)
#### Vue CLIで構築しました
* Vue（2.6.14）
* Vuex（3.6.2）
* bootstrap-vue（2.21.2）
* ...

**詳細：package.json**

## 注意
### blog_server
* 先にRedisサーバーを起動してください
  * ダウンロード&インストール：https://redis.io/download
* Spring Bootプロジェクトを起動します

### 管理サイトの登録
* URL:http://localhost:8088/admin/index
* アカウント：admin
* パスワード：123

### ブログサイト
* URL:http://localhost:8080/blogs

### blog_client
* Node.js、npmをインストールしてください
  * 本プロジェクト：Node.js（v14.18.3.)
    * ダウンロード：https://nodejs.org/en/
  * 本プロジェクト：npm（6.14.15）
    * Node.jsと共にインストールします
* 依頼をインストールする：npm install
* Nodejsサーバーを立ち上げる：npm run serve
