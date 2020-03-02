package com.example.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button reg,logi;
    EditText phone,name,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper=new Databasehelper(this);
        reg=(Button)findViewById(R.id.button);
        logi=(Button)findViewById(R.id.button4);
        phone=(EditText)findViewById(R.id.editText);
        name=(EditText)findViewById(R.id.editText2);
        password=(EditText)findViewById(R.id.editText3);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String ph=phone.getText().toString();
                String nm=name.getText().toString();
                String pwd=password.getText().toString();
                insertdata(ph,nm,pwd);
                //String pid="1";
                //String pname="Chinmaya";
                //String Price="100";
                insert("1","Maggie","50");
                insert("2","Parle G","20");
                insert("3","Lays","10");
                insert("4","Cococola","40");

                Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_LONG).show();


            }
        });
        logi.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        }));
       // Cursor cursor=openHelper.alldata();

    }
    public void insertdata(String ph,String nm,String pwd){
        ContentValues contentValues=new ContentValues();
        contentValues.put(Databasehelper.COL_1, ph);
        contentValues.put(Databasehelper.COL_2, nm);
        contentValues.put(Databasehelper.COL_3, pwd);
        long id=db.insert(Databasehelper.TABLE_NAME,null,contentValues);
}
    public void insert(String pid,String pname ,String Price){
        ContentValues contentValue=new ContentValues();
        contentValue.put(Databasehelper.KEY_ID, pid);
        contentValue.put(Databasehelper.KEY_NAME, pname);
        contentValue.put(Databasehelper.KEY_PRICE, Price);
        long id1=db.insert(Databasehelper.STORE_TABLE,null,contentValue);

    }}
