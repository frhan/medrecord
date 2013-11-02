package me.farhan.medrecord.activity;


import me.farhan.medrecord.R;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class WhoToCallEditActivity extends TopActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allergy);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.post_edit, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		return super.onOptionsItemSelected(item);
	}
}
