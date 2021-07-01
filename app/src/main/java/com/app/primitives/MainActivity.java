package com.app.primitives;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {

    public DrawingView dv;
    public int defaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dv= findViewById(R.id.drawingView);

        findViewById(R.id.btnRect).setOnClickListener(v -> dv.setShape(DrawingView.RECTANGLE));
        findViewById(R.id.btnLine).setOnClickListener(v -> dv.setShape(DrawingView.LINE));
        findViewById(R.id.btnCircle).setOnClickListener(v -> dv.setShape(DrawingView.CIRCLE));
        findViewById(R.id.btnSquare).setOnClickListener(v -> dv.setShape(DrawingView.SQUARE));
        findViewById(R.id.btnPencil).setOnClickListener(v -> dv.setShape(DrawingView.SMOOTHLINE));
        findViewById(R.id.btnClear).setOnClickListener(v -> dv.setShape(DrawingView.CLEAR));

        defaultColor = Color.BLACK;

        findViewById(R.id.btnColor).setOnClickListener(v -> openColorPicker());

    }
    public void openColorPicker(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                defaultColor = color;
                dv.mPaintFinal.setColor(defaultColor);
                dv.mPaint.setColor(defaultColor);

            }
        });
        colorPicker.show();
    }

}