package comnine.student;





import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;  
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;

public class Qurry extends Activity implements OnClickListener{
	private ListView myListView;
	private dbHelper db;
	private Cursor myCursor;
	private int _id;
	Button Exi;
	Button chinese;
	Button english;
	Button math;
	SQLiteDatabase da;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.qurry);

		Exi=(Button)findViewById(R.id.button1);
		chinese=(Button)findViewById(R.id.chinese);
		math=(Button)findViewById(R.id.math);
		english=(Button)findViewById(R.id.english);
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
	
	chinese.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Displaychinese();
			
		}
	});
	
	math.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Displaymath();
			
		}
	});
	
	english.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Displayenglish();
			
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
	     	Cursor c = da.rawQuery("SELECT * FROM student ", null);
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
	 
	 public void Displaychinese(){
	    	List<String> list=new ArrayList<String>();
	     	Cursor c = da.rawQuery("SELECT * FROM student  order by Chinese", null);
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
	 
	 public void Displaymath(){
	    	List<String> list=new ArrayList<String>();
	     	Cursor c = da.rawQuery("SELECT * FROM student order by Math", null);
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
	 
	 public void Displayenglish(){
	    	List<String> list=new ArrayList<String>();
	     	Cursor c = da.rawQuery("SELECT * FROM student order by English", null);
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
	 
	 

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		
	}








}
