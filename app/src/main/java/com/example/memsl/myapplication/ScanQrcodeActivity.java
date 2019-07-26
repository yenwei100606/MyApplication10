package com.example.memsl.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;

public class ScanQrcodeActivity extends AppCompatActivity {
    private SurfaceView sf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qrcode);

        sf = (SurfaceView) findViewById(R.id.test);
    }
}
