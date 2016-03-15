package comnine.student;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

	Button Add;
	Button Find;
	Button Delect;
	Button Qurry;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		Add=(Button)findViewById(R.id.button1);
		Find=(Button)findViewById(R.id.button2);
		Delect=(Button)findViewById(R.id.button3);
		Qurry=(Button)findViewById(R.id.button4);
		Add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

		Intent openMainActivity=new Intent("android.intent.action.Add");
		startActivity(openMainActivity);   
			}
			}); //打开添加界面
		Find.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

		Intent openMainActivity=new Intent("android.intent.action.Find");
		startActivity(openMainActivity);   
			}
			}); //打开显示界面
		
		Delect.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

		Intent openMainActivity=new Intent("android.intent.action.Delect");
		startActivity(openMainActivity);   
			}
			}); //打开删除界面
		
		
		Qurry.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

		Intent openMainActivity=new Intent("android.intent.action.Qurry");
		startActivity(openMainActivity);   
			}
			}); //打开排序界面
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
