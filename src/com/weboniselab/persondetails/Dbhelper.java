package com.weboniselab.persondetails;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Dbhelper extends SQLiteOpenHelper {
	public static final String TABLE_PERSON = "person";
	public static final String TABLE_PERSON_INFO = "personinfo";
	private static final String DATABASE_NAME = "person.db";
	private static final int DATABASE_VERSION = 1;
    public static final String COLUMN_NAME = "name";
	public static final String COLUMN_AGE = "age";
	 SQLiteDatabase database;
	
	
  
	
	public Dbhelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase database) 
	{
	
		database.execSQL("CREATE TABLE person(name TEXT PRIMARY KEY,"+ "age INTEGER );");
		database.execSQL("CREATE TABLE personinfo(name TEXT  PRIMARY KEY,"+ "address TEXT,"+ "age INTEGER );");	
	}
				
@Override
public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
// TODO Auto-generated method stub

	}

}
