package net.numa08.naptimer;

import net.numa08.naptimer.widget.RingConfigDialog;
import net.numa08.naptimer.widget.RingConfigDialog.RingConfigDialogListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class NappTimer extends Activity implements RingConfigDialogListener{
	
	private static final String PREFERENCE_KEY = NappTimer.class.getPackage().getName() + ".SHARED_PREFERENCE";
	
	private static enum RingConfigExtra{
		IsRingAlerm(NappTimer.class.getPackage().getName() + ".PREFERENCE_IS_RING_ALERM"),
		IsVibrat(NappTimer.class.getPackage().getName() + ".PREFERENCE_IS_VIBRAT"),
		;
		
		private String key;
		private RingConfigExtra(String key){
			this.key = key;
		}
		
		@Override
		public String toString() {
			return this.key;
		}
	}
	
	private static final long serialVersionUID = -9072959517189184730L;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_napp_timer);
	}
	
	public void clickConfigButton(View view){
		final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
		final Fragment prevDialog = getFragmentManager().findFragmentByTag(RingConfigDialog.IDENTIFIER);
		if(prevDialog != null){
			fragmentTransaction.remove(prevDialog);
		}
		fragmentTransaction.addToBackStack(null);
		
		final SharedPreferences pref = getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
		final boolean isRingAlerm = pref.getBoolean(RingConfigExtra.IsRingAlerm.toString(), true);
		final boolean isVibrat = pref.getBoolean(RingConfigExtra.IsVibrat.toString(), true);
		final RingConfigDialog dialog = RingConfigDialog.newInstance(this,isRingAlerm,isVibrat);
		dialog.show(fragmentTransaction, RingConfigDialog.IDENTIFIER);
	}
	
	public void clickNeruButton(View view){}

	@Override
	public void onClickOnWithChangeConfig(RingConfigDialog dialog,boolean isRingAlerm, boolean isVibrat) {
		dialog.dismiss();
		getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE).edit()
						.putBoolean(RingConfigExtra.IsRingAlerm.toString(), isRingAlerm)
						.putBoolean(RingConfigExtra.IsVibrat.toString(), isVibrat)
						.commit();
	}
	
}
