package comnine.student;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Splash extends Activity{

	Button Admit;
	private EditText Password;
//	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		Admit=(Button)findViewById(R.id.button1);
		Password=(EditText)findViewById(R.id.editText1);
      Admit.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			String key=Password.getText().toString();
			if(key.equals("123"))
			{
				Intent openMainActivity=new Intent("android.intent.action.MENU");
				startActivity(openMainActivity);   
			}
			
		}
	});

}
}