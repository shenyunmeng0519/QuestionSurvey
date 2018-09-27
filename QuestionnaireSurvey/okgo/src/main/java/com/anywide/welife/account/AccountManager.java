package com.anywide.welife.account;

import android.content.ContentValues;
import android.database.Cursor;

import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.db.BaseDao;
import com.lzy.okgo.db.CookieManager;
import com.lzy.okgo.db.DBHelper;

import okhttp3.Cookie;

/**
 * ================================================
 * 作    者：chenwei
 * 版    本：1.0
 * 创建日期：18/1/19
 * 描    述：
 * ================================================
 */
public class AccountManager  extends BaseDao<AccountBean> {

    private volatile static AccountManager instance;

    public static AccountManager getInstance() {
        if (instance == null) {
            synchronized (AccountManager.class) {
                if (instance == null) {
                    instance = new AccountManager();
                }
            }
        }
        return instance;
    }

    public AccountManager(){super(new DBHelper(CookieManager.context));}


    @Override
    public String getTableName() {
        return DBHelper.TABLE_ACCOUNT;
    }

    @Override
    public void unInit() {
    }

    @Override
    public AccountBean parseCursorToBean(Cursor cursor) {
        int userid = cursor.getInt(cursor.getColumnIndex(AccountBean.COLUMN_USERID));
        String nickname = cursor.getString(cursor.getColumnIndex(AccountBean.COLUMN_NICKNAME));
        String domain = cursor.getString(cursor.getColumnIndex(AccountBean.COLUMN_DOMAIN));
        int addtime = cursor.getInt(cursor.getColumnIndex(AccountBean.COLUMN_ADDTIME));
        byte[] cookieBytes = cursor.getBlob(cursor.getColumnIndex(AccountBean.COLUMN_COOKIE));
        String userheadpath = cursor.getString(cursor.getColumnIndex(AccountBean.COLUMN_USERHEADPATH));
        String cookiename = cursor.getString(cursor.getColumnIndex(AccountBean.COLUMN_COOKIENAME));
        Cookie cookie = AccountUtil.bytesToCookie(cookieBytes);
        return new AccountBean(userid,nickname,domain,addtime,cookie,userheadpath,cookiename);
    }

    @Override
    public ContentValues getContentValues(AccountBean accountBean) {
        ContentValues values = new ContentValues();
        values.put(AccountBean.COLUMN_USERID, accountBean.getUserid());
        values.put(AccountBean.COLUMN_NICKNAME, accountBean.getNickname());
        values.put(AccountBean.COLUMN_ADDTIME, accountBean.getAddtime());
        values.put(AccountBean.COLUMN_DOMAIN,accountBean.getDomain());
        values.put(AccountBean.COLUMN_COOKIE,AccountUtil.cookieToBytes(accountBean));
        values.put(AccountBean.COLUMN_USERHEADPATH, accountBean.getUserheadpath());
        values.put(AccountBean.COLUMN_COOKIENAME, accountBean.getCookiename());
        return values;
    }
}
