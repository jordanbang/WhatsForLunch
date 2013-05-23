package com.jordanbang.whatsforlunch;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RestaurantHelper extends SQLiteOpenHelper{

	private static final String DATABASE_NAME = "WhatsForLunch.db";
	private static final int DATABASE_VERSION = 1;
	public static final String TABLE_RESTAURANTS = "restaurants";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_RESTNAME = "name";
	
	String REST_DATABASE_CREATE = "create table restaurants(_id integer primary key autoincrement, name text not null);";
	
	public RestaurantHelper(Context c){
		super (c, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(REST_DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub	
	}
}
