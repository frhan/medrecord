package me.farhan.medrecord.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseManager {
	private static final String TAG = DatabaseManager.class.getName();
	private static DatabaseManager dbManager = null;
	//the name of your database
	private static String DB_NAME = "medrecord";

	// database version    
	private static final int DATABASE_VERSION = 1;
	private DbHalper dbHelper;
	private static SQLiteDatabase db = null;

	public DatabaseManager(Context context) 
	{
		dbHelper = new DbHalper(context, DB_NAME, null, DATABASE_VERSION);
	}

	public static DatabaseManager getInstance(Context context) 
	{
		if(dbManager == null)
			dbManager = new DatabaseManager(context);

		return dbManager;
	}

	public synchronized void close() {

		if(dbHelper != null)
		{
			db.close(); 
			db = null;
		}
	}	

	public void open()
	{
		if (db == null)
		{
			db = dbHelper.getWritableDatabase();
		}
	}


	public long insertCaller(final Caller caller)
	{
		ContentValues values = new ContentValues();
		values.put("name", caller.name);
		values.put("date_of_birth",caller.birthDay);
		values.put("phone1", caller.phone1);
		values.put("phone2", caller.phone2);
		values.put("relationship", caller.relationship);

		long callerId = db.insert(DbTable.TABLE_WHO_TO_CALL, null, values);
		return callerId;
	}

	public List<Caller> getAllCallers()
	{
		List<Caller> listCallers = new ArrayList<Caller>();
		String selectQuery = "SELECT  * FROM " + DbTable.TABLE_WHO_TO_CALL;
		Log.i(TAG, selectQuery);		 

		Cursor c = db.rawQuery(selectQuery, null);
		if (c.moveToFirst()) {
			do {
				Caller caller = new Caller();
				caller.id = c.getInt(c.getColumnIndex("_id"));
				caller.name = c.getString(c.getColumnIndex("name"));
				caller.relationship = c.getString(c.getColumnIndex("relationship"));
				caller.phone1 = c.getString(c.getColumnIndex("phone1"));
				caller.phone2 = c.getString(c.getColumnIndex("phone2"));

				// adding to todo list
				listCallers.add(caller);
			} while (c.moveToNext());
		}
		c.close();

		return listCallers;
	}



	private class DbHalper extends SQLiteOpenHelper
	{

		public DbHalper(Context context, String name, CursorFactory factory,
				int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) 
		{
			db.execSQL(DbTable.CREATE_TABLE_WHO_TO_CALL);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		{
			Log.i("Upgrading database from version "+ oldVersion + " to "+newVersion,
					" which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS"+DbTable.TABLE_WHO_TO_CALL);
			onCreate(db);
		}

	}


}
