package com.logcat.layouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends Activity {

	ViewGroup mContainer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mContainer = (ViewGroup) findViewById(R.id.container);
	}

	private void addActivityButton(String name, final int layoutId) {
		Button button = new Button(this);
		button.setText(name);

		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), LayoutActivity.class);
				intent.putExtra(LayoutActivity.EXTRA_LAYOUT, layoutId);
				startActivity(intent);
			}
		});

		mContainer.addView(button);
	}
}
