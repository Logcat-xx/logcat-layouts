package com.logcat.layouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class LayoutActivity extends Activity {
	public static final String EXTRA_LAYOUT = "extra_layout";
	public static final String EXTRA_TITLE = "extra_title";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		int layoutId = intent.getIntExtra(EXTRA_LAYOUT, 0);
		if (layoutId == 0) {
			Toast.makeText(this, "Need to call LayoutActivity with a layout extra specified!", Toast.LENGTH_LONG)
					.show();
			finish();
		}
		else {
			setContentView(layoutId);
		}

		String title = intent.getStringExtra(EXTRA_TITLE);
		if (title != null && title.length() > 0) {
			setTitle(title);
		}
	}
}
