package me.farhan.medrecord.activity;


import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import me.farhan.medrecord.R;
import me.farhan.medrecord.db.Caller;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class WhoToCallEditActivity extends TopActionbarActivity
{
	private TextView tvName;
	private TextView tvRelation;
	private TextView tvPhone1;
	private TextView tvPhone2;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.who_to_call_edit);

		init();
	}

	private void init() 
	{
		actionBar.setTitle(getResources().getString(R.string.btn_who_to_call));
		tvName = (TextView) findViewById(R.id.tv_call_name);
		tvRelation = (TextView) findViewById(R.id.tv_call_relation);
		tvPhone1 = (TextView) findViewById(R.id.tv_call_phone1);
		tvPhone2 = (TextView) findViewById(R.id.tv_call_phone2);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getSupportMenuInflater().inflate(R.menu.post_edit, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		if(item.getItemId() == R.id.action_save)
		{
			saveToDb();			
		}
		
		return super.onOptionsItemSelected(item);
	}

	private void saveToDb()
	{

		long id = dbManager.insertCaller(new Caller(tvName.getText().toString(), tvRelation.getText().toString(), 
				tvPhone1.getText().toString(), tvPhone2.getText().toString()));
		Log.i(TAG, "DB id"+id);
		finish();
	}
}
