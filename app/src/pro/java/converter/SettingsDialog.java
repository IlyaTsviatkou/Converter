package converter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.converter.R;

import converter.LogicVM;

public class SettingsDialog extends Dialog{

   public ArrayAdapter<?> adapter1,adapter2,adapter3;
    private LogicVM myVM;

    public SettingsDialog(@NonNull Context context) {
        super(context);
        myVM = ViewModelProviders.of((FragmentActivity) context).get(LogicVM.class);
         adapter1= ArrayAdapter.createFromResource(context, R.array.Currency, android.R.layout.simple_spinner_item);
         adapter2 = ArrayAdapter.createFromResource(context, R.array.Weight, android.R.layout.simple_spinner_item);
          adapter3 = ArrayAdapter.createFromResource(context, R.array.Distance, android.R.layout.simple_spinner_item);
    }

    public void showDialog(Activity activity, String msg){

            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.sets);
            Spinner spinner1 = dialog.findViewById(R.id.spinner1);
            Spinner spinner2 = dialog.findViewById(R.id.spinner2);
            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                myVM.setLiveDataUnitFrom(selectedItemPosition);}

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    myVM.setLiveDataUnitFrom(0);
                }
            });
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,
                        View itemSelected, int selectedItemPosition, long selectedId) {
                    myVM.setLiveDataUnitTo(selectedItemPosition);}

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    myVM.setLiveDataUnitTo(0);
                }
            });
            RadioButton radBtn;
            radBtn= (RadioButton) dialog.findViewById(R.id.radio_blue) ;
            radBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner1.setAdapter(adapter2);
                    spinner2.setAdapter(adapter2);
                    myVM.setLiveDataUnit(2);
                }
            });
            radBtn= (RadioButton) dialog.findViewById(R.id.radio_green) ;
            radBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner1.setAdapter(adapter3);
                    spinner2.setAdapter(adapter3);
                    myVM.setLiveDataUnit(3);
                }
            });
            radBtn= (RadioButton) dialog.findViewById(R.id.radio_red) ;
            radBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner1.setAdapter(adapter1);
                    spinner2.setAdapter(adapter1);
                    myVM.setLiveDataUnit(1);
                }
            });
            if(myVM.getUnit().getValue()!=null) {
                if (myVM.getUnit().getValue() == 1) {
                    radBtn.callOnClick();
                    radBtn.setChecked(true);
                } else if (myVM.getUnit().getValue() == 2) {
                    RadioButton rBtn = (RadioButton) dialog.findViewById(R.id.radio_blue);
                    rBtn.callOnClick();
                    rBtn.setChecked(true);
                } else if (myVM.getUnit().getValue() == 3) {
                    RadioButton rBtn = (RadioButton) dialog.findViewById(R.id.radio_green);
                    rBtn.callOnClick();
                    rBtn.setChecked(true);
                }
            }
            else
            {
                radBtn.callOnClick();
                radBtn.setChecked(true);
            }
            if(myVM.getUnitFrom().getValue()!=null)
            {
                spinner1.setSelection(myVM.getUnitFrom().getValue());
            }
            if(myVM.getUnitTo().getValue()!=null)
            {
                spinner2.setSelection(myVM.getUnitTo().getValue());
            }
            Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            Button
        swapButton = (Button) dialog.findViewById(R.id.btnSwapF);
            swapButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(myVM.getConverted().getValue()!=null && myVM.getNumber().getValue()!=null) {
                        String c = myVM.getConverted().getValue();
                        myVM.swapData(c);
                        int a = myVM.getUnitTo().getValue();
                        int b = myVM.getUnitFrom().getValue();
                        myVM.setLiveDataUnitTo(b);
                        myVM.setLiveDataUnitFrom(a);
                        spinner1.setSelection(a);
                        spinner2.setSelection(b);
                    }
                }
            });
            dialog.show();


        }

    }

