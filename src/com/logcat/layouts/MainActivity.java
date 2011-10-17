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

		addActivityButton("Inefficient Heirarchy with LinearLayout", R.layout.inefficient_linearlayout);
		addActivityButton("Efficient Heirarchy with RelativeLayout", R.layout.efficient_relativelayout);
		addActivityButton("Layering Views with RelativeLayout", R.layout.layer_views);
		addActivityButton("Weighted Buttons", R.layout.weighted_buttons);
		addActivityButton("Overlapping Views", R.layout.overlapping_views);
		addActivityButton("Overlapping Views (Fixed)", R.layout.overlapping_views_fixed);
	}

	private void addActivityButton(final String name, final int layoutId) {
		Button button = new Button(this);
		button.setText(name);

		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), LayoutActivity.class);
				intent.putExtra(LayoutActivity.EXTRA_LAYOUT, layoutId);
				intent.putExtra(LayoutActivity.EXTRA_TITLE, name);
				startActivity(intent);
			}
		});

		mContainer.addView(button);
	}
}
