package me.farhan.medrecord.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseManager {
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
			dbHelper.close();
			db.close(); 
			dbHelper = null;
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
