package com.example.eva2_10_preferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.settings_layout, new SettingsFragment());
        ft.commit();
        SharedPreferences sPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        Toast.makeText(this, sPreferences.getString("Nia_semana","Nada"), Toast.LENGTH_LONG).show();
        Toast.makeText(this, "" + sPreferences.getBoolean("Dia_laboral", false ), Toast.LENGTH_LONG).show();
        Toast.makeText(this, sPreferences.getString("Nombre","Antonio Vazquez"), Toast.LENGTH_LONG).show();
    }

}
