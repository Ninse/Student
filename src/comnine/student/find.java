package comnine.student;





import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.view.Menu;  
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;

public class find extends Activity{
	private ListView myListView;
	private dbHelper db;
	private Cursor myCursor;
	private int _id;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
        myListView=(ListView)findViewById(R.id.ListView1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.find);
	   db=new dbHelper(find.this);
       myCursor=db.select();

       SimpleCursorAdapter adpater=new SimpleCursorAdapter(this, R.layout.test, myCursor,
       		new String[]{dbHelper.Name},
       		new int[]{R.id.topTextView});
       myListView.setAdapter(adpater);
       
       myListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				myCursor.moveToPosition(arg2);
				_id=myCursor.getInt(0);
			//	myEditText.setText(myCursor.getString(1));
			}
		});
       
       myListView.setOnItemSelectedListener(new OnItemSelectedListener() {

    			@Override
    			public void onItemSelected(AdapterView<?> arg0, View arg1,
    					int arg2, long arg3) {
    				// TODO Auto-generated method stub
    				SQLiteCursor sc=(SQLiteCursor)arg0.getSelectedItem();
    				_id=sc.getInt(0);
    			//	myEditText.setText(sc.getString(1));
    			}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					// TODO 自动生成的方法存根
					
				}
       });

}}