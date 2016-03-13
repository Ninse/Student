package comnine.student;

import java.util.ArrayList;
import java.util.List;

import com.terry.R;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Add extends Activity{
	Button Add;
	Button Exi;
	private dbHelper db;
	private EditText name;
	private EditText number;
	private EditText chinese;
	private EditText math;
	private EditText english;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		name=(EditText)findViewById(R.id.Name);
		number=(EditText)findViewById(R.id.Number);
		chinese=(EditText)findViewById(R.id.Chinese);
		math=(EditText)findViewById(R.id.Math);
		english=(EditText)findViewById(R.id.English);
		Add=(Button)findViewById(R.id.add);
		Add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				db.insert( name.getText().toString(), Integer.valueOf(number.getText()).toString(),chinese.getText().toString(),math.getText().toString(),english.getText().toString());
				
			}
		});//
	}


}
