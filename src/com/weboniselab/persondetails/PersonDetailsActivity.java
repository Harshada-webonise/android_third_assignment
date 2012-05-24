package com.weboniselab.persondetails;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PersonDetailsActivity extends Activity implements OnClickListener
{
    
    EditText nameEdittext,ageEditText;
    Button btnSave;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        nameEdittext=(EditText) findViewById(R.id.nameEditText);
        ageEditText=(EditText) findViewById(R.id.ageEditText);
        btnSave=(Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
}

	@Override
	public void onClick(View v) {	
        Dbhelper helper=new Dbhelper(PersonDetailsActivity.this);
		SQLiteDatabase database=helper.getWritableDatabase();
     
		
		
		ContentValues values=new ContentValues();
		ContentValues values1=new ContentValues();
		
		values.put("name", nameEdittext.getText().toString());
	 	values.put("age", ageEditText.getText().toString());
		database.insert("person", null, values);
		
		
		values1.put("name", "Harsh");
	 	values1.put("address", "pune");
	 	values1.put("age", 22);
	 	database.insert("personinfo", null, values1);
		database.close();
		
        Intent intent=new Intent(PersonDetailsActivity.this,ListViewActivity.class);
        startActivity(intent);
		

	}
}