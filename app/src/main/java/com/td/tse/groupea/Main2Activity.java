package com.td.tse.groupea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private Intent i;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        i = getIntent();
        String val = i.getStringExtra("STATIC_VALUE");
        editText = findViewById(R.id.txt);
        editText.setText(val);

        Button buttonBack = findViewById(R.id.btnBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("DATA_VALUE", editText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
