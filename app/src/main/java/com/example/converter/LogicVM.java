package com.example.converter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import static androidx.core.content.ContextCompat.getSystemService;

public class LogicVM extends ViewModel {
    private Converter conv = new Converter();
    private final MutableLiveData<String> liveData = new MutableLiveData<>() ;
    private final MutableLiveData<String> liveData2 = new MutableLiveData<>();
    private final MutableLiveData<Integer> liveDataUnit = new MutableLiveData<>();
    private final MutableLiveData<Integer> liveDataUnitFrom = new MutableLiveData<>();
    private final MutableLiveData<Integer> liveDataUnitTo = new MutableLiveData<>();
    public ClipboardManager myClipboard;

    public float i;
    public void setNumber(String s) {

        if(s.equals("Back"))
        {

            if(liveData.getValue() != null && liveData.getValue().length() !=0) {
                if(liveData.getValue().length() >1) {
                    String string1 = liveData.getValue().substring(0, liveData.getValue().length() - 1);
                    liveData.postValue(string1);
                    if(liveDataUnit.getValue()!=null&&liveDataUnitFrom.getValue()!=null&& liveDataUnitTo.getValue()!=null) {
                        liveData2.postValue(conv.Convert(liveDataUnit.getValue(),
                                liveDataUnitFrom.getValue(),
                                liveDataUnitTo.getValue(),
                                Float.parseFloat(string1)));
                    }
                    else
                    {
                        liveData2.postValue(null);
                    }
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
                if(liveDataUnit.getValue()!=null&&liveDataUnitFrom.getValue()!=null&& liveDataUnitTo.getValue()!=null) {
                    liveData2.postValue(conv.Convert(liveDataUnit.getValue(),
                            liveDataUnitFrom.getValue(),
                            liveDataUnitTo.getValue(),
                            Float.parseFloat(liveData.getValue()+s)));
                }
                else
                {
                    liveData2.postValue(null);
                }
            }
            else {
                if(liveDataUnit.getValue()!=null&&liveDataUnitFrom.getValue()!=null&& liveDataUnitTo.getValue()!=null) {
                    liveData2.postValue(conv.Convert(liveDataUnit.getValue(),
                            liveDataUnitFrom.getValue(),
                            liveDataUnitTo.getValue(),
                            Float.parseFloat(s)));
                }
            }



        }
    }

    public void Copy(ClipboardManager manager)
    {
            ClipData clip = android.content.ClipData.newPlainText("TAG",liveData.getValue());
            manager.setPrimaryClip(clip);
    }


    public LiveData<String> getNumber(){
        return liveData;
    }

    public LiveData<String> getConverted(){
        return liveData2;
    }

    public LiveData<Integer> getUnit(){
        return liveDataUnit;
    }
    public LiveData<Integer> getUnitFrom(){
        return liveDataUnitFrom;
    }
    public LiveData<Integer> getUnitTo(){
        return liveDataUnitTo;
    }

    public void setLiveDataUnit(int a)
    {
        liveDataUnit.postValue(a);
    }

    public void setLiveDataUnitFrom(int a)
    {
        liveDataUnitFrom.postValue(a);
    }
    public void setLiveDataUnitTo(int a)
    {
        liveDataUnitTo.postValue(a);
    }
}
