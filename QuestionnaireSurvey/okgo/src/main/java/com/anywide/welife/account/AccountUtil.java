package com.anywide.welife.account;

import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.db.CookieManager;
import com.lzy.okgo.utils.OkLogger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;

/**
 * ================================================
 * 作    者：chenwei
 * 版    本：1.0
 * 创建日期：18/1/19
 * 描    述：
 * ================================================
 */
public class AccountUtil {

    private static String domain;
    private static DBCookieStore dbCookieStore ;
    public static final String ANY_TK = "any_tk";
    public static final String DAWDLER_KEY = "_dawdler_key";

    public static void setLastDomain(String domainParam){
        if(domainParam!=null && !domainParam.equals(domain))
            domain = domainParam;
    }

    public static List<AccountBean> getAccountList(){
        if(domain==null) return null;
        dbCookieStore  = new DBCookieStore(CookieManager.context);
        List<AccountBean> query = AccountManager.getInstance().query("domain=?","", new String[]{domain});
        List<AccountBean> returnList = new ArrayList<>();
        for (AccountBean accountBean : query) {
            Cookie cookie = accountBean.getCookie();
            if (isCookieExpired(cookie)) {
                delAccount(accountBean.getUserid());
            }else{
                returnList.add(accountBean);
            }
        }
        return returnList;
    }

    public static boolean updAccount(int userid,String nickname,String userheadpath){
        if(userid==0) return false;
        dbCookieStore  = new DBCookieStore(CookieManager.context);
        List<AccountBean> query = AccountManager.getInstance().query("domain=? and userid=?","", new String[]{domain,userid+""});
        if(query!=null && !query.isEmpty()) {
            AccountBean accountBean = query.get(0);
            Cookie cookie = accountBean.getCookie();
            if (isCookieExpired(cookie)) {
                delAccount(accountBean.getUserid());
                return false;
            }
            if(nickname!=null){
                accountBean.setNickname(nickname);
            }
            if(userheadpath!=null){
                accountBean.setUserheadpath(userheadpath);
            }
            return AccountManager.getInstance().replace(accountBean);
        }

        return false;
    }

    public static boolean addAccount(int userid,String nickname,String userheadpath){
        if(userid == 0) return false;
        dbCookieStore  = new DBCookieStore(CookieManager.context);
        List<Cookie> lstCookie = dbCookieStore.loadCookie(domain,ANY_TK);

        if(lstCookie!=null && !lstCookie.isEmpty()){

            AccountBean accountBean = new AccountBean();
            accountBean.setDomain(domain);
            accountBean.setUserid(userid);
            accountBean.setNickname(nickname);
            accountBean.setUserheadpath(userheadpath);
            accountBean.setAddtime((int)System.currentTimeMillis()/1000);
            for(Cookie cookie : lstCookie){
                accountBean.setCookiename(cookie.name());
                accountBean.setCookie(cookie);
                boolean bR = AccountManager.getInstance().replace(accountBean);
                if(!bR){
                    delAccount(userid);
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean switchAccount(int userid){
        dbCookieStore  = new DBCookieStore(CookieManager.context);
        List<AccountBean> query = AccountManager.getInstance().query("domain=? and userid=? and cookiename=?",new String[]{domain,userid+"",ANY_TK});
        if(query!=null && !query.isEmpty()){
            AccountBean accountBean = query.get(0);
            //当前cookie是否过期
            Cookie cookie = accountBean.getCookie();
            if (isCookieExpired(cookie)) {
                dbCookieStore.removeCookie(accountBean.getDomain(), cookie);
                return false;
            } else {
                //内存缓存
                dbCookieStore.cookies.get(accountBean.getDomain()).put(dbCookieStore.getCookieToken(cookie), cookie);
                //数据库缓存
                SerializableCookie serializableCookie = new SerializableCookie(accountBean.getDomain(), cookie);
                boolean bSwitch = CookieManager.getInstance().replace(serializableCookie);
                if(bSwitch){
                    return dbCookieStore.removeCookie(domain,DAWDLER_KEY);
                }
            }
        }
        return false;
    }

    public static boolean delAccount(int userid){
        String whereClause = "domain=? and userid=? and cookiename=?";
        String[] whereArgs = {domain,userid+"",ANY_TK};
        return AccountManager.getInstance().delete(whereClause, whereArgs);
    }

    public static byte[] cookieToBytes(AccountBean accountBean) {
        AccountBean accountBean1 = new AccountBean(accountBean.getUserid(),accountBean.getNickname(),accountBean.getDomain(),accountBean.getAddtime(),accountBean.getCookie(),accountBean.getUserheadpath(),accountBean.getCookiename());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(os);
            outputStream.writeObject(accountBean1);
        } catch (IOException e) {
            OkLogger.printStackTrace(e);
            return null;
        }
        return os.toByteArray();
    }

    /** 当前cookie是否过期 */
    private static boolean isCookieExpired(Cookie cookie) {
        return cookie.expiresAt() < System.currentTimeMillis();
    }

    public static Cookie bytesToCookie(byte[] bytes) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Cookie cookie = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            AccountBean acountBean = (AccountBean) objectInputStream.readObject();
            cookie = acountBean.getCookie();
        } catch (Exception e) {
            OkLogger.printStackTrace(e);
        }
        return cookie;
    }
}
