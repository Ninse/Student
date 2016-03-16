package comnine.student;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;

public class Splash extends Activity{

	
//	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
	
	//	mp=MediaPlayer.create(this,R.raw.music);
	//	mp.start();
	Thread timer =new Thread(){
		public void run(){
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				Intent openMainActivity=new Intent("android.intent.action.MENU");
				startActivity(openMainActivity);
			}
		}
	};
	timer.start();
	
	}

	@Override
	protected void onPause() {
		// TODO 自动生成的方法存根
		super.onPause();
	//	mp.release();
		finish();
	}

}
