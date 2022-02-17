package com.saihou.blog.util;

/**
 * コンスタント
 *
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 17:18
 */
public class Constant {

    // Restful APIのため
    public final static int SUCCESS_STATUS = 200;
    public final static String SUCCESS_MESSAGE = "SUCCESS";
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
}
