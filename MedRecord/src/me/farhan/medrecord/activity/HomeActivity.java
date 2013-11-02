package me.farhan.medrecord.activity;

import me.farhan.medrecord.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends TopActivity 
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
	}

	public void onClickWhoToCall(View v)
	{
		startActivity(new Intent(activity, me.farhan.medrecord.activity.WhoToCallEditActivity.class));
		
	}
}
