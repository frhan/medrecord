package me.farhan.medrecord.activity;


import com.actionbarsherlock.view.Menu;

import me.farhan.medrecord.R;
import android.os.Bundle;

public class WhoToCallEditActivity extends TopActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.who_to_call_full_row);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getSupportMenuInflater().inflate(R.menu.post_edit, menu);
		return true;
	}

}
