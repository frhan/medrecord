package me.farhan.medrecord.activity;

import me.farhan.medrecord.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TopActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.top, menu);
		return true;
	}

}
