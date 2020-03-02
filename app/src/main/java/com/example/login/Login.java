package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    EditText Phn,psd;
    Button log,reg2;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        openHelper= new Databasehelper(this);
        db=openHelper.getReadableDatabase();
        log=(Button) findViewById(R.id.button2);
        reg2=(Button)findViewById(R.id.button3);
        Phn=(EditText) findViewById(R.id.editText4);
        psd=(EditText) findViewById(R.id.editText5);
        reg2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }}));
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Phnnmbr=Phn.getText().toString();
                String pass=psd.getText().toString();
                cursor=db.rawQuery("SELECT *FROM " + Databasehelper.TABLE_NAME + " WHERE " + Databasehelper.COL_1 + "=? AND " + Databasehelper.COL_3 + "=?" , new String[]{Phnnmbr,pass});
                if (cursor != null) {
                    if(cursor.getCount()>0) {
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(),"Login Successfull", Toast.LENGTH_LONG).show();
                        openActivity2();

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Login UnSuccessfull", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
    public void openActivity2(){
        Intent intent= new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
