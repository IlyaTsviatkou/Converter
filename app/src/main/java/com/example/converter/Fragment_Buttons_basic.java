package converter;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;


import com.example.converter.R;

public class Fragment_Buttons_basic extends Fragment  {

    private LogicVM myVM;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_buttons,null);

        Button button;
        button = (Button) v.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myVM.setNumber("1");
            }
        });
        button = (Button) v.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myVM.setNumber("2");
            }
        });
        button = (Button) v.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myVM.setNumber("3");
            }
        });
        button = (Button) v.findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myVM.setNumber("4");
            }
        });
        button = (Button) v.findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myVM.setNumber("5");
            }
        });
        button = (Button) v.findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myVM.setNumber("6");
            }
        });
        button = (Button) v.findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myVM.setNumber("7");
            }
        });
        button = (Button) v.findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myVM.setNumber("8");
            }
        });
        button = (Button) v.findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myVM.setNumber("9");
            }
        });
        button = (Button) v.findViewById(R.id.button0);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myVM.setNumber("0");
            }
        });
        button = (Button) v.findViewById(R.id.buttonBack);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myVM.setNumber("Back");
            }
        });



        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myVM = ViewModelProviders.of(getActivity()).get(LogicVM.class);

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }


}
