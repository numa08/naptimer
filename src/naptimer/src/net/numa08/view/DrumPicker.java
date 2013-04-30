package net.numa08.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class DrumPicker extends RelativeLayout {

	private final ListView mListView;
	private DrumpickerAdapter<?> mAdapter;
	
	

	public DrumPicker(Context context) {
		this(context,null);
	}
	
	public DrumPicker(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}
	
	public DrumPicker(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		mListView = new ListView(context);
		final LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, 0);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		mListView.setLayoutParams(layoutParams);
		addView(mListView);
	}

	public void setAdapter(DrumpickerAdapter<?> adapter){
		mAdapter = adapter;
		mListView.setAdapter(mAdapter);
		mListView.invalidate();
	}
	
	public DrumpickerAdapter<?> getAdapter(){
		return mAdapter;
	}
	
}
