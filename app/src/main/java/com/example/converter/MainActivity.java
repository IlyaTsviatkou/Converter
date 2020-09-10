package com.example.converter;

import android.app.FragmentTransaction;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements SomeEventListener {
    public String string1="";
    public String string2="";
    public ClipboardManager myClipboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.commit();

        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("string1", string1);
        outState.putString("string2",string2);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        string1 = savedInstanceState.getString("string1");
        string2 = savedInstanceState.getString("string2");
        Fragment fragment =  getSupportFragmentManager().findFragmentById(R.id.fragment1);
        ((TextView) fragment.getView().findViewById(R.id.textView)).setText(string1);
        ((TextView) fragment.getView().findViewById(R.id.textView2)).setText(string2);
    }
    public void someEvent(String s) {
        Fragment fragment =  getSupportFragmentManager().findFragmentById(R.id.fragment1);
        float i=0;
//        Log.d("ASS",fragment.getView().findViewById(R.id.textView).toString());
        if(s.equals("Copied"))
        {
            ClipData clip = android.content.ClipData.newPlainText("TAG",string1);
            myClipboard.setPrimaryClip(clip);
        }



        ((TextView) fragment.getView().findViewById(R.id.textView)).setText(string1);
        string2= String.valueOf(i);
        ((TextView) fragment.getView().findViewById(R.id.textView2)).setText(string2);
    }
}
