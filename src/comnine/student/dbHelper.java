package comnine.student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.Toast;

public class dbHelper extends SQLiteOpenHelper {

	private final static String DATABASE_NAME="sqldatas";
	private final static int DATABASE_VERSION=1;
	private final static String TABLE_NAME="student";
	public final static String FIELD_ID="_id"; 
	public final static String Name="Name";
	public final static String Number="Number";
	public final static String Math="Mach";
	public final static String English="English";
	public final static String Chinese="Chinese";
	public dbHelper(Context context)
	{
		super(context, DATABASE_NAME,null, DATABASE_VERSION);
	}
	 
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql="Create table "+TABLE_NAME+"("+FIELD_ID+" integer primary key autoincrement,"
		+Name+" text,"+Number+" integer,"+Chinese+" integer,"+Math+" integer,"+English+" integer );";
		db.execSQL(sql); 
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String sql=" DROP TABLE IF EXISTS "+TABLE_NAME;
		db.execSQL(sql);
		onCreate(db);
	}

	public Cursor select()
	{
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor=db.query(TABLE_NAME, null, null, null, null, null,  " _id desc");
		return cursor;
	}
	
	public long insert(String Title,int number,int chinese,int math,int english)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues cv=new ContentValues(); 
		ContentValues av=new ContentValues(); 
		cv.put(Name, Title);
		cv.put(Number, number);
		cv.put(Chinese, chinese);
		cv.put(Math, math); 
		cv.put(English, english);
		long row=db.insert(TABLE_NAME, null, cv);
		return row;
		
	}
	public void delete(int id)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		String where=FIELD_ID+"=?";
		String[] whereValue={Integer.toString(id)};
		db.delete(TABLE_NAME, where, whereValue);
	}
	
	public void update(int id,String Title,int number,int chinese,int math,int english)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		String where=FIELD_ID+"=?";
		String[] whereValue={Integer.toString(id)};
		ContentValues cv=new ContentValues(); 
		cv.put(Name, Title);
		cv.put(Number, number);
		cv.put(Chinese, chinese);
		cv.put(Math, math); 
		cv.put(English, english);
		db.update(TABLE_NAME, cv, where, whereValue);
	}
	
	
	
	
}
