package com.zeacen.question.bean;

import java.io.Serializable;


public class User implements Serializable {
    /**
     * 用户ID
     */
    private Integer userid;

    /**
     * 用户组id
     */
    private Integer ugid;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 联系手机号
     */
    private String contactMobile;

    /**
     * 密码
     */
    private String passwd;

    /**
     * 密钥
     */
    private String securekey;

    /**
     * 生日
     **/
    private String birthday;

    /**
     * 性别
     **/
    private Integer sex;

    /**
     * 会有地址
     **/
    private String address;
    /**
     * 会员卡号
     **/
    private String card;
    /**
     * 头像
     */
    private String userheadpath;

    /**
     * 注册时间
     */
    private Integer addtime;

    /**
     * 最后登录时间
     */
    private Integer lastlogintime;

    /**
     * 登录次数
     */
    private Integer logintime;

    /**
     * ip地址
     */
    private String ipaddress;


    /**
     * 设备名称
     */
    private String device;

    /**
     * 设备码
     */
    private String devicecode;

    /**
     * 身份码
     */
    private String authentication;


    /**
     * 虚拟用户
     */
    private Integer vu;

    /**
     * 当前APP版本号
     */

    private String currentVersion;
    /**
     * 手机系统版本号
     */

    private String systemVersion;
    /**
     * 通道号百度推送用
     */
    private String channelId;

    /**
     * QQ登录码
     */
    private String qqopenid;
    /**
     * 微信登录码
     */
    private String wxopenid;
    /**
     * 增加积分量
     */
    private String integrate;
    /**
     * 第三方登录
     */
    private String openId;
    /**
     * 登录来源，1为QQ2为微信
     */
    private String loginSource;


    private int rpCount;

    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 判断用户是否实名认证
     */
    private int certificationmark;
    /** 金币 */
    private Double gold;
    private Integer goldbean;
    /** 第三方登录 是否绑定手机**/
    private boolean isRegister;

    /**
     * 用户签名
     */
    private String content;
    /**
     * 能否修改头像,1可修改，0不可修改
     */
    private int ishead;
    /**
     * 能否修改昵称,1可修改，0不可修改
     */
    private int isnickname;

    public int getIsnickname() {
        return isnickname;
    }

    public void setIsnickname(int isnickname) {
        this.isnickname = isnickname;
    }

    public int getIshead() {

        return ishead;
    }

    public void setIshead(int ishead) {
        this.ishead = ishead;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRegister() {
        return isRegister;
    }

    public void setRegister(boolean register) {
        isRegister = register;
    }

    public Double getGold() {
        return gold;
    }

    public void setGold(Double gold) {
        this.gold = gold;
    }

    public Integer getGoldbean() {
        return goldbean;
    }

    public void setGoldbean(Integer goldbean) {
        this.goldbean = goldbean;
    }




    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public int getRpCount() {
        return rpCount;
    }

    public void setRpCount(int rpCount) {
        this.rpCount = rpCount;
    }

    public String getLoginSource() {
        return loginSource;
    }

    public void setLoginSource(String loginSource) {
        this.loginSource = loginSource;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }


    public Integer getVu() {
        return vu;
    }

    public void setVu(Integer vu) {
        this.vu = vu;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    private static final long serialVersionUID = 1L;

    /**
     * 获取[userid]
     *
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置[userid]
     *
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取[]
     *
     * @return ugid
     */
    public Integer getUgid() {
        return ugid;
    }

    /**
     * 设置[]
     *
     * @param ugid
     */
    public void setUgid(Integer ugid) {
        this.ugid = ugid;
    }

    /**
     * 获取[昵称]
     *
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置[昵称]
     *
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取[手机号]
     *
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置[手机号]
     *
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取[密钥]
     *
     * @return securekey
     */
    public String getSecurekey() {
        return securekey;
    }

    /**
     * 设置[密钥]
     *
     * @param securekey
     */
    public void setSecurekey(String securekey) {
        this.securekey = securekey == null ? null : securekey.trim();
    }

    /**
     * 获取[]
     *
     * @return userheadpath
     */
    public String getUserheadpath() {
        return userheadpath;
    }

    /**
     * 设置[]
     *
     * @param userheadpath
     */
    public void setUserheadpath(String userheadpath) {
        this.userheadpath = userheadpath == null ? null : userheadpath.trim();
    }

    /**
     * 获取[注册时间]
     *
     * @return addtime
     */
    public Integer getAddtime() {
        return addtime;
    }

    /**
     * 设置[注册时间]
     *
     * @param addtime
     */
    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    /**
     * 获取[最后登录时间]
     *
     * @return lastlogintime
     */
    public Integer getLastlogintime() {
        return lastlogintime;
    }

    /**
     * 设置[最后登录时间]
     *
     * @param lastlogintime
     */
    public void setLastlogintime(Integer lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /**
     * 获取[登录次数]
     *
     * @return logintime
     */
    public Integer getLogintime() {
        return logintime;
    }

    /**
     * 设置[登录次数]
     *
     * @param logintime
     */
    public void setLogintime(Integer logintime) {
        this.logintime = logintime;
    }

    /**
     * 获取[ip地址]
     *
     * @return ipaddress
     */
    public String getIpaddress() {
        return ipaddress;
    }

    /**
     * 设置[ip地址]
     *
     * @param ipaddress
     */
    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }

    /**
     * 获取[设备名称]
     *
     * @return device
     */
    public String getDevice() {
        return device;
    }

    /**
     * 设置[设备名称]
     *
     * @param device
     */
    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    /**
     * 获取[设备码]
     *
     * @return devicecode
     */
    public String getDevicecode() {
        return devicecode;
    }

    /**
     * 设置[设备码]
     *
     * @param devicecode
     */
    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode == null ? null : devicecode.trim();
    }


    /**
     * @return the realname
     */
    public String getRealname() {
        return realname;
    }

    /**
     * @param realname the realname to set
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * @return the idcard
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * @param idcard the idcard to set
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * @return the certificationmark
     */
    public int getCertificationmark() {
        return certificationmark;
    }

    /**
     * @param certificationmark the certificationmark to set
     */
    public void setCertificationmark(int certificationmark) {
        this.certificationmark = certificationmark;
    }
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getQqopenid() {
        return qqopenid;
    }

    public void setQqopenid(String qqopenid) {
        this.qqopenid = qqopenid;
    }

    public String getWxopenid() {
        return wxopenid;
    }

    public void setWxopenid(String wxopenid) {
        this.wxopenid = wxopenid;
    }

    public String getIntegrate() {
        return integrate;
    }

    public void setIntegrate(String integrate) {
        this.integrate = integrate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}