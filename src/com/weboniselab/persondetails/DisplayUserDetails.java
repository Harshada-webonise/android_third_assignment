package com.weboniselab.persondetails;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class DisplayUserDetails extends Activity
{
	SQLiteDatabase database;
	TextView nameTextView;
	TextView ageTextView;
	PersonInfo person;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
     
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		nameTextView=(TextView) findViewById(R.id.nametextview);
		ageTextView=(TextView) findViewById(R.id.agetextview);
		
		Intent intent=getIntent();
		
		String name=(String) intent.getSerializableExtra("name");
	    Integer age=(Integer) intent.getSerializableExtra("age");
		
		Dbhelper helper=new Dbhelper(DisplayUserDetails.this);
		SQLiteDatabase db=helper.getReadableDatabase();
		
		
		//db.query("personinfo", new String[]{"name","address","age"}, name, name, null, null, null);
		
		
		//Cursor cur=db.query(true, "restaurants", new String[]{"cuisineId","name","address","cuisines","rating"},"cuisineId="+cuisineId,null, null, null, null, null);
//		String where = "name = '" + _name + "'";
//		
//		  Cursor mCursor = db.query(true, "personinfo", new String[]{"name","address","age"}, where,
//                  null, null, null, null, null);
//		  
//		 // Log.d("cursor"+mCursor.toString(), "cursor");
//		  
//		   person=new PersonInfo();
//		   person.setName(mCursor.getString(mCursor.getColumnIndex("name")));
//		   person.setAddress(mCursor.getString(mCursor.getColumnIndex("address")));
//           person.setAge(mCursor.getInt(mCursor.getColumnIndex("age")));
//         	Log.d("Person", ""+person.toString());
//         	
		  
     	//person.setAge(cur.getInt(cur.getColumnIndex("age")));

		Cursor cur=db.query("personinfo", new String[]{"name","address","age"}, null, null, null, null, null);

		
        if(cur.moveToFirst())
        {
                do
                {
                	person=new PersonInfo();
                	person.setName(cur.getString(cur.getColumnIndex("name")));
                	person.setAddress(cur.getString(cur.getColumnIndex("address")));
                	person.setAge(cur.getInt(cur.getColumnIndex("age")));
                
                        if(person.getName().equals(name) && person.getAge()==age)
                        {
                        	nameTextView.setText("Name:"+person.getName()+"\nAddress:"+person.getAddress()+"\nAge:"+person.getAddress());
                        
                        }
                
                }while(cur.moveToNext());

        }
        
         cur.close();
	}	
	
}
		
		
		
		
		
		
		
		
	

