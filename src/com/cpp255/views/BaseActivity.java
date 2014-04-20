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


import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.OnGestureListener;

public abstract class BaseActivity extends AnimationActivity implements OnGestureListener{
	private static final float VELOCITY_X = 50.0f;
	private GestureDetector mDetector;
	private int mFlingWidth;
	@Override
	protected void onCreate(Bundle saveInstanceState){
		super.onCreate(saveInstanceState);
		mFlingWidth = this.getWindowManager().getDefaultDisplay().getWidth() / 5;
		mDetector = new GestureDetector(this);
	}
	
	@Override public boolean dispatchTouchEvent(MotionEvent event) {
		super.dispatchTouchEvent(event);
		return mDetector.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		float xFrom = e1.getX();
		float xTo = e2.getX();
		float yFrom = e1.getY();
		float yTo = e2.getY();
		
		if(Math.abs(xFrom - xTo) > mFlingWidth && Math.abs(velocityX) > VELOCITY_X) {
			if(Math.abs(xFrom - xTo) >= Math.abs(yFrom - yTo)) {
				if(xFrom < xTo) {
					finish();
				} else {
					openNewActivity();
				}
				return true;
			} 
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
	
	/**
	 *   向左滑动，打开新的activity
	 */
	public abstract void openNewActivity();

}
