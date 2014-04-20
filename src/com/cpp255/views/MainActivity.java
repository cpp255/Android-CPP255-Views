package com.cpp255.views;


import com.example.android_cpp255_views.R;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends BaseActivity 
	implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setContentView(R.layout.activity_main);
		getWindow().findViewById(R.id.back_bt).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
		case R.id.back_bt:
			Intent intent = new Intent(MainActivity.this, Test2Activity.class);
			startActivity(intent);
			break;
		}
	}

	@Override
	public void openNewActivity() {
		Intent intent = new Intent(MainActivity.this, Test2Activity.class);
		startActivity(intent);
	}
}
