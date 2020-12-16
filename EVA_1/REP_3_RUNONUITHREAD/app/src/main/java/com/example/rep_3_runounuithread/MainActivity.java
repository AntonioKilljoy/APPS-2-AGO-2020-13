package com.example.rep_3_runounuithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwDato;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //aqui se puede modificar la interfaz grafica
            txtVwDato.append("HOLA MUNDO :) \n");
        }
    };
    Thread thread = new Thread() {
        @Override
        public void run() {
            super.run();
            int i = 0;
            while (i < 10) {
                try {
                    Thread.sleep(1000);
                    runOnUiThread(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }

    };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            txtVwDato = findViewById(R.id.txtVwDato);
            thread.start();
        }
    }
