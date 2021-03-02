package com.example.convertapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements FragmentA.FragmentsAListener, FragmentB.FragmentsBListener, FragmentC.FragmentsCListener{

    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentC fragmentC;

    private int Fahrenheit;
    private int Celcius;
    private int Kelvin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentC = new FragmentC();



        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_a, fragmentA)
                .replace(R.id.layout_b, fragmentB)
                .replace(R.id.layout_c, fragmentC)
                .commit();

    }

    @Override
    public void onInputASent(String input) {
        Fahrenheit = (Integer.parseInt(input)*9/5)+32;
        fragmentB.updateFahrenheit(Integer.toString(Fahrenheit)+"  fahrenheit");
        //(0°C × 9/5) + 32 = 32°F

        Kelvin = (Integer.parseInt(input)+273);
        fragmentC.updateKelvin(Integer.toString(Kelvin)+"  kelvin");

    }

    @Override
    public void onInputBSent(String input) {
        Celcius = (Integer.parseInt(input)-32)*5/9;
        fragmentA.updateCelcius(Integer.toString(Celcius)+ " celcius");

        Kelvin = (Integer.parseInt(input)+460)*5/9;
        fragmentC.updateKelvin(Integer.toString(Kelvin)+"  kelvin");

    }

    @Override
    public void onInputCSent(String input) {
        Celcius = (Integer.parseInt(input)-273);
        fragmentA.updateCelcius(Integer.toString(Kelvin)+ " celsius");

        Fahrenheit = (Integer.parseInt(input)-273)*1800+32;
        fragmentB.updateFahrenheit(Integer.toString(Fahrenheit)+"  fahrenheit");


    }
}