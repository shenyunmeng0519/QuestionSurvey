package com.zeacen.question.constant;


import android.Manifest;
import android.os.Environment;

/**
 * @ClassName: Constant
 */
public class YYGConstant {
    public final static boolean UI_DEBUG = false;


    /**
     * -----------------打包注意变量---------------------
     **/
    // 调试标记：发布正式版一定要修改false
    public final static boolean DEBUG = false;
    // 是否是虚拟用户版本
    public final static boolean VIRTUAL_USER = false;
    public static final eSeverUrlType serverUrlType = eSeverUrlType.release;
    //public static String BASE_URL = "http://192.168.1.130:8080/web/";
    //梁思佳本地接口
//    public static String BASE_URL = "http://192.168.1.78:8080/web/";
    //梁永兴本地接口
    //public static String BASE_URL = "http://192.168.1.130:8080/web/";
    //刘峰本地接口
    public static String BASE_URL = "http://192.168.1.65:8080/web/";
    //栾军本地接口
    // public static String BASE_URL = "http://192.168.1.190:8080/web/";
    //俊飞本地接口
    // public static String BASE_URL = "http://testmall.welife1948.com/";
    public static String VG_BASE_URL = "http://192.168.1.201:8080/welife_mall/";
    //李斌斌本地接口
     //public static String BASE_URL = "http://192.168.1.79:8080/web/";
    //陈星昊本地接口
    //public static String BASE_URL = "http://192.168.1.201:8080/web/";
      static {
        if (serverUrlType == eSeverUrlType.beta) {//测试环境场合
            //BASE_URL = "http://192.168.1.153/web/";
            VG_BASE_URL = "http://testmall.welife1948.com/";
            BASE_URL = "http://test.welife1948.com/";
        } else if (serverUrlType == eSeverUrlType.release) {//正式环境场合
            BASE_URL = "http://www.welife1948.com/";
            VG_BASE_URL = "http://mall.welife1948.com/";
        } else if (serverUrlType == eSeverUrlType.virtual) {//虚拟用户场合
            BASE_URL = "http://www.welife1948.com/";
            VG_BASE_URL = "http://mall.welife1948.com/";
            /*VG_BASE_URL = "http://testmall.welife1948.com/";
            BASE_URL = "http://test.welife1948.com/";*/
        }
    }
    public static int AAA= 30000;
    // 默认使用推送
    public static final ePushType pushType = ePushType.xiaomi;
    // 是否显示PK
    public static final boolean IS_PK = false;
    // 是否显示竞猜
    public static final boolean IS_INVITATION = false;
    // 玩法多少秒以后不能买
    public static final String COUNT_DOWN = "3";
    // 分享内容默认值
    public static final String WEIXIN_SHARE_CONTENT = "哇！在“会生活”上看到的好东西，必须分享！";
    public static ePayFun ePayFunTemp = ePayFun.NULL;

    public enum ePayFun {
        NULL, PayFor, Recharge, PlayAction, QuizPay
    }

    public static int NormalGplayidNull = 0;//正常玩法
    public static int NormalGplayid = 1;//正常玩法
    public static int TowSelOneGplayid = 2;//二选一
    public static int FourSelOneGplayid = 3;//四选一
    /**
     * ------------------APPID开始-----------------------
     **/
    // 小米云推送
    public static final String APP_ID = "2882303761517714225";
    public static final String APP_KEY = "5401771486225";

    // 微客服正式工作组
    public static final String APPKEFU_WORK_GROUP = "yyhgkf";

    //盾形第三方支付
    public static final boolean IS_DX = false;
    public static final String DX_WEBCHAT = "774F3387DF3F550870BDED670EFDD9E51B407FDB9CF2EB06";

    /**
     * ------------------图片路径开始-------------------
     **/
    // 头像
    //public static String HEAD_PATH_OLD = BASE_URL+Environment.getExternalStorageDirectory() + "/myHead/";1不能删除
    public static String HEAD_PATH = Environment.getExternalStorageDirectory() + "/myHead/";
    // 晒单
    //public static String SD_DIRECTORY_OLD = BASE_URL+"/Photo_LJ/";2不能删除
    public static String SD_DIRECTORY = "/Photo_LJ_wy/";
    //public static String SD_PATH_OLD= BASE_URL+Environment.getExternalStorageDirectory() + SD_DIRECTORY;3不能删除
    public static String SD_PATH = Environment.getExternalStorageDirectory() + SD_DIRECTORY;
    // 地址薄文件
    public static String ADDRESS_PATH = Environment.getExternalStorageDirectory() + "/wy/";
    public static String ADDRESS_PATH_TEMP = Environment.getDownloadCacheDirectory().toString() + "/wy/";

    /**
     * ----------------H5页面和资源文件开始--------------
     **/
    //服务协议
    public static final String AGREEMENT = BASE_URL + "app/agreement/service.html";
    // 用户注册协议
    public static final String AGREEMENT_H5 = BASE_URL + "app/agreement/userservice.html";
    // 隐私政策
    public static final String YINSI_H5 = BASE_URL + "app/agreement/privacy.html";
    //等级特权说明
    public static final String GRADE = BASE_URL + "myapp/agreement/grade.html";
    // 红包使用说明
    public static final String REDPACKET_H5 = VG_BASE_URL + "redpacket.html";
    // 鲜花使用规则页面
    public static final String PRIVACY = BASE_URL + "app/agreement/privacy.html";
    // 获取鲜花方法页面
    public static final String GETFLOWER = VG_BASE_URL +"staticfile/mobile/getFlower.html";
    // 邀请好友
    public static final String INVITEFRIEND = BASE_URL + "activity/invitefriend/index.html";
    //参与结果
    public static final String  PARTICIPATION = VG_BASE_URL+"staticfile/mobile/joinResult.html";
    /**
     * -------------------------------------------接口开始--------------------------
     * -------------------
     **/
    public static final String Evaluation = "http://123.57.162.168:8081/mall/app/goods/evaluation/list.json";
    //会员商品列表
    public static final String GOODSLIST = BASE_URL + "app/glist/goods.do";
    // 首页数据初始化 1.2.2
    public static final String INDEX_ALL = BASE_URL + "app/index/indexAll.do";
    // 获取个人详细信息
    public static final String USERINFO = BASE_URL + "myapp/user/userInfoApp.do";
    // 启动页数据初始化 1.2.2
    public static final String STARTUP_PAGE_DATA = BASE_URL + "app/variable/list.do";
    // 修改昵称
    public static final String CHAGENAME = BASE_URL + "myapp/user/updateNicknameApp.do";
    //设置用户签名
    public static final String SIGNATURE = BASE_URL + "myapp/usermood/insertOrUpdateContentApp.do";
    //设置性别
    public static final String UPDATE_SEX = BASE_URL + "myapp/userinfo/updateSexApp.do";
    //设置生日
    public static final String UPDATE_BIRTHDAY = BASE_URL + "myapp/userinfo/updateBirthdayApp.do";
    // 退出登录
    public static final String EXIT = BASE_URL + "myapp/user/exit.do";
    // 更改头像
    public static final String UPDATEUSERHERAPATH = BASE_URL + "myapp/user/updateUserHeadpath.do";
    // 意见反馈-添加反馈信息
    public static final String FEEDBACK = BASE_URL + "myapp/feedback/insertFeedbackApp.do";

    // 用户登录URL
    public static final String LOGIN_URL = BASE_URL + "app/user/login.do";
    // 动态登录
    public static final String OPENIDLOGIN = BASE_URL + "app/newsecure/user/openIdLogin.do";
    // 手机登录
    public static final String FASTLOGIN = BASE_URL + "app/newsecure/user/fastLogin.do";
    //圈子列表
    public static final String CIRCLE = BASE_URL + "app/circle/list.do";
    //加入退出圈子
    public static final String JOIN = BASE_URL + "myapp/circle/join.do";
    //系统提醒设置
    public static final String SHEZHI_XITONG = BASE_URL + "myapp/userinfo/updateSysremindApp.do";
    //回复设置
    public static final String SHEZHI_HUIFU = BASE_URL + "myapp/userinfo/updateReplyremindApp.do";
    //赞设置
    public static final String SHEZHI_ZAN = BASE_URL + "myapp/userinfo/updateSupportremindApp.do ";
    // 圈子首页接口
    public static final String CIRCLE_INDEX = BASE_URL + "app/circle/index.do";
    // 最新回复、最新发帖、24H热帖滑动接口
    public static final String INVITATIONLIST = BASE_URL + "app/circle/invitationList.do";
    // 圈子介绍页面接口
    public static final String CIRCLEDETAILS = BASE_URL + "app/circle/circleDetails.do";
    //举报类型获取
    public static final String GETREPORT = BASE_URL + "myapp/complaint/selectComplaintTypeInfo.do";
    //举报上传
    public static final String SETREPORT = BASE_URL + "myapp/newsecure/complaint/insertComplaintInfo.do";
    // 头图、开机广告、广告弹窗点击计数接口
    public static final String ADADDCLICKNUM = BASE_URL + "app/index/adAddClickNum.do";
    // 首页热帖列表接口
    public static final String HOME_INVITATIONLIST = BASE_URL + "app/index/invitationList.do";
    // 首页接口
    public static final String HOME_INDEX = BASE_URL + "app/index/index.do";
    // 上传图片接口
    public static final String UPLOAD = BASE_URL + "myapp/newsecure/invitation/posting.do";
    public static final String URL_GANK_BASE = "http://gank.io/api/data/";
    // 注册 获取手机验证码
    public static final String GET_VALIDATECODE = BASE_URL + "app/send/getValidateCode.do";
    // 注册 用户注册
    public static final String REGISTER = BASE_URL + "app/newsecure/user/register.do";
    // 注册 校验验证码是否正确
    public static final String CHECK_VALIDATECODE = BASE_URL + "app/send/isOverdue.do";
    //密码重置(修改密码,忘记密码)
    public static final String UPDATEPASSWORD = BASE_URL + "app/user/updatePassword.do";
    //我的回复接口
    public static final String REPLY = BASE_URL + "myapp/user/invitationReply.do";
    //关注圈子
    public static final String CONCERNQUANZI = BASE_URL + "myapp/user/circle.do";
    //我的发帖
    public static final String MYPOST = BASE_URL + "app/user/invitation.do";
    //阿里凭证
    public static final String ALIPINGZHENG = BASE_URL + "myapp/newsecure/invitation/getCredentials.do";
    //我的页面
    public static final String MY = BASE_URL + "myapp/user/getMyInfo.do";
    //回复列表
    public static final String REPLY1 = BASE_URL + "myapp/msg/rmsglist.do";
    //被赞列表
    public static final String COOL = BASE_URL + "myapp/msg/supportlist.do";
    //鲜花列表
    public static final String XIANHUA = BASE_URL + "myapp/flower/selectFlowerMessage.do";
    //回复已读添加
    public static final String REPLY_TIANJIA = BASE_URL + "myapp/msg/rmsgread.do";
    //点赞已读添加
    public static final String COOL_TIANJIA = BASE_URL + "myapp/msg/supportread.do";
    //回复全部已读
    public static final String REPLY_QUAN = BASE_URL + "myapp/msg/rmsgallread.do";
    //点赞全部已读
    public static final String COOL_QUAN = BASE_URL + "myapp/msg/supportallread.do";
    //帖子详情web
    public static final String CIRCLE_DETAILS = BASE_URL + "app/invitation/invdetail.html";
    //回复详情
    public static final String HUIFU_DETAILS = BASE_URL + "app/invitationreply/replylist.html";
    //回复接口
    public static final String HUIFU = BASE_URL + "myapp/newsecure/reply/postReply.do";
    //未读消息总数量（系统、点赞、回复）
    public static final String XITONG = BASE_URL + "myapp/msg/notreadcnt.do";
    //查询提醒设置
    public static final String SHEZHI = BASE_URL + "myapp/userinfo/selectRemindInfoApp.do";
    //系统消息详情接口html
    public static final String XT_XIANGQING = BASE_URL + "myapp/msg/sysmsginfo.html";
    //我的系统消息列表
    public static final String MY_XITONG = BASE_URL + "myapp/msg/sysmsglist.do";
    //系统消息查看
    public static final String MY_CHAKAN = BASE_URL + "myapp/msg/sysmsgread.do";
    //删除帖子
    public static final String DELETE = BASE_URL + "myapp/newsecure/invitation/softDeletePost.do";
    //统一设置提醒
    public static final String TONGYI = BASE_URL + "myapp/userinfo/updateRemindAllApp.do";
    //设置
    public static final String SELECTMYPASSWD = BASE_URL + "myapp/user/selectMyPasswd.do";
    //我的系统消息未读数量（系统、点赞、回复）
    public static final String CHAKAN = BASE_URL + "myapp/msg/notreadlist.do";
    // 首页附近的人接口
    public static final String NEARBYLIST = BASE_URL + "app/index/nearbyList.do";
    // 用户关注接口/取消关注接口
    public static final String ATTENTION = BASE_URL + "myapp/attention/changeattention.do";
    // 附近的人列表接口
    public static final String MYNEARBYLIST = BASE_URL + "myapp/user/myNearbyList.do";
    // 绑定手机号接口
    public static final String MOBILEBINDING = BASE_URL + "myapp/user/mobileBinding.do";
    // 七牛云上传图片获取token接口
    public static final String GETTOKEN = BASE_URL + "myapp/invitation/getToken.do";
    // 保存帖子图片路径接口(七牛云上传成功后调)
    public static final String SUBIMG = BASE_URL + "myapp/newsecure/invitation/subImg.do";
    // 保存回复图片路径接口(七牛云上传成功后调)
    public static final String HUIFUSUBIMG = BASE_URL + "myapp/newsecure/invitationreply/subImg.do";
    // 回复七牛云上传图片获取token接口
    public static final String HUIFUTOKEN = BASE_URL + "myapp/invitationreply/getToken.do";
    // 发帖隐私设置
    public static final String PRIVACY_POST_TYPE = BASE_URL + "myapp/privacy/PrivacyPosttype.do";
    // 动态隐私设置
    public static final String PRIVACY_DYNAMIC_TYPE = BASE_URL + "myapp/privacy/PrivacyDynamictype.do";
    //  附近的人隐私设置
    public static final String PRIVACY_NEARVIEW_TYPE = BASE_URL + "myapp/privacy/PrivacyNearviewtype.do";
    //  黑名单隐私设置
    public static final String SELECT_CHAT_MESSAGE = BASE_URL + "myapp/privacy/selectChatMessage.do";

    //粉丝消息列表
    public static final String FENSI = BASE_URL+"myapp/userattention/selectFollowMessage.do";
    //我的关注列表/我的粉丝列表
    public static final String GAUNZHUANDFENSI = BASE_URL+"myapp/userattention/selectFansOrFollow.do";
    //添加/取消关注
    public static final String GUAN = BASE_URL+"myapp/attention/changeattention.do";
    //私信列表
    public static final String SIXINLIST = BASE_URL+"myapp/chatmsg/selectChatList.do";
    //私信设置
    public static final String SIXINSHEZHI = BASE_URL+"myapp/chatmsg/toChatSet.do";
    //清空聊天记录
    public static final String CLEAN = BASE_URL+"myapp/chatmsg/clearChatMsg.do";
    //未关注人列表
    public static final String WEIGUANZHU = BASE_URL+"myapp/chatmsg/selectNoCareChatList.do";
    //未关注设置
    public static final String WEIGUANZHUSETUP = BASE_URL+"myapp/chatmsg/toNoCareSet.do";
    //未关注人列表消息清除
    public static final String CLEANWEIGUANZHU = BASE_URL+"myapp/chatmsg/cleanNoCareList.do";
    //私信黑名单
    public static final String SETHEI = BASE_URL+"myapp/chatmsg/updateIsdefriend.do";
    //私信消息免打扰
    public static final String SIMIAN = BASE_URL+"myapp/chatmsg/updateIsdisturb.do";
    //未关注人消息免打扰
    public static final String WEIMIAN = BASE_URL+"myapp/chatmsg/updateNoCareSet.do";
    //私信举报进入请求
    public static final String SIXINJUBAO = BASE_URL+"myapp/chatmsg/toComplaint.do";
    //私信举报
    public static final String SIJUBAO = BASE_URL+"myapp/newsecure/chatmsg/complaint.do";
    //进入私信
    public static final String INSIXIN = BASE_URL+"myapp/chatmsg/insertChatroom.do";
    //删除单条信息
    public static final String SHANCHUSIXIN = BASE_URL+"myapp/chatmsg/clearMsg.do";
    //发送私信
    public static final String POSTSIXIN= BASE_URL+"myapp/chatmsg/insertChatMsg.do";
    //签到信息接口
    public static final String SIGNINPHOTO= BASE_URL+"myapp/signin/signinPhoto.do";
    //用户点击签到
    public static final String SIGNIN= BASE_URL+"myapp/signin/signin.do";
    //隐私查询提醒设置
    public static final String MYHOMEPAGETYPE= BASE_URL+"myapp/privacy/myHomePageType.do";
    //他的动态查看隐私设置
    public static final String PRIVACYDYNAMICTYPE= BASE_URL+"myapp/privacy/PrivacyDynamictype.do";
    //首页关注查看隐私设置
    public static final String FIRSTATTENTIONTYPE = BASE_URL + "myapp/privacy/firstAttentionType.do";
    //首页搜索接口
    public static final String SEARCHLIST = BASE_URL + "app/index/searchList.do";
    //获取手机验证码并确认手机号是否注册
    public static final String MOBILEANDVALIDATECODE = BASE_URL + "app/send/mobileAndValidateCode.do";
    //我的鲜花列表接口
    public static final String SELECTMYFLOWERMESSAGE = BASE_URL + "myapp/flower/selectMyFlowerMessage.do";
    //首页 关注接口
    public static final String ATTENTIONDYNAMIC = BASE_URL + "myapp/attentionDynamic/list.do";
    //个人主页接口
    public static final String PERSONALHOME = BASE_URL + "app/user/personHomePage.do";
    //个人主页动态接口
    public static final String  DYNAMIC = BASE_URL + "app/dynamic/list.do";
    //鲜花打赏接口查询
    public static final String  CHAXUNREWARD = BASE_URL + "app/community/selectRewardLog.do";
    //切换用户后修改用户信息
    public static final String  UPDATEUSERINFO = BASE_URL + "myapp/user/switchUserInfo.do";
    //头像修改或昵称修改
    public static final String  UPDATE_NICKNAME_HEADAPP = BASE_URL + "myapp/user/updateNicknameAndHeadApp.do";
    //新的发帖
    public static final String  NEW_POSTING = BASE_URL + "myapp/newsecure/invitation/posting.do";



    /**
     * 会购接口开始
     */
    //会购我的个人信息
    public static final String HUIGOUUSERINFO = VG_BASE_URL + "myapp/user/info.do";
    // 注册 获取手机验证码
    public static final String HUIGOU_GET_VALIDATECODE = VG_BASE_URL + "app/send/getValidateCode.do";
    //红点显示参数发现
    public static final String REDDOT = VG_BASE_URL+"app/indexcolumn/listRed.do";
    // 红包可购商品
    public static final String CANBUY = VG_BASE_URL + "myapp/redpacket/selectGoodsList.do";
    //兑换红包接口
    public static final String EXCHANGE_RED = VG_BASE_URL + "myapp/redpacket/updateRedpacketExchange.do";
    // 我的可用红包
    public static final String USABLEREDPACKET = VG_BASE_URL + "myapp/redpacket/selectMyAvailableRedpacketList.do";
    // 待派发的红包
    public static final String WAUTREDPACKET = VG_BASE_URL + "myapp/redpacket/selectMyDistributedRedpacketList.do";
    // 用完过期红包
    public static final String PASTDUERDEPACKET = VG_BASE_URL + "myapp/redpacket/selectMyExpiredOrFailRedpacketList.do";
    //分享成功加经验
    public static final String SHARE_AXM= BASE_URL+"myapp/invitation/shareExp.do";
    // 查询商品类别
    public static final String GOODSCLASSES_URL = VG_BASE_URL + "app/goodsclasses/list.do";
    // 查询商品信息列表
    public static final String GOODSLIST_URL = VG_BASE_URL + "app/goods/list.do";
    //搜索接口
    public static final String SEARCH = VG_BASE_URL + "app/search/search.do";
    //搜索热词接口
    public static final String SEARCHKEyWORDS = VG_BASE_URL + "app/search/getKeyWords.do";
    // 最新揭晓
    public static final String SELECTLISTFORNEWOPEN = VG_BASE_URL + "app/activityIssue/selectListForNewopen.do";
    // 期次详情-倒计时调用
    public static final String GETISSUEINFO_URL = VG_BASE_URL + "app/getissueinfo.do";
    // 往期揭晓
    public static final String HISTORY_AWARD = VG_BASE_URL + "app/past/activityissuelist.do";
    // 计算详情
    public static final String CALCULATE_DETAIL = VG_BASE_URL + "app/calculation/detail.do";
    // 图文详情页获取数据接口
    public static final String PIT_AND_WORD_PAGE_URL = VG_BASE_URL + "app/goodsphotolist.do";
    // 收货地址
    public static final String USERADDRESS = VG_BASE_URL + "myapp/userAddress/list.do";
    // 新增收货地址
    public static final String NEWADDRESS = VG_BASE_URL + "myapp/userAddress/save.do";
    // 删除收货地址
    public static final String DELETEADDRESS = VG_BASE_URL + "myapp/userAddress/delete.do";
    // 设置默认地址
    public static final String ADDRESS_DEFAULT = VG_BASE_URL + "myapp/userAddress/update.do";
    // 查询期次详情
    public static final String ACTIVITYISSUEINFO_URL = VG_BASE_URL + "app/aiid/activityissueinfo.do";
    // 参加下一期调用
    public static final String ACTIVITYISSUEINFO = VG_BASE_URL + "app/activityissueinfo.do";
    // 新手帮助
    public static final String NEWERHELP = VG_BASE_URL + "newerguide.html";
    // 计算规则
    public static final String CALCULATIONHELP = VG_BASE_URL + "calculationhelp.html";
    // 微信公众号
    public static final String WECHATHELP = VG_BASE_URL + "wechathelp.html";
    // 关于一元购
    public static final String ABOUTYYG = VG_BASE_URL + "aboutyyg.html?t=" + System.currentTimeMillis();
    // 帮助中心（首页）
    public static final String HOMEHELP = VG_BASE_URL + "homehelp.html";
    // 中奖详情
    public static final String AWARD_DETAILS = VG_BASE_URL + "myapp/winconvert/myinfo.do";
    //首页广告位html
    public static final String ADVERT_BABY=VG_BASE_URL+ "appwebpages.html?from=app&type=indexAd";
    // 首页获取分类商品
    public static final String FIRST_PAGE_SORT_INFO = VG_BASE_URL + "app/activityissuelist/goods.do";
    // 获取中奖列表
    public static final String ACTIVITYISSUELIST = VG_BASE_URL + "app/activityissuelist.do";
    // 首页数据初始化 1.2.2
    public static final String INDEX_ALL2 = VG_BASE_URL + "app/index/indexAll.do";
    // 实物-使用收货地址
    public static final String USE_THIS_ADDRESS = VG_BASE_URL + "myapp/winconvert/updateMyUaid.do";
    // 虚拟-商品获取卡密
    public static final String VIRTUAL_CARD_SECRET = VG_BASE_URL + "myapp/winconvert/selectMyCards.do";
    // 虚拟-商品兑换金币
    public static final String VIRTUAL_GOODS_TO_GOLD = VG_BASE_URL + "myapp/winconvert/convertMyGold.do";
    // 实物-确认收货
    public static final String CONFIRM_GET = VG_BASE_URL + "myapp/winconvert/updateMyReceive.do";
    // 商品发货地址
    public static final String DELIVERYHELP_H5 = VG_BASE_URL + "deliveryhelp.html";
    // 充值卡税换支付宝余额说明
    public static final String VIRTUALCARD_5 = VG_BASE_URL + "app/staticfile/virtualcard.do?type=5";
    // 中奖详情(虚拟用户情况）
    public static final String AWARD_DETAILS_VU = VG_BASE_URL+"myapp/winconvert/myinfoForvu.do";
    //实物商品兑换金币接口
    public static final String REALCONVERTMYGOLD=VG_BASE_URL+"myapp/winconvert/realConvertMyGold.do";
    // 支付金币抵扣接口
    public static final String PAYFORWINCODE = VG_BASE_URL + "myapp/activityIssue/goldPay.do";
    // 购买支付成功后前端回调接口-购买
    public static final String ORDERBUY = VG_BASE_URL + "myapp/orderBuy.do";
    //获取IP地址
    public static final String GET_RANDOM_NUM = VG_BASE_URL + "myapp/getRandomNum.do";
    //金币购买
    public static final String JINBIPAY = VG_BASE_URL + "myapp/activityIssue/selectGoldPayAndRedpacket.do";
    // 参与详情
    public static final String PARTICIPATION_DETAILS = VG_BASE_URL + "app/activityloglist.do";
    //是否绑定联系电话 1.5.0
    public static final String CHECK_BIND_MOBILE = VG_BASE_URL + "myapp/user/checkBindMobile.do";
    // 全部参与
    public static final String SELECTMYLISTALL = VG_BASE_URL + "myapp/activityIssue/selectMylistAll.do";
    // 进行中
    public static final String SELECTMYLISTON = VG_BASE_URL + "myapp/activityIssue/selectMylistOn.do";
    // 已揭晓
    public static final String SELECTMYLISTFINISHED = VG_BASE_URL + "myapp/activityIssue/selectMylistFinished.do";
    // 已中奖
    public static final String SELECTMYLISTWIN = VG_BASE_URL + "myapp/activityIssue/selectMylistWin.do";
    //未收货
    public static final String MYNOTRECEIVING=VG_BASE_URL+"/myapp/activityIssue/selectMylistOnNotTake.do";
    //已收货
    public static final String MYRECEIPTGOODS=VG_BASE_URL+"/myapp/activityIssue/selectMylistOnTake.do";
    // 已中奖虚拟
    public static final String SELECTMYLISTWINVU = VG_BASE_URL + "myapp/activityIssue/selectMylistWinvu.do";
    //获取打赏鲜花list
    public static final String DASHANGXIANHUALIST = BASE_URL + "myapp/mall/flowerList.do";
    //鲜花打赏接口
    public static final String XIANHUADASHANG = BASE_URL + "myapp/community/mall/rewardFlower.do";
    ///鲜花红包参与(快捷购买)
    public static final String JIONEASILY = VG_BASE_URL + "myapp/activityIssue/goldPayEasily.do";
    ///鲜花红包参与
    public static final String JIONPAY = VG_BASE_URL + "myapp/activityIssue/goldPay.do";
    // 支付页面数据初始化 1.2.2
    public static final String SELECTPAYMENTDATA = VG_BASE_URL + "myapp/paylog/selectPaymentData.do";
    //支付方式调用接口-返回支付方式
    public static final String PAYFANGSHI = VG_BASE_URL + "myapp/paytype/listAll.do";
    //礼品通知电话绑定
    public static final String BINDCONTACTMOBILE = VG_BASE_URL + "myapp/user/bindContactMobile.do";
    // 意见反馈-获取反馈类型
    public static final String FEEDBACKTYPE = VG_BASE_URL + "myapp/feedbackType/list.do";
    // 意见反馈-添加反馈信息
    public static final String HUIGOU_FEEDBACK = VG_BASE_URL + "myapp/feedback/save.do";
    // 我的-特价商品订单列表
    public static final String MYTEJIA = BASE_URL + "myapp/shopconvert/myShopGoods.do";
    // 首页商品列表-特价专区
    public static final String SHOPLIST = BASE_URL + "app/shop/list.do";
    //特价商品购买查询
    public static final String PAYTEJIA = BASE_URL + "myapp/pay/buygoods.do";
    // 特价商品订单详情接口
    public static final String SHOPCONVERT = BASE_URL + "myapp/shopconvert/myinfo.do";
    //特价商品确认收货地址接口
    public static final String UPDATEMYUAID = BASE_URL + "myapp/shopconvert/updateMyUaid.do";
    //特价商品确认收货接口
    public static final String UPDATEMYRECEIVE = BASE_URL + "myapp/shopconvert/updateMyReceive.do";
    //特价商品支付列表获取
    public static final String TEJIAPAYLIST = BASE_URL + "myapp/pay/payLsit.do";
    //特价商品支付下单接口
    public static final String TEJIAPAY = BASE_URL + "myapp/shop/pay/createOrderInfo.do";
    //特价下单查询接口
    public static final String TEJIAPAY_LOOK = BASE_URL + "mapp/shop/selectpaystatus.do";
    //特价取消订单
    public static final String TEJIA_QUXIAO = BASE_URL + "myapp/shopconvert/updateMyCancel.do";
    //看帖加经验
    public static final String INVITATION = BASE_URL + "myapp/newsecure/invitation/addexp.do";
    /**
     * -------------------------------------------接口结束--------------------------
     * --------------------
     **/

    // 所需的全部权限
    public static final String[] PERMISSIONS_READ_PHONE_STATE = new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE};// 读取电话状态权限和读写权限
    public static final String[] PERMISSIONS_CAMERA = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};// 拍照打开相机权限和读写权限
    public static final String[] PERMISSIONS_WRITE_EXTERNAL_STORAGE = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};// 读写权限

    public static final int REQUEST_PERMISSIONS_CODE_99999 = 1000; // 请求码1000
    public static final int REQUEST_PERMISSIONS_CODE_99998 = 1001; // 请求码1001

    public static final int NORMAL_OPENTIME_DELAY = 2000;//开奖延迟
    public static final int PK_OPENTIME_DELAY = 1000;//开奖延迟
    public static final String SYSTEM_FLAG = "android";// 系统标识
    public static final int VOLLEY_TIME_OUT = 10000;// volley请求超时
    public static final int FRAGMENT_LOAD_TIME = 180000;// FRAGMENT翻页刷新频率 60秒
    public static final int FRAGMENT_REPEAT_LOAD_TIME = 2000;// FRAGMENT翻页重复刷新频率 2秒
    public static final long fragmentRefreshInterval = 800;// FRAGMENT延迟加载时间1秒
    public static final long fragmentRefreshFast = 100;// MyFragment延迟加载时间1毫秒
    public static final String MID = "MID";// 消息ID
    public static final String IPTID = "IPTID";
    public static final String GCODE = "GCODE";
    public static final String GOODS_TYPE = "GOODS_TYPE";
    public static final String LONGITUDE = "Longitude";//经度
    public static final String LATITUDE = "Latitude";//纬度
    public static final String NEW_GOODS_SHOPS = "new_goods_shops";
    public static final String LIMIT_NUM = "限制字数";
    public static final String UPDATE_PSD = "修改密码";
    public static final String SET_PSD_TYPE = "设置密码页面标识";
    public static final String REGISTER_USE = "注册页面";
    public static final String FORGETPSW_TYPE = "忘记密码";
    public static final String LOGIN_TYPE = "登录页面";
    public static final String SIGNA_SHARE = "signa_share";
    public static final String HEIGHT_TITLE = "gaodu";//首页Behavior动态高度标识
    public static final String HEIGHT = "HEIGHT";
    public static final String HEIGHT1 = "HEIGHT1";//首页Behavior高度-120
    public static final String HEIGHT2 = "HEIGHT2";//首页Behavior高度-120
    public static final String HEIGHT3 = "HEIGHT3";
    public static final String HEIGHT4 = "HEIGHT4";
    public static final String HEIGHT5 = "HEIGHT5";
    public static final String HEIGHT6= "HEIGHT6";
    public static final String HEIGHT7= "HEIGHT7";
    public static final String HEIGHT8= "HEIGHT8";
    public static final String HEIGHT9= "HEIGHT9";
    public static final String HEIGHT10= "HEIGHT10";
    public static final String HEIGHT11= "HEIGHT11";
    public static final String HEIGHT12= "HEIGHT12";
    public static final String HEIGHT13= "HEIGHT13";
    public static final String HEIGHT14= "HEIGHT14";
    public static final String GOLD = "鲜花";
    public static final String PHONE_NUMBER = "phone_number";// 手机号
    public static final String CHECK_CODE = "check_code";// 验证码
    public static final String GCID = "GCID";// 商品类别ID
    public static final String GCNAME = "GCNAME";// 商品类别名称
    public static final String GCNAME_URL = "GCNAMEURL";// 商品类别连接
    public static final String PLAYID = "PLAYID";// 玩法ID
    public static final String AIID = "AIID";// 期次ID
    public static final String AID = "AID";// 活动ID
    public static final String GID = "GID";// 商品ID
    public static final String WCID = "WCID";// 中奖详情ID
    public static final String VWCID = "VWCID";//
    public static final String USERID = "UID";// 用户ID
    public static final String GPID = "GPID";// 价格类别ID
    public static final String SOID = "SOID";// 晒单ID
    public static final String REDLIST = "REDLIST";// 价格类别ID
    public static final String COUNTPART = "COUNTPART";// 总分数
    public static final String JOINAMOUNT = "JOINAMOUNT";// 已经参与分数
    public static final String MONEY = "MONEY";// 支付金额
    public static final String ISHAVE = "ISHAVE";// 是否有新的一期
    public static final String PAGEON = "pageon";// 已经参与分数
    public static final String BADU_PUSH = "BADU_PUSH";// 百度推送实体
    public static final String FRAGMENT_TIME = "_fragment_load_date";// fragment刷新标识
    public static final String TITLE = "TITLE";
    public static final String URL = "URL";
    public static final String AINDEXID = "AINDEXID";
    public static final String ISCHILD = "ISCHILD";
    public static final String ISAUTOPOPUP = "ISAUTOPOPUP";
    public static final String CHANNELID = "channelid";
    public static final String PARAM = "PARAM";
    public static final String PUSH_KEY = "push_key";
    public static final String PUSH_SCREENSHOT = "push_screenshot";
    public static final String GOODS_PLAY_TYPE = "GOODS_PLAY_TYPE";
    public static final String CODE_ENUM = "CODE_ENUM";
    public static final String STOPNUM = "STOPNUM";
    public static final String QICI = "QICI";
    public static final String TIME = "TIME";
    public static final String CHOOSE = "CHOOSE";
    public static final String PRICE = "PRICE";
    public static final String WIN_PUSH_SHARE = "win_push_share";
    public static final String WIN_INFO_SHARE = "win_info_share";
    public static final String AFTER_NUM = "afterNum";
    public static final String TOTAL_PRICE = "totalPrice";
    public static final String DEFAULT_USER_NAME = "用户";

    // 附近的人常量
    public static final String LOCATION_STATUS_INIT = "init";
    public static final String LOCATION_STATUS_FAIL = "error";
    public static final String LOCATION_STATUS_CHECK = "check";
    public static final String LOCATION_STATUS_ERROR = "error";
    public static final String LOCATION_STATUS_SUCCESS = "success";
    public static final String LOCATION_STATUS = "location_status";

    public static final int ACTIVITY_FOR_RESULT_FLAG_0 = 0;// 发送请求
    public static final int ACTIVITY_FOR_RESULT_FLAG_1 = 1;// 请求返回成功
    public static final int ACTIVITY_FOR_RESULT_FLAG_2 = 2;// 请求返回失败


    public static int HomeFragment = 0;
    public static int RaidersFragment = 1;
    public static int InvestmentFragment =2;
    public static int QuizMyFragment = 3;
    /**
     * 登录统一处理标识
     */
    public static String MyFragment = "0";//我的页面
    public static String HuiYuanKa = "1";//会员卡页面
    public static String LiQuan = "2";//礼券页面
    public static String MessageList = "3";//消息列表页面

    public static final String WINCODE_1 = "10000001";//1
    public static final String WINCODE_2 = "10000002";//2
    public static final String WINCODE_3 = "10000003";//3
    public static final String WINCODE_4 = "10000004";//4

    public static final String WINCODE_SMALL = "10000001";//小
    public static final String WINCODE_BIG = "10000002";//大
    public static final String FINISH = "finish";//true关闭整个web页,false只关闭当前web页

    /**
     * 分享参数大全
     */
    public static String SHAER_TITLE = "微语";
    public static String SHAER_CONTENT = "我正在使用“微语”，最好的APP要分享给最好的你";
    public static String SHAER_IMGURL = "";//图片地址传空，可调用第三方平台的默认会有图标
    // 分享链接
    public static final String SHAREURL = BASE_URL + "app/invitation/share.html";
    // 分享链接商品详情
    public static final String SHAREURL1 = BASE_URL + "download.html";
    // 推送类型
    public enum ePushType {
        baidu, xiaomi
    }

    // 打版本标记
    public enum eSeverUrlType {
        release, beta, virtual, other
    }

    // 分享帖子详情地址
    public static  String WANGZHI ="";
    // 版本类型
    public enum eVersionType {
        onebuy, virtual
    }
}
