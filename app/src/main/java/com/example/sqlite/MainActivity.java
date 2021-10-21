package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import DB.ContactsDBHelper;
import Model.Contact;

public class MainActivity extends AppCompatActivity {
    private ContactsDBHelper dbHelper;
    private SQLiteDatabase db;





        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enterBtn = findViewById(R.id.enterBtn);
        EditText nombreEdt = findViewById(R.id.nombreEdt);
            enterBtn.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    Contact contact = new Contact(nombreEdt.getText().toString());
                    dbHelper.insertContact(db,contact);

                }
            });

        dbHelper = new ContactsDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();
    }

    //Close the db when the activity onDestroy
    @Override
    protected void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }


}