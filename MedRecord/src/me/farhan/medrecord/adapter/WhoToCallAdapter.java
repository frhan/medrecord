package me.farhan.medrecord.adapter;

import java.util.List;

import me.farhan.medrecord.R;
import me.farhan.medrecord.db.Caller;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WhoToCallAdapter extends BaseAdapter
{

	private List<Caller> listCaller;
	private Context context;
	private LayoutInflater layoutInflater;

	public WhoToCallAdapter(Context context,List<Caller> listCaller)
	{
		this.context = context;
		this.listCaller = listCaller;
		layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount()
	{
		return listCaller.size();
	}

	@Override
	public Caller getItem(int position) 
	{
		return listCaller.get(position);
	}

	@Override
	public long getItemId(int position) 
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		Caller caller = getItem(position);
		ViewHolder viewHolder = null;
		if(convertView == null)
		{
			convertView = (View) layoutInflater.inflate(R.layout.who_to_call_full_row, null);

			viewHolder = new ViewHolder();
			viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_callee_name);
			viewHolder.tvCallerHeader = (TextView) convertView.findViewById(R.id.tv_caller_panel_header);
			viewHolder.tvRelation = (TextView) convertView.findViewById(R.id.tv_callee_who);
			viewHolder.tvPhone1 = (TextView) convertView.findViewById(R.id.tv_callee_phone1);
			viewHolder.tvPhone2 = (TextView) convertView.findViewById(R.id.tv_callee_phone2);

			convertView.setTag(viewHolder);
		}else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if(viewHolder != null)
		{
			viewHolder.tvName.setText(caller.name);
			viewHolder.tvCallerHeader.setText(caller.relationship);
			viewHolder.tvRelation.setText(caller.relationship);
			if(caller.phone1.length() >0)
				viewHolder.tvPhone1.setText(Html.fromHtml("<u>"+caller.phone1+"</u>"));
			if(caller.phone1.length() >0)
				viewHolder.tvPhone2.setText(Html.fromHtml("<u>"+caller.phone2+"</u>"));
		}
		return convertView;
	}

	class ViewHolder
	{
		TextView tvName;
		TextView tvCallerHeader;
		TextView tvRelation;
		TextView tvPhone1;
		TextView tvPhone2;
	}

}
