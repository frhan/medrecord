package me.farhan.medrecord.activity;

import java.util.ArrayList;
import java.util.List;

import me.farhan.medrecord.R;
import me.farhan.medrecord.adapter.WhoToCallAdapter;
import me.farhan.medrecord.db.Caller;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class WhoToCallActivty extends TopActionbarActivity 
{
	private ListView lvCallerList;
	private List<Caller> listCallers;
	private WhoToCallAdapter whoToCallAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.who_to_call);

		init();
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		List<Caller> dbCallerList = dbManager.getAllCallers();
		whoToCallAdapter.refreshList(dbCallerList);
	}
	
	private void init() 
	{
		
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setTitle(getResources().getString(R.string.btn_who_to_call));
		
		lvCallerList = (ListView)findViewById(R.id.lv_record_list);
		listCallers = new ArrayList<Caller>();
		whoToCallAdapter = new WhoToCallAdapter(activity, listCallers);
		lvCallerList.setAdapter(whoToCallAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getSupportMenuInflater().inflate(R.menu.caller_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch (item.getItemId()) {
		case R.id.action_add:
			startActivity(new Intent(activity, me.farhan.medrecord.activity.WhoToCallEditActivity.class));
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
