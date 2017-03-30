package com.example.karth.saveinstancestate;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        count = 0;
       textView.setText("Count: " + count);

//without using restoreInstanceState, we can use this condition
        if(savedInstanceState != null){
            count = savedInstanceState.getInt("myCount", 0);
            textView.setText("Count: "+count);
        }

    }

    public void increment(View view) {

        count++;
        textView.setText("Count: " + count);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("myCount",count);
    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        count = savedInstanceState.getInt("myCount", 0);
//        textView.setText("Count: "+count);
//    }
}
