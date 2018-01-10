package com.example.dm2.spinnerrecurso;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner provincias;
    List<String> listProvincias = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            Resources res = getResources();
            InputStream is = res.openRawResource(R.raw.provincias);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea = br.readLine();
            while(linea!=null){
               listProvincias.add(linea);
                linea=br.readLine();
            }
            br.close();
        }catch(IOException e){

        }

        provincias=(Spinner)findViewById(R.id.spinnerProvincias);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listProvincias);
                //this,                android.R.layout.simple_spinner_item,listProvincias);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provincias.setAdapter(adaptador);
    }
}
