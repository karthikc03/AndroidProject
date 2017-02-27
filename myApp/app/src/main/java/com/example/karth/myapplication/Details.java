package com.example.karth.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    ImageView imageView;
    TextView head;
    TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = (ImageView)findViewById(R.id.imageView4);
        head = (TextView)findViewById(R.id.textView);
        desc = (TextView)findViewById(R.id.textView2);


        head.setText("Heading"+getIntent().getStringExtra("head"));
        desc.setText("Price"+getIntent().getStringExtra("desc"));
        imageView.setImageResource(getIntent().getIntExtra("imgid",0));

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void process(View view) {
        Intent intent = null, chooser = null;
        intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String to = "";
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, "NEW FASHION");
        intent.putExtra(Intent.EXTRA_TEXT, "Here is the new fashion, check it out\n "+
                "Style : "+ getIntent().getStringExtra("head")+" \n"+
                "price : "+getIntent().getStringExtra("desc"));
        intent.setType("message/rfc822");
        chooser = Intent.createChooser(intent,"Send Email");
        startActivity(chooser);



    }
}
