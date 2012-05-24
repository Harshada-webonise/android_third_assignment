package com.weboniselab.persondetails;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity implements OnItemClickListener{
	
	ListView listview;
	PersonDetails person;
	ArrayList<PersonDetails> array;
	ArrayAdapter<PersonDetails> arrayAdapt;
	
	SQLiteDatabase database;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.listview);
	  
	   array=new ArrayList<PersonDetails>();
	
       Dbhelper helper=new Dbhelper(ListViewActivity.this);
       database=helper.getReadableDatabase();
		
		Cursor cur=database.query("person", new String[]{"name","age"}, null, null, null, null, null);

		if(cur.moveToFirst())
		{
			do
			{
				 person=new PersonDetails();
				 person.setName(cur.getString(cur.getColumnIndex("name")));
				 person.setAge(cur.getInt(cur.getColumnIndex("age")));
				 array.add(person);
			
			}while(cur.moveToNext());
		}
		cur.close();
		
	   arrayAdapt=new ArrayAdapter<PersonDetails>(this, R.layout.list_item,array);
       listview=(ListView)findViewById(R.id.listview);
       listview.setAdapter(arrayAdapt);
       listview.setOnItemClickListener(this);

	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

		PersonDetails person=(PersonDetails)listview.getItemAtPosition(position);
		Intent intent=new Intent(ListViewActivity.this,DisplayUserDetails.class);
     	intent.putExtra("name",person.getName());
     	intent.putExtra("age", person.getAge());
		startActivity(intent);
		
	}

	
}



