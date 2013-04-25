package net.numa08.naptimer.widget;

import net.numa08.naptimer.R;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RingConfigDialog extends DialogFragment {
	
	public static final String IDENTIFIER = RingConfigDialog.class.getSimpleName();

	public static RingConfigDialog newInstance(){
		return new RingConfigDialog();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		final View layout = inflater.inflate(R.layout.ring_config_dialog, container, false);
		return layout;
	}
}
