package me.farhan.medrecord.adapter;

import java.util.List;

import me.farhan.medrecord.db.Caller;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class WhoToCallAdapter extends BaseAdapter
{

	private List<Caller> listCaller;
	private Context context;
	
	public WhoToCallAdapter(Context context,List<Caller> listCaller)
	{
		
	}
	
	@Override
	public int getCount() {
	
		return 0;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}
	

}
