package com.zeacen.question.service;

import java.util.List;
import java.util.Map;


public interface StorageService {

	boolean addStorage(Map<String, Object> mapParam);

	boolean updateStorage(Map<String, Object> mapParam, String whereClause,
						  String[] whereArgs);

	Map<String, String> viewStorage(String selection,
									String[] selectionArgs);

	List<Map<String, String>> listStorage(String selection,
										  String[] selectionArgs);

	boolean deleteStorage(String whereClause, String[] whereArgs);

	boolean clearAllCache();
}
