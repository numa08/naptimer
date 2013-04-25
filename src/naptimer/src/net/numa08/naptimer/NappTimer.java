package net.numa08.naptimer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class NappTimer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_napp_timer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.napp_timer, menu);
		return true;
	}
	
	public void clickConfigButton(View view){}
	
	public void clickNeruButton(View view){}
}
