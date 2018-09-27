package com.anywide.welife.account;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import okhttp3.Cookie;

/**
 * ================================================
 * 作    者：chenwei
 * 版    本：1.0
 * 创建日期：18/1/19
 * 描    述：
 * ================================================
 */
public class AccountBean implements Serializable {

    public static final String COLUMN_DOMAIN = "domain";
    public static final String COLUMN_COOKIENAME="cookiename";
    public static final String COLUMN_USERID = "userid";
    public static final String COLUMN_NICKNAME="nickname";
    public static final String COLUMN_ADDTIME="addtime";
    public static final String COLUMN_COOKIE="cookie";
    public static final String COLUMN_USERHEADPATH="userheadpath";


    private String domain;
    private int userid;
    private String nickname;
    private int addtime;
    private transient Cookie cookie;
    private String userheadpath;
    private transient Cookie clientCookie;
    private String cookiename;

    public AccountBean(){}

    public AccountBean(int userid,String nickname,String domain,int addtime,Cookie cookie,String userheadpath,String cookiename){
        this.domain = domain;
        this.userid = userid;
        this.nickname = nickname;
        this.addtime = addtime;
        this.cookie = cookie;
        this.userheadpath = userheadpath;
        this.cookiename = cookiename;

    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(cookie.name());
        out.writeObject(cookie.value());
        out.writeLong(cookie.expiresAt());
        out.writeObject(cookie.domain());
        out.writeObject(cookie.path());
        out.writeBoolean(cookie.secure());
        out.writeBoolean(cookie.httpOnly());
        out.writeBoolean(cookie.hostOnly());
        out.writeBoolean(cookie.persistent());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        String name = (String) in.readObject();
        String value = (String) in.readObject();
        long expiresAt = in.readLong();
        String domain = (String) in.readObject();
        String path = (String) in.readObject();
        boolean secure = in.readBoolean();
        boolean httpOnly = in.readBoolean();
        boolean hostOnly = in.readBoolean();
        boolean persistent = in.readBoolean();
        Cookie.Builder builder = new Cookie.Builder();
        builder = builder.name(name);
        builder = builder.value(value);
        builder = builder.expiresAt(expiresAt);
        builder = hostOnly ? builder.hostOnlyDomain(domain) : builder.domain(domain);
        builder = builder.path(path);
        builder = secure ? builder.secure() : builder;
        builder = httpOnly ? builder.httpOnly() : builder;
        clientCookie = builder.build();
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAddtime() {
        return addtime;
    }

    public void setAddtime(int addtime) {
        this.addtime = addtime;
    }

    public Cookie getCookie() {
        Cookie bestCookie = cookie;
        if (clientCookie != null) {
            bestCookie = clientCookie;
        }
        return bestCookie;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUserheadpath() {
        return userheadpath;
    }

    public void setUserheadpath(String userheadpath) {
        this.userheadpath = userheadpath;
    }

    public String getCookiename() {
        return cookiename;
    }

    public void setCookiename(String cookiename) {
        this.cookiename = cookiename;
    }

    public Cookie getClientCookie() {
        return clientCookie;
    }

    public void setClientCookie(Cookie clientCookie) {
        this.clientCookie = clientCookie;
    }
}
