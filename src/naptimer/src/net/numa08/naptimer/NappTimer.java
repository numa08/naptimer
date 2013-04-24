package net.numa08.naptimer;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class NappTimer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_napp_timer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.napp_timer, menu);
		return true;
	}

}
