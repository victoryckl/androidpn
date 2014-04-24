/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.androidpn.demoapp;

import org.androidpn.client.ServiceManager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * This is an androidpn client demo application.
 * 
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class DemoAppActivity extends Activity {
	private static final String TAG = DemoAppActivity.class.getSimpleName();
	private ServiceManager mServiceManager;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("DemoAppActivity", "onCreate()...");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        init();
    }

	private void init() {
		findViewById(R.id.btn_login).setOnClickListener(mClickListener);
		findViewById(R.id.btn_logout).setOnClickListener(mClickListener);
		findViewById(R.id.btn_settings).setOnClickListener(mClickListener);
	}
	
	private OnClickListener mClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_login:
		        // Start the service
		        mServiceManager = new ServiceManager(DemoAppActivity.this);
		        mServiceManager.setNotificationIcon(R.drawable.notification);
		        mServiceManager.startService();
				break;
			case R.id.btn_logout:
				if (mServiceManager != null) {
					mServiceManager.stopService();
					mServiceManager = null;
				}
				break;
			case R.id.btn_settings:
				ServiceManager.viewNotificationSettings(DemoAppActivity.this);
				break;
			default:
				break;
			}
		}
	};
}