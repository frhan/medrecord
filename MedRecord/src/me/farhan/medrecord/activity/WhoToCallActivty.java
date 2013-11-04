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

public class WhoToCallActivty extends TopActivity 
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

	private void init() {
		lvCallerList = (ListView)findViewById(R.id.lv_record_list);
		listCallers = new ArrayList<Caller>();
		Caller c = new Caller(1,"Arham Namir Hoassain","Son","123456","5657575");
		Caller c2 = new Caller(2,"Manha Binte Allam bjsbs","Daughter","123456","5657575");
		Caller c3 = new Caller(3,"Forhad Hoassain","Brother","123456","5657575");
		Caller c4 = new Caller(4,"Hamid","Father","123456","5657575");

		listCallers.add(c2);
		listCallers.add(c3);
		listCallers.add(c4);
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
