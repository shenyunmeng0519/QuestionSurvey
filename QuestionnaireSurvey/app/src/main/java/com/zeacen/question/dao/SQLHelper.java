package com.zeacen.question.dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {
	public static final String DB_NAME = "pasture.db";// 数据库名称
	public static final int VERSION = 1;//版本
	
	public static final String TABLE_GOODS = "goods";//数据表 [用户表]
	public static final String TABLE_CONFIG = "configs";//数据表 [配置]
	public static final String TABLE_ADDRESS = "address";//地址表

	public static final String CONFIGVALUE ="configValue";
	public static final String CONFIGNAME ="configName";
	
	public static final String TABLE_PUSH = "push";//推送表
	public static final String PUSHKEY = "pushKey";
	public static final String PUSHVALUE = "pushValue";
	
	public static final String regionId = "regionId";//地址表
	public static final String regionCode = "regionCode";
	public static final String regionName = "regionName";
	public static final String parentId = "parentId";
	public static final String regionOrder = "regionOrder";
	public static final String regionNamePinYin = "regionNamePinYin";
	public static final String cityIdForBaidu = "cityIdForBaidu";
	
	public static final String currentAddress = "currentAddress";
	public static final String address_version = "address_version";

	public static final String reddotkey = "reddotkey";//红点key
	public static final String reddoturl = "reddoturl";//红点url
	public static final String reddotstate = "reddotstate";//红点state

	public static final String reddot_device = "deviceMark";
	public static final String reddot_user_id = "userId";
	public static final String reddot_id_array = "redDotId";
	public static final String TABLE_RED_PACKET_STATE = "red_packet_state";//我的红包红点提醒

	public static final String TABLE_INVITATION_STORAGE = "invitation_storage";//帖子存储
	
	private Context context;
	public SQLHelper(Context context) {
		super(context, DB_NAME, null, VERSION);
		this.context = context;
	}

	public Context getContext(){
		return context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		//系统字典表
		String sql = "create table if not exists "+TABLE_CONFIG +
				"(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
				CONFIGNAME + " TEXT , " +
				CONFIGVALUE + " TEXT)";
		db.execSQL(sql);

		//帖子草稿箱存储表
		db.execSQL(createStorage());

		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('userid', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('ugid', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('nickname', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('mobile', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('password', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('securekey', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('userheadpath', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('addtime', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('lastlogintime', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('logintime', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('ipaddress', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('gold', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('device', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('devicecode', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('payPlatform', '')";
		db.execSQL(sql);
		sql = "INSERT INTO " + TABLE_CONFIG + "(" + CONFIGNAME + "," + CONFIGVALUE+ ") VALUES('contactMobile', '')";
		db.execSQL(sql);
	}
	
	public void createAddress(){
		SQLiteDatabase db = this.getWritableDatabase();
		String sql = "create table if not exists "+TABLE_ADDRESS +
				"("+regionId+" INTEGER PRIMARY KEY, " +
				regionCode + " TEXT , " +
				regionName + " TEXT , " +
				parentId + " INTEGER , " +
				regionNamePinYin + " TEXT , " +
				cityIdForBaidu + " INTEGER)";
		db.execSQL(sql);
	}

	/**
	 * 帖子草稿箱存储表
	 * @return
	 */
	public String createStorage(){
		String sql = "create table if not exists "+TABLE_INVITATION_STORAGE +
				"(id INTEGER PRIMARY KEY AUTOINCREMENT," +//主键自增
				"userid INTEGER," +//用户ID
				"title varchar(50)," +//帖子标题
				"imgspath TEXT, " +//图片地址
				"yuanimgpath TEXT, " +//原图片地址
				"content TEXT, " +//帖子内容
				"addtime INTEGER, " +//添加时间
				"circlename varchar(50), " +//圈子名称
				"width TEXT, " +//图片的宽
				"height TEXT, " +//图片的高
				"circleid INTEGER)";//所属圈子ID
		return sql;
	}
	public void createRedPacketState() {
		SQLiteDatabase db = this.getWritableDatabase();
		String sql = "create table if not exists " + TABLE_RED_PACKET_STATE +
				"(" + reddot_device + " TEXT, "
				+ reddot_user_id + " TEXT, "
				+ reddot_id_array + " TEXT, "
				+ "primary key (" + reddot_device + "," + reddot_user_id + "))";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onCreate(db);
	}

}
