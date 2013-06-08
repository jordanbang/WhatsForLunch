package com.jordanbang.whatsforlunch;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RestaurantDataSource {
	private SQLiteDatabase mDatabase;
	private RestaurantHelper mRestHelper;
	private String[] mColumns = {RestaurantHelper.COLUMN_ID, RestaurantHelper.COLUMN_RESTNAME};
	private int COLUMN_ID = 0;
	private int COLUMN_RESTNAME = 1;
	
	public RestaurantDataSource(Context c){
		mRestHelper = new RestaurantHelper(c);
	}
	
	public void open() throws SQLException{
		mDatabase = mRestHelper.getWritableDatabase();
	}
	
	public void close(){
		mRestHelper.close();
	}
	
	public RestDatabase createRest(String restName){
		ContentValues values = new ContentValues();
		values.put(RestaurantHelper.COLUMN_RESTNAME, restName);
		long insertId = mDatabase.insert(RestaurantHelper.TABLE_RESTAURANTS, null, values);
		Cursor cursor = mDatabase.query(RestaurantHelper.TABLE_RESTAURANTS, null, RestaurantHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
		cursor.moveToFirst();
		RestDatabase newRest = cursorToClass(cursor);
		cursor.close();
		return newRest;
	}
	
	public void deleteRest(RestDatabase rest){
		long id = rest.getId();
		mDatabase.delete(RestaurantHelper.TABLE_RESTAURANTS, RestaurantHelper.COLUMN_ID + " = " + id, null);
	}
	
	public RestDatabase cursorToClass(Cursor cursor){
		RestDatabase rest = new RestDatabase();
		rest.setId(cursor.getLong(COLUMN_ID));
		rest.setName(cursor.getString(COLUMN_RESTNAME));
		return rest;
	}
	
	public List<RestDatabase> getAllRest(){
		List<RestDatabase> rest = new ArrayList<RestDatabase>();
		Cursor cursor = mDatabase.query(RestaurantHelper.TABLE_RESTAURANTS, null, null, null, null, null, "name");
		cursor.moveToFirst();
		while (!cursor.isAfterLast()){
			RestDatabase newRest = cursorToClass(cursor);
			rest.add(newRest);
			cursor.moveToNext();
		}
		cursor.close();
		return rest;
	}
}
