package net.numa08.naptimer;

import net.numa08.naptimer.widget.RingConfigDialog;
import net.numa08.naptimer.widget.RingConfigDialog.RingConfigDialogListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class NappTimer extends Activity implements RingConfigDialogListener{
	
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
		
		final RingConfigDialog dialog = RingConfigDialog.newInstance(this,false,false);
		dialog.show(fragmentTransaction, RingConfigDialog.IDENTIFIER);
	}
	
	public void clickNeruButton(View view){}

	@Override
	public void onClickOnWithChangeConfig(RingConfigDialog dialog,
			boolean isRingAlerm, boolean isVibrat) {}
	
}
