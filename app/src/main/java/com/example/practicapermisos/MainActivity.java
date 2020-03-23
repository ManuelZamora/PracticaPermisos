package com.example.practicapermisos;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private int sw = 0;
    Switch sw1;
    Switch sw2;
    Switch sw3;
    Switch sw4;
    Switch sw5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw1 = findViewById(R.id.S1);
        sw1.setOnCheckedChangeListener(this);
        sw2 = findViewById(R.id.S2);
        sw2.setOnCheckedChangeListener(this);
        sw3 = findViewById(R.id.S3);
        sw3.setOnCheckedChangeListener(this);
        sw4 = findViewById(R.id.S4);
        sw4.setOnCheckedChangeListener(this);
        sw5 = findViewById(R.id.S5);
        sw5.setOnCheckedChangeListener(this);

    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId())
        {

        }
    }
}
