package comnine.student;

import java.util.ArrayList;
import java.util.List;



import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Add extends Activity{
	Button Add;
	Button Exi;
	private dbHelper db;
	private EditText name;
	private EditText number;
	private EditText chinese;
	private Cursor myCursor;
	private EditText math;
	private EditText english;
	private int _id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.add);
		name=(EditText)findViewById(R.id.Name);
		number=(EditText)findViewById(R.id.Number);
		chinese=(EditText)findViewById(R.id.Chinese);
		math=(EditText)findViewById(R.id.Math);
		english=(EditText)findViewById(R.id.English);
		Add=(Button)findViewById(R.id.add);
		Exi=(Button)findViewById(R.id.exit);
		Add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				db.insert( name.getText().toString(), Integer.parseInt(number.getText().toString()),  Integer.parseInt(chinese.getText().toString()),  Integer.parseInt(math.getText().toString()),  Integer.parseInt(english.getText().toString()));
		    	name.setText("");
		    	number.setText("");
		    	chinese.setText("");
		    	math.setText("");
		    	english.setText("");
		    	_id=0;
		    
				
			}
		});//添加操作
		Exi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 finish();
				
			}
		});
		db=new dbHelper(Add.this);
        myCursor=db.select();

	}


}
