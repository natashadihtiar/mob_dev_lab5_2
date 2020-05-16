package com.example.lab5_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Receiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Запрос на отправку смс
        requestSmsPermission();
    }
    //Запрос на отправку смс
    private void requestSmsPermission() {
        //Условие разрешения или отказа
        if (checkSelfPermission(Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            String msg = "Разрешение получить сообщение";
            msg += (grantResults[0] == PackageManager.PERMISSION_GRANTED) ? " предоставлен" : " не предоставлен";
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    //Зарегестрирвоан в манифесте
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    //Не зарегестрирован в манифесте
        if (receiver != null)
            unregisterReceiver(receiver);
    }
}