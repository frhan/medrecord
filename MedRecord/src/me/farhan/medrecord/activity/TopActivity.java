package me.farhan.medrecord.activity;

import me.farhan.medrecord.R;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public abstract class TopActivity extends FragmentActivity {

	protected Activity activity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top);
		activity = TopActivity.this;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.top, menu);
		return true;
	}

}
