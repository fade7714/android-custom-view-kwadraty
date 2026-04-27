package com.bartoszarcab.android_custom_view_kwadraty;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Wywoływana przez android:onClick w XML — metoda odświeża grafikę */
    public void kliknieto(View v) {
        v.invalidate();
    }
}