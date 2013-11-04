package me.farhan.medrecord.activity;

import me.farhan.medrecord.R;
import me.farhan.medrecord.db.DatabaseManager;
import android.app.Activity;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;


public abstract class TopActionbarActivity extends SherlockFragmentActivity 
{
	protected static final String TAG = TopActionbarActivity.class.getName();
	protected Activity activity;
	protected ActionBar actionBar;
	protected DatabaseManager dbManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top);

		activity = TopActionbarActivity.this;
		actionBar = getSupportActionBar();
		dbManager = DatabaseManager.getInstance(activity);
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	protected void onResume() {
		super.onResume();
		dbManager.open();
	}

	@Override
	protected void onPause() {
		super.onPause();
		dbManager.close();
	}

	//	@Override
	//	protected void onDestroy() 
	//	{
	//		super.onDestroy();
	//		dbManager.close();
	//	}
}
