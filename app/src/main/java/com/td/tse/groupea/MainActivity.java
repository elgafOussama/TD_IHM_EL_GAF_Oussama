package com.td.tse.groupea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NameItemListener{


    private Button buttonNext;
    private Intent intent;
    private RecyclerView recyclerView;
    private ListNameAdapter listNameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNameAdapter=new ListNameAdapter(this);

        //textViewName = findViewById(R.id.lbl);
        buttonNext = findViewById(R.id.btnNext);
        recyclerView = findViewById(R.id.recyclerViewName);


        // init list ---------------------------

        final LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listNameAdapter);
        // End init list ---------------------------

        intent = new Intent(this,Main2Activity.class);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //startActivityForResult(intent, 1);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        List nameList = DataManager.getInstance().getNameList();
        listNameAdapter.updateData(nameList);
    }

    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK && data.getExtras()!=null) {
                String strEditText = data.getStringExtra("DATA_VALUE");
                textViewName.setText(strEditText);
            }else{
                Toast.makeText(this.getApplicationContext(),resultCode,Toast.LENGTH_LONG).show();
            }
        }
    }*/


    @Override
    public void onClickItem(String name) {
        Toast.makeText(this,name,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClickCross(String name, View view) {
        Toast.makeText(this,"delete " + name,Toast.LENGTH_LONG).show();
        ((ViewGroup)view.getParent().getParent()).removeView((ViewGroup)view.getParent());

    }
}
