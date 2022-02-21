package com.saihou.blog.util;

/**
 * コンスタント
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 17:18
 */
public class Constant {

    // COMMON
    public final static String SUCCESS = "SUCCESS";
    public final static String FAIL = "FAIL";

    // ファイルアップロードパス
    public final static String UPLOAD_PATH = "/img/blog/";
    // ブログ状態
    public final static int BLOG_WAIT_RELEASE = 0;
    public final static int BLOG_RELEASED = 1;
    public final static int BLOG_DELETED = 2;
    // ブログ状態DESC
    public final static String BLOG_WAIT_RELEASE_DESC = "リリース待ち";
    public final static String BLOG_RELEASED_DESC = "リリースした";
    public final static String BLOG_DELETED_DESC = "削除";
    public final static String BLOG_ERROR_DESC = "エラー";
    // ログインメッセージ
    public final static String LOGIN_SUCCESS = "LOGIN SUCCESS";
    public final static String LOGIN_FAIL = "パスワードまたはユーザネームが間違っている！";
    // ユーザ情報更新メッセージ
    public final static String PASSWORD_MISTAKE = "旧パスワード間違い！";
    public final static String PASSWORD_SAME = "旧パスワードと同じ！";
}
