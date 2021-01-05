package com.example.converter;

import android.content.ClipboardManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements SomeEventListener {

    public ClipboardManager myClipboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void someEvent(String s) {
        Fragment fragment =  getSupportFragmentManager().findFragmentById(R.id.fragment1);
        float i=0;
//        Log.d("ASS",fragment.getView().findViewById(R.id.textView).toString());


    }
}
