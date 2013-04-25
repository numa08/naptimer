package net.numa08.naptimer.widget;

import java.io.Serializable;

import net.numa08.naptimer.R;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RingConfigDialog extends DialogFragment {
	
	
	public static final String IDENTIFIER = RingConfigDialog.class.getSimpleName();
	private static final String EXTRA_LISTENER = RingConfigDialog.class.getPackage().getName() + ".EXTRA_LISTENER";
	
	private RingConfigDialogListener mListener;
	
	public static interface RingConfigDialogListener extends Serializable{
		public void onClickOnWithChangeConfig(RingConfigDialog dialog, boolean isRingAlerm , boolean isVibrat);
	}
	
	public static RingConfigDialog newInstance(RingConfigDialogListener listener){
		final Bundle arg = new Bundle();
		arg.putSerializable(EXTRA_LISTENER, listener);
		
		RingConfigDialog dialog =  new RingConfigDialog();
		dialog.setArguments(arg);
		return dialog;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Bundle arg = getArguments();
		mListener = (RingConfigDialogListener) arg.getSerializable(EXTRA_LISTENER);
		
		final int style = DialogFragment.STYLE_NO_TITLE;
		final int theme = android.R.style.Theme_Holo_Light_Dialog_MinWidth;
		
		setStyle(style, theme);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		final View layout = inflater.inflate(R.layout.ring_config_dialog, container, false);
		return layout;
	}
}
