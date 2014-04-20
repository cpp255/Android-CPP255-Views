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
import android.content.Intent;
import android.os.Bundle;

public class AnimationActivity extends Activity{
	public enum EnterAnimType {
		leftIn, rightIn, bottomIn
	};
	
	private int slideFromEnterAnim;
	private int slideOutExitAnim;
	private int slideOutEnterAnim;
	private int slideFromExitAnim;
	private EnterAnimType defaultAnimType;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setDefaultAnimType(EnterAnimType.rightIn);
		initAnim();
	}

	protected void initAnim() {
		switch(defaultAnimType) {
		case leftIn:
			slideFromEnterAnim = R.anim.slide_in_left;
			slideFromExitAnim = R.anim.slide_out_right;

			slideOutExitAnim = R.anim.slide_out_left;
			slideOutEnterAnim = R.anim.slide_in_right;
			break;
		case rightIn:
			slideFromEnterAnim = R.anim.slide_in_right;
			slideFromExitAnim = R.anim.slide_out_left;

			slideOutExitAnim = R.anim.slide_out_right;
			slideOutEnterAnim = R.anim.slide_in_left;
			break;
		case bottomIn:
			slideFromEnterAnim = R.anim.slide_in_up;
			slideFromExitAnim = 0;

			slideOutExitAnim = R.anim.slide_out_down;
			slideOutEnterAnim = 0;
			break;
		}
	}

	private void exitAnim() {
		this.overridePendingTransition(slideOutEnterAnim, slideOutExitAnim);
	}

	private void enterAnim() {
		this.overridePendingTransition(slideFromEnterAnim, slideFromExitAnim);
	}

	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		enterAnim();
	}

	@Override
	public void finish() {
		super.finish();
		exitAnim();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		exitAnim();
	}

	public EnterAnimType getDefaultAnimType() {
		return defaultAnimType;
	}

	public void setDefaultAnimType(EnterAnimType defaultAnimType) {
		this.defaultAnimType = defaultAnimType;
		initAnim();
	}

}
