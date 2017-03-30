package com.example.karth.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSecond(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void goToEiffelTower(View view) {
        //here Action_View is the type of intent we are using

        Intent intent = new Intent(Intent.ACTION_VIEW);

        //geo is the key for specifying applications that handle maps need to be shown
        intent.setData(Uri.parse("geo:48.8583701,2.2944813"));

        //create.chooser is used to create the chooser with custom headline
        // (here custom headline is "Launch Maps")
        //If we dont want to use a custom chooser we can directly write
        //startActivity(intent);

        Intent chooser = Intent.createChooser(intent,"Launch Maps");
        startActivity(chooser);

    }

    public void launchAppStore(View view) {
        Intent intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.instagram.android&hl=en"));
        Intent chooser = Intent.createChooser(intent,"Open App");
        startActivity(chooser);
    }

    public void sendMail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String to[] = {"karthikrocks007@gmail.com","karthikchandra03@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, "This message goes into subject");
        intent.putExtra(Intent.EXTRA_TEXT, "This message goes into the body of email");
        //This setType("message/rfc822") will open only apps which can send only emails
        // not any other text messaging application
        intent.setType("message/rfc822");
        Intent chooser = Intent.createChooser(intent,"Email");
        startActivity(chooser);
    }

    public void shareText(View view) {

        editText = (EditText) findViewById(R.id.editText);
        String textToShare = editText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);

        //below line shows all the apps that can send plain text
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textToShare);

        Intent chooser = Intent.createChooser(intent,"Send Text");
        startActivity(chooser);
    }
}
