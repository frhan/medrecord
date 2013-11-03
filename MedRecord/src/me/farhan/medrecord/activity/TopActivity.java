package me.farhan.medrecord.activity;

import me.farhan.medrecord.R;
import android.app.Activity;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;


public abstract class TopActivity extends SherlockFragmentActivity {

	protected Activity activity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top);
		activity = TopActivity.this;
	}

}
