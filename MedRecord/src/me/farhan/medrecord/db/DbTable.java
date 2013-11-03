package me.farhan.medrecord.db;

public class DbTable 
{
	public static final String TABLE_WHO_TO_CALL = "WhoToCall";
	public static final String CREATE_TABLE_WHO_TO_CALL = "CREATE TABLE "+TABLE_WHO_TO_CALL+"(_id INTEGER"
			+ " PRIMARY KEY AUTOINCREMENT NOT NULL,name TEXT,date_of_birth TEXT,phone1 "
			+ " TEXT NOT NULL,phone2 TEXT,relationship TEXT)";
}
