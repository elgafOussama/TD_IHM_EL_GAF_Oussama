package com.td.tse.groupea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewName;
    private Button buttonNext;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = findViewById(R.id.lbl);
        buttonNext = findViewById(R.id.btnNext);

        intent = new Intent(this,Main2Activity.class);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("STATIC_VALUE" , textViewName.getText().toString());
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
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
    }
}
