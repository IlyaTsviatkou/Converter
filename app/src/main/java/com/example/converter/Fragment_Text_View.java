package com.example.converter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import org.w3c.dom.Text;


public class Fragment_Text_View extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_text_view,null);
        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SettingsDialog alert = new SettingsDialog(getActivity());
                alert.showDialog(getActivity(), "Error de conexión al servidor");

            }
        });
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView text = view.findViewById(R.id.textView);
        TextView text2 = view.findViewById(R.id.textView2);
        LogicVM myVM = ViewModelProviders.of(getActivity()).get(LogicVM.class);
        myVM.getNumber().observe(requireActivity(), s-> text.setText(s));
        myVM.getConverted().observe(requireActivity(),s->text2.setText(s));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

}
