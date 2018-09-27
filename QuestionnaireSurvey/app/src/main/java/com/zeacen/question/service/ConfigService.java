package com.zeacen.question.service;

import android.content.ContentValues;

import java.util.Map;


public interface ConfigService {
	
	boolean addConfig(String name, String value);
	
	boolean updateConfig(ContentValues values, String whereClause,
						 String[] whereArgs);

	Map<String, String> viewConfig(String selection,
								   String[] selectionArgs);
	
	void clearAllCache();
}
