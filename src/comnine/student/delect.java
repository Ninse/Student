package comnine.student;



import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
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

public class delect extends Activity implements OnClickListener{
	private ListView myListView;
	private dbHelper db;
	private Cursor myCursor;
	private int _id;
	Button Exi;
	Button Del;
	private EditText Select;
	SQLiteDatabase da;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根

		super.onCreate(savedInstanceState);
		setContentView(R.layout.delect);
		Exi=(Button)findViewById(R.id.button1);
		Del=(Button)findViewById(R.id.button2);
		Select=(EditText)findViewById(R.id.editText1);
		 myListView=new ListView(this);
	     myListView=(ListView)findViewById(R.id.ListView);
	OpenCreateDB();
	Display();
	//   db=new dbHelper(find.this);
    //   myCursor=db.select();
	Exi.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			 finish();
			
		}
	});
	Del.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Delect();
			Display();
		}
	});
}
    public void OpenCreateDB(){
    	da = openOrCreateDatabase("sqldatas", this.MODE_PRIVATE, null);
    //    db.execSQL("DROP TABLE IF EXISTS students");  
     //  da.execSQL("CREATE TABLE IF NOT EXISTS student (_id INTEGER PRIMARY KEY AUTOINCREMENT, Name text,Number INTEGER, Chinese INTEGER,Math INTEGER, English integer)");
    }
	 public void Display(){
	    	List<String> list=new ArrayList<String>();
	    	Cursor c = da.rawQuery("SELECT * FROM student", null);
	       while (c.moveToNext()) {
	        Student person = new Student();
	       	person._id = c.getInt(c.getColumnIndex("_id"));
	      	person.Name = c.getString(c.getColumnIndex("Name"));
	   	person.Number=c.getInt(c.getColumnIndex("Number"));
	     	person.Chinese=c.getInt(c.getColumnIndex("Chinese"));
	       	person.Math = c.getInt(c.getColumnIndex("Math"));
	      	person.English = c.getInt(c.getColumnIndex("English")); 
	       	String string=""+person._id+"    "+person.Name+"    "+person.Number+"        " +person.Chinese+"      "+person.Math+"     "+person.English;
	       	list.add(string);
	     	Log.d("msg",string);
	        }
	        c.close();
	        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list);
	        myListView.setAdapter(adapter);
	    }
	 public void Delect(){
			da.execSQL("DELETE FROM student WHERE Name=?",new String[]{Select.getText().toString()});
	 }
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		
	}
}