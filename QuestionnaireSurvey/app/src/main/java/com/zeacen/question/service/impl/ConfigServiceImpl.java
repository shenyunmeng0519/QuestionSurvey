package com.zeacen.question.service.impl;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.zeacen.question.dao.SQLHelper;
import com.zeacen.question.service.ConfigService;

import java.util.HashMap;
import java.util.Map;

public class ConfigServiceImpl implements ConfigService {
	private SQLHelper helper = null;

	public ConfigServiceImpl(Context context) {
		helper = new SQLHelper(context);
	}

	@Override
	public boolean addConfig(String name, String value) {
		boolean flag = false;
		SQLiteDatabase database = null;
		long id = -1;
		try {
			database = helper.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put(SQLHelper.CONFIGNAME, name);
			values.put(SQLHelper.CONFIGVALUE, value);
			id = database.insert(SQLHelper.TABLE_CONFIG, null, values);
			flag = (id != -1 ? true : false);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return flag;
	}
	
	
	@Override
	public boolean updateConfig(ContentValues values, String whereClause,
								String[] whereArgs) {
		boolean flag = false;
		SQLiteDatabase database = null;
		int count = 0;
		try {
			database = helper.getWritableDatabase();
			
			count = database.update(SQLHelper.TABLE_CONFIG, values, whereClause, whereArgs);
			
			
			flag = (count > 0 ? true : false);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return flag;
	}

	@Override
	public Map<String, String> viewConfig(String selection,
										  String[] selectionArgs) {
		SQLiteDatabase database = null;
		Cursor cursor = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			database = helper.getReadableDatabase();
			cursor = database.query(true, SQLHelper.TABLE_CONFIG, null, selection,
					selectionArgs, null, null, null, null);
			
			
			
			int cols_len = cursor.getColumnCount();
			cursor.moveToNext();
			for (int i = 0; i < cols_len; i++) {
				String cols_name = cursor.getColumnName(i);
				String cols_values = cursor.getString(cursor.getColumnIndex(cols_name));
				if (cols_values == null) {
					cols_values = "";
				}
				map.put(cols_name, cols_values);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return map;
	}
	
	@Override
	public void clearAllCache(){
		//清空用户信息后，清除相关该用户信息
	}
}
