package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    public Button button7,btn;
    public static TextView text;


  ArrayList<String> listItem,listItem1,listItem2;
    ArrayAdapter adapter,adapter1,adapter2;
    Databasehelper db;
    public static int result=0;
    ListView lv , lv1 ,lv2;
    public int set=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      //  Main2Activity m=new Main2Activity();
        db=new Databasehelper(this);
        listItem=new ArrayList<>();
        listItem1=new ArrayList<>();
        listItem2=new ArrayList<>();
        lv=(ListView)findViewById(R.id.lvItems);
        lv1=(ListView)findViewById(R.id.lvItem1);
        lv2=(ListView)findViewById(R.id.lvItem2);
        text=(TextView)findViewById(R.id.textView8);
        btn=(Button)findViewById(R.id.button8);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity10();
            }
        });
        button7=(Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*set+=1;
                openActivity3();
                if(set%2!=0)
                {
                    viewData();
                }*/
                openActivity3();
                viewData();
                //int total=cursor1.getInt(0);
                //Toast.makeText(this,)
                //int sum=Integer.parseInt(total);
                //result=result+total;
                 text.setText(String.valueOf(result));


                Main3Activity.myResult=null;

                //boolean set=false;
                //viewData();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String text=lv.getItemAtPosition(1).toString();


                       // Toast.makeText(this, ""+text, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        //viewData();
    }
    public void openActivity3(){
        Intent intent= new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
    public void openActivity10(){
        Intent intent= new Intent(this,Main4Activity.class);
        startActivity(intent);
    }
private void viewData(){
        Cursor cursor=db.viewData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No data to show",Toast.LENGTH_LONG).show();
        }
        else{
            while(cursor.moveToNext()){
                listItem.add(cursor.getString(0));
                listItem1.add(cursor.getString(1));
                listItem2.add(cursor.getString(2));
                int data = cursor.getInt(cursor.getColumnIndex("Price"));
                //int total= cursor.getInt(2);
                result=result+data;

            }
            adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,listItem);
            adapter1= new ArrayAdapter(this,android.R.layout.simple_list_item_1,listItem1);
            adapter2=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listItem2);
            lv.setAdapter(adapter);
            lv1.setAdapter(adapter1);
            lv2.setAdapter(adapter2);
        }
    /*public void viewTotal(){
        Cursor cursor1=db.viewTotal();
        String total=cursor1.getString(0);
        int sum=Integer.parseInt(total);
        result=result+sum;





        }*/


}





}
