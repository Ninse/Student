package comnine.student;

import java.util.ArrayList;
import java.util.List;



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
import android.widget.ListView;
import android.widget.Toast;

public class Add extends Activity implements OnClickListener{
	public static final String DB_NAME = "studentdata.db";
	Button insertBtn;
	Button updataGBtn;
	Button updataABtn;
	Button deleteBtn;
	Button selectBtn;
	Button displayBtn;
	Button closeBtn;
	ListView mListView;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		mListView=new ListView(this);
	     BtnInit();
		OpenCreateDB();
	}

	public void OpenCreateDB() {
		db = openOrCreateDatabase(DB_NAME, this.MODE_PRIVATE, null);
		db.execSQL("DROP TABLE IF EXISTS students");
		db.execSQL(
				"CREATE TABLE IF NOT EXISTS students (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age INTEGER,grade INTEGER, info VARCHAR)");
	}

	// �������ݵ�students��
	public void InsertData() {
		student liSi = new student("����", 22, 87, "�Ͼ��ʵ��ѧ ͨ�Ź���");
		student liHua = new student("�", 23, 78, "�Ͼ��ʵ��ѧ �������");
		db.execSQL("INSERT INTO students VALUES (NULL,?,?,?,?)", new Object[] { "����", 21, 98, "�Ͼ��ʵ��ѧ ������Ϣ����" });
		db.execSQL("INSERT INTO students VALUES (NULL,?,?,?,?)",
				new Object[] { liSi.name, liSi.age, liSi.grade, liSi.info });
		db.execSQL("INSERT INTO students VALUES (NULL,'����',19,99,'�Ͼ��ʵ��ѧ ���繤��')");
		ContentValues cvOfLiHua = new ContentValues();
		cvOfLiHua.put("name", liHua.name);
		cvOfLiHua.put("age", liHua.age);
		cvOfLiHua.put("grade", liHua.grade);
		cvOfLiHua.put("info", liHua.info);
		db.insert("students", null, cvOfLiHua);
		Log.d("msg", "�������");
		Toast.makeText(this, "����������ɣ�", Toast.LENGTH_SHORT).show();
	}

	public void UpdateGrade() {
		ContentValues cv = new ContentValues();
		cv.put("grade", 85);
		// ��������,�����ĵĳɼ���Ϊ85��
		db.update("students", cv, "name = ?", new String[] { "����" });
		Log.d("msg", "���ĵĳɼ��Ѹ���");
		Toast.makeText(this, "���ĵĳɼ��Ѹ���", Toast.LENGTH_SHORT).show();
	}

	public void UpdateAge() {
		String sqlString = "UPDATE students SET age=18 WHERE grade= 78";
		db.execSQL(sqlString);
		Log.d("msg", "��������Ѹ���");
		Toast.makeText(this, "��������Ѹ���", Toast.LENGTH_SHORT).show();
	}

	public void Delete() {
		db.execSQL("DELETE FROM students WHERE name='����'");
		Log.d("msg", "��������Ϣ�Ѿ���ɾ��");
		Toast.makeText(this, "��������Ϣ�Ѿ���ɾ��", Toast.LENGTH_SHORT).show();
	}
	   public void Select(){
	    	List<String> list=new ArrayList<String>();
	    	Cursor c = db.rawQuery("SELECT * FROM students WHERE grade >= ?", new String[]{"86"});
	    	Log.d("msg","--------------����86�ֵ�ͬѧ----------------------------");
	    	while (c.moveToNext()) {
	        	student person = new student();
	        	person._id = c.getInt(c.getColumnIndex("_id"));
	        	person.name = c.getString(c.getColumnIndex("name"));
	        	person.grade=c.getInt(c.getColumnIndex("grade"));
	        	person.age = c.getInt(c.getColumnIndex("age"));
	        	person.info = c.getString(c.getColumnIndex("info"));
	        	String string=""+person._id+" "+person.name+" "+person.grade+" "+person.age+" "+person.info;
	        	list.add(string);
	        	Log.d("msg",string);
	        }
	        c.close();
	        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list);
	        mListView.setAdapter(adapter);
	    }
	    public void Display(){
	    	List<String> list=new ArrayList<String>();
	    	Cursor c = db.rawQuery("SELECT * FROM students", null);
	        while (c.moveToNext()) {
	        	student person = new student();
	        	person._id = c.getInt(c.getColumnIndex("_id"));
	        	person.name = c.getString(c.getColumnIndex("name"));
	        	person.grade=c.getInt(c.getColumnIndex("grade"));
	        	person.age = c.getInt(c.getColumnIndex("age"));
	        	person.info = c.getString(c.getColumnIndex("info"));
	        	String string=""+person._id+" "+person.name+" "+person.grade+" "+person.age+" "+person.info;
	        	list.add(string);
	        	Log.d("msg",string);
	        }
	        c.close();
	        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list);
	        mListView.setAdapter(adapter);
	    }
	    public void Close(){
	    	db.close();
	    }
	    public void BtnInit(){
	    	insertBtn=(Button)findViewById(R.id.insert);
	        updataGBtn=(Button)findViewById(R.id.updataG);
	        updataABtn=(Button)findViewById(R.id.updataA);
	        deleteBtn=(Button)findViewById(R.id.delete);
	        selectBtn=(Button)findViewById(R.id.select);
	        displayBtn=(Button)findViewById(R.id.display);
	        closeBtn=(Button)findViewById(R.id.close);
	        mListView=(ListView)findViewById(R.id.listview);
	        insertBtn.setOnClickListener(this);
	        updataABtn.setOnClickListener(this);
	        updataGBtn.setOnClickListener(this);
	        deleteBtn.setOnClickListener(this);
	        selectBtn.setOnClickListener(this);
	        displayBtn.setOnClickListener(this);
	        closeBtn.setOnClickListener(this);
	    }
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.insert:
			InsertData();
			break;
		case R.id.updataA:
			UpdateAge();
			break;
		case R.id.updataG:
			UpdateGrade();
			break;
		case R.id.display:
			Display();
			break;
		case R.id.delete:
			Delete();
			break;
		case R.id.select:
			Select();
			break;
		case R.id.close:
			Close();
			break;
		}
	}

}
