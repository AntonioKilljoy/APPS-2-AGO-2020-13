package com.example.rep_5_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnEmpezar;
    Button btnParar;
    Intent inServicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inServicio = new Intent(this,MyService.class);
        btnParar =  findViewById(R.id.btnParar);
        btnEmpezar =  findViewById(R.id.btnEmpezar);
        btnEmpezar.setOnClickListener(this);
        btnParar.setOnClickListener(this);
        BroadcastReceiver bReceiver = new MibroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter("MI_SERVICIO");
        registerReceiver(bReceiver, intentFilter);
    }

    public void empezar(View v){
        startService(inServicio);
        inServicio.putExtra("DATO","HEY");
    }

    public void parar(View v){
        stopService(inServicio);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEmpezar:
                empezar(v);
                break;
            case R.id.btnParar:
                parar(v);
                break;
        }
    }

    class MibroadCastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.wtf("MENSAJE", "THREAD");
        }
    }
}