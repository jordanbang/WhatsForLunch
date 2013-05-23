package com.jordanbang.whatsforlunch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WhatsForLunchMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wfl_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.whats_for_lunch_main, menu);
		return true;
	}

}
