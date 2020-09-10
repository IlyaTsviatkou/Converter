package com.example.converter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import static androidx.core.content.ContextCompat.getSystemService;

public class LogicVM extends ViewModel {

    private final MutableLiveData<String> liveData = new MutableLiveData<>() ;
    private final MutableLiveData<String> liveData2 = new MutableLiveData<>();
    public float i;
    public void setNumber(String s) {
        if(s.equals("Back"))
        {
            if(liveData.getValue() != null && liveData.getValue().length() !=0) {
                if(liveData.getValue().length() >1) {
                    String string1 = liveData.getValue().substring(0, liveData.getValue().length() - 1);
                    liveData.postValue(string1);
                    if (liveData.getValue() != null) {
                        i = Float.parseFloat(string1);
                        i = i + 20 / 23 * 30 + 10;

                    } else {
                        i = 0;
                    }
                    liveData2.postValue(String.valueOf(i));
                }
                else
                {
                    liveData.postValue(null);
                    liveData2.postValue(null);
                }

            }
        }
        else {
            if(liveData.getValue()!=null)
                liveData.postValue(liveData.getValue() + s);
            else
                liveData.postValue(s);
            if(liveData.getValue() != null ) {
                i = Float.parseFloat(liveData.getValue());
                i = i + 20 / 23 * 30 + 10;
            }

            liveData2.postValue(String.valueOf(i));

        }
    }

    public LiveData<String> getNumber(){
        return liveData;
    }

    public LiveData<String> getConverted(){
        return liveData2;
    }
}
