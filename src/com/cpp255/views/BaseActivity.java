/*******************************************************************************
 * Copyright 2014 JiangDaoKai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.cpp255.views;

import com.example.android_cpp255_views.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.OnGestureListener;

public class BaseActivity extends Activity implements OnGestureListener{
	private static final float VELOCITY_X = 50.0f;
	private GestureDetector mDetector;
	private int mFlingWidth;
	@Override public void onCreate(Bundle saveInstanceState){
		super.onCreate(saveInstanceState);
		mFlingWidth = this.getWindowManager().getDefaultDisplay().getWidth() / 5;
		mDetector = new GestureDetector(this);
	}
	
	@Override public boolean dispatchTouchEvent(MotionEvent event) {
		super.dispatchTouchEvent(event);
		return mDetector.onTouchEvent(event);
	}

	@Override public void onBackPressed() {
		super.onBackPressed();	
		overridePendingTransition(R.anim.slide_in_left
				, R.anim.slide_out_right);
	}
	
	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		if(e2.getX() - e1.getX() > mFlingWidth
				&& Math.abs(velocityX) > VELOCITY_X) {
			finish();
			overridePendingTransition(R.anim.slide_in_left
					, R.anim.slide_out_right);
		}
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
