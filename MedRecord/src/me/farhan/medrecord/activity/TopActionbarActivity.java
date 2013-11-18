package me.farhan.medrecord.activity;

import me.farhan.medrecord.R;
import me.farhan.medrecord.db.DatabaseManager;
import android.app.Activity;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;


public abstract class TopActionbarActivity extends SherlockFragmentActivity 
{
	protected static final String TAG = TopActionbarActivity.class.getName();
	protected Activity activity;
	protected ActionBar actionBar;
	protected DatabaseManager dbManager;
	protected Menu menu;

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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			break;

		default:
			break;
		}
		return true;
	}
}
