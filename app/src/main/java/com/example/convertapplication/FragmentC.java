package com.example.convertapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


public class FragmentC extends Fragment {

    public interface FragmentsCListener {
        void onInputCSent(String input);
    }



    private EditText etKelvin;
    private FragmentsCListener listener;

    public FragmentC() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_c, container, false);

        etKelvin =  v.findViewById(R.id.et_kelvin);
        v.findViewById(R.id.button_to_kelvin).setOnClickListener(bv -> {
            String input = etKelvin.getText().toString();

            //stuur informatie naar Fragment c

            listener.onInputCSent(input);
        });

        return v;
    }

    //ontvangt data van buitenaf (bvb als er in fragment c op "ok" wordt gedrukt)
    public void updateKelvin(String input){
        etKelvin.setText(input);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        //controleerd of FragmentsCListener een deel is van de context
        //https://www.baeldung.com/java-instanceof
        if(context instanceof FragmentsCListener){
            listener = (FragmentsCListener)context;
        }
        else{
            throw new RuntimeException(
                    String.format("%s must implement FragmentAListener", context.toString())
            );
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }

}

