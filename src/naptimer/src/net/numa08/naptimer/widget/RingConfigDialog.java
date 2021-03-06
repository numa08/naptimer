package net.numa08.naptimer.widget;

import java.io.Serializable;

import net.numa08.naptimer.R;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Switch;

public class RingConfigDialog extends DialogFragment implements OnClickListener{
	
	
	public static final String IDENTIFIER = RingConfigDialog.class.getSimpleName();
	private static final String EXTRA_LISTENER = RingConfigDialog.class.getPackage().getName() + ".EXTRA_LISTENER";
	private static final String EXTRA_RING_ALERM = RingConfigDialog.class.getPackage().getName() + ".EXTRA_RING_ALERM";
	private static final String EXTRA_VIBRATO = RingConfigDialog.class.getPackage().getName() + ".EXTRA_VIBRATO";
	
	private RingConfigDialogListener mListener;
	private Switch mRingAlerSwitch;
	private Switch mVibratoSwitch;
	
	public static interface RingConfigDialogListener extends Serializable{
		public void onClickOnWithChangeConfig(RingConfigDialog dialog, boolean isRingAlerm , boolean isVibrato);
	}
	
	public static RingConfigDialog newInstance(RingConfigDialogListener listener, boolean isRingAlerm, boolean isVibrato){
		final Bundle arg = new Bundle();
		arg.putSerializable(EXTRA_LISTENER, listener);
		arg.putBoolean(EXTRA_RING_ALERM, isRingAlerm);
		arg.putBoolean(EXTRA_VIBRATO, isVibrato);
		
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
		layout.findViewById(R.id.dialog_ok_button).setOnClickListener(this);
		mRingAlerSwitch = (Switch)layout.findViewById(R.id.alertm_switch);
		mRingAlerSwitch.setChecked(getArguments().getBoolean(EXTRA_RING_ALERM));
		
		mVibratoSwitch = (Switch)layout.findViewById(R.id.vibe_switch);
		mVibratoSwitch.setChecked(getArguments().getBoolean(EXTRA_VIBRATO));
		return layout;
	}

	@Override
	public void onClick(View v) {
		final boolean isRingAlerm = mRingAlerSwitch.isChecked();
		final boolean isViverate = mVibratoSwitch.isChecked();
		if(mListener == null){
			return;
		}
		mListener.onClickOnWithChangeConfig(this, isRingAlerm, isViverate);
	}
	
}
