package com.jiaoshan.starfighter;

import com.jiaoshan.starfighter.R;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//no title and full screen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		Runnable r = new Runnable() {
			Handler handler = new Handler();
			@Override
			public void run(){
				StartGoFight();
			}
		};
		
		new Handler().postDelayed(r, SFEngine.GAME_THREAD_DELAY);
		
		
	}
	
	private void StartGoFight() {
		Intent intent = new Intent(SplashActivity.this, SFMenuMainActivity.class);
		SplashActivity.this.startActivity(intent);
		SplashActivity.this.finish();
		
		overridePendingTransition(R.layout.fadein, R.layout.fadeout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
