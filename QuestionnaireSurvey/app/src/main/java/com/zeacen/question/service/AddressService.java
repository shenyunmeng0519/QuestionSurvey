package com.zeacen.question.service;

import android.content.ContentValues;

import org.json.JSONArray;

import java.util.List;
import java.util.Map;


public interface AddressService {
	
	Map<String, String> viewAddressName(String selection, String[] selectionArgs);
	
	List<Map<String,Object>> getAddressData(String selection,
											String[] selectionArgs);
	
	boolean addAddress(JSONArray jsonArray);
	
	boolean updateAddress(ContentValues values, String whereClause,
						  String[] whereArgs);

	Map<String, String> viewAddress(String selection,
									String[] selectionArgs);
	
	boolean deleteAddress();
	
	void clearAllCache();
}
