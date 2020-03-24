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
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private int sw = 0;
    Switch sw1,sw2,sw3,sw4,sw5;
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
    public void onCheckedChanged(CompoundButton buttonView, boolean Checked) {
        switch (buttonView.getId()) {
            case R.id.S1:
                if (Checked) {
                    sw = 1;
                    permissions(Manifest.permission.ACCESS_FINE_LOCATION, 1);
                }
                break;
            case R.id.S2:
                if (Checked) {
                    sw = 2;
                    permissions(Manifest.permission.CAMERA, 2);
                }
                break;
            case R.id.S3:
                if (Checked) {
                    sw = 3;
                    permissions(Manifest.permission.WRITE_CONTACTS, 3);
                }
                break;
            case R.id.S4:
                if (Checked) {
                    sw = 4;
                    permissions(Manifest.permission.RECORD_AUDIO, 4);
                }
                break;
            case R.id.S5:
                if (Checked) {
                    sw = 5;
                    permissions(Manifest.permission.ANSWER_PHONE_CALLS, 5);
                }
                break;
            default:
                break;
        }
    }
    private void tog(int requestCode){
        switch (requestCode) {
            case 1:
                sw1.toggle();
                break;
            case 2:
                sw2.toggle();
                break;
            case 3:
                sw3.toggle();
                break;
            case 4:
                sw4.toggle();
                break;
            case 5:
                sw5.toggle();
                break;
        }
    };
    private void permissions(String permission, int sw) {
        if (ContextCompat.checkSelfPermission(getBaseContext(), permission) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getBaseContext(), "Permiso Activado", Toast.LENGTH_SHORT).show();
        } else {
            requestStoragePermission(permission, sw);
        }
    }

    private void requestStoragePermission(final String permission, final int sw) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
            new AlertDialog.Builder(MainActivity.this).setTitle("Advertencia").setMessage("Necesitas el permiso, de lo contrario no funcionara").setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, sw);
                        }
                    }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tog(sw);
                    dialog.dismiss();
                }
            }).create().show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{permission}, sw);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == sw){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permiso Aceptado", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Permiso Rechazado",Toast.LENGTH_LONG).show();
                tog(requestCode);
            }
        }

    }
}
