package com.example.karth.databtwactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
EditText editText;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText2);
        textView = (TextView) findViewById(R.id.textView2);
        String str = getIntent().getStringExtra("SendName");
        textView.setText(str);
    }

    public void sendDataBack(View view) {
String data = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("DataBack", data );
        setResult(RESULT_OK, intent);
        finish();
    }
}
