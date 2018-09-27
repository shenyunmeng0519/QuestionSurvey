package com.zeacen.question.service.impl;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.zeacen.question.dao.SQLHelper;
import com.zeacen.question.service.StorageService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageServiceImpl implements StorageService {
	private SQLHelper helper = null;
	public StorageServiceImpl(Context context) {
		helper = new SQLHelper(context);
	}

	@Override
	public boolean addStorage(Map<String,Object> mapParam) {
		boolean flag = false;
		SQLiteDatabase database = null;
		long id = -1;
		try {
			database = helper.getWritableDatabase();
			ContentValues values = null;
			if(mapParam!=null){
				values = new ContentValues();
				for(Map.Entry<String,Object> entry : mapParam.entrySet()){
					if(entry.getValue()==null) continue;
					if(entry.getValue() instanceof String) {
						values.put(entry.getKey(), entry.getValue().toString());
					}else if(entry.getValue() instanceof  Integer)
						values.put(entry.getKey(), Integer.parseInt(entry.getValue().toString()));
				}
			}
			id = database.insert(SQLHelper.TABLE_INVITATION_STORAGE, null, values);
			flag = (id != -1 ? true : false);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return flag;
	}
	
	
	@Override
	public boolean updateStorage(Map<String,Object> mapParam, String whereClause,
								String[] whereArgs) {
		boolean flag = false;
		SQLiteDatabase database = null;
		int count = 0;
		try {
			database = helper.getWritableDatabase();
			ContentValues values = null;
			if(mapParam!=null){
				values = new ContentValues();
				for(Map.Entry<String,Object> entry : mapParam.entrySet()){
					if(entry.getValue()==null) continue;
					if(entry.getValue() instanceof String) {
						values.put(entry.getKey(), entry.getValue().toString());
					}else if(entry.getValue() instanceof  Integer)
						values.put(entry.getKey(), Integer.parseInt(entry.getValue().toString()));
				}
			}
			count = database.update(SQLHelper.TABLE_INVITATION_STORAGE, values, whereClause, whereArgs);
			flag = (count > 0 ? true : false);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return flag;
	}

	@Override
	public boolean deleteStorage(String whereClause,String[] whereArgs) {
		boolean flag = false;
		SQLiteDatabase database = null;
		int count = 0;
		try {
			database = helper.getWritableDatabase();
			count = database.delete(SQLHelper.TABLE_INVITATION_STORAGE,whereClause,whereArgs);
			flag = (count > 0 ? true : false);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return flag;
	}

	@Override
	public Map<String, String> viewStorage(String selection,
										   String[] selectionArgs) {
		SQLiteDatabase database = null;
		Cursor cursor = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			database = helper.getReadableDatabase();
			cursor = database.query(true, SQLHelper.TABLE_INVITATION_STORAGE, null, selection,
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
	public List<Map<String, String>> listStorage(String selection,
				String[] selectionArgs) {
		SQLiteDatabase database = null;
		Cursor cursor = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			database = helper.getReadableDatabase();
			cursor = database.query(true, SQLHelper.TABLE_INVITATION_STORAGE, null, selection,
					selectionArgs, null, null, null, null);
			int cols_len = cursor.getColumnCount();
			while (cursor.moveToNext()) {
				Map<String, String> map = new HashMap<>();
				for (int i = 0; i < cols_len; i++) {
					String cols_name = cursor.getColumnName(i);
					String cols_values = cursor.getString(cursor.getColumnIndex(cols_name));
					if (cols_values == null) {
						cols_values = "";
					}
					map.put(cols_name, cols_values);
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return list;
	}
	
	@Override
	public boolean clearAllCache(){
		boolean flag = false;
		SQLiteDatabase database = null;
		int count = 0;
		try {
			database = helper.getWritableDatabase();
			count = database.delete(SQLHelper.TABLE_INVITATION_STORAGE,null,null);
			flag = (count > 0 ? true : false);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (database != null) {
				database.close();
			}
		}
		return flag;
	}
}
