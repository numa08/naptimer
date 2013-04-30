package net.numa08.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public abstract class DrumpickerAdapter<T> extends ArrayAdapter<T> {

	
	private ArrayList<T> mDataList;
	
	public DrumpickerAdapter(Context context,List<T> dataList) {
		super(context, 0);
		
		mDataList = new ArrayList<T>(dataList.size() * 10);
		
		for(int i = 0; i < 10; i ++){
			for(T data : dataList){
				mDataList.add(data);
			}
		}
	}

	@Override
	abstract public View getView(int position, View convertView, ViewGroup parent);
	
	
	
}
