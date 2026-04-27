package com.bartoszarcab.android_custom_view_kwadraty;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class Kwadraty extends View {

    public Kwadraty(Context context) {
        super(context);
    }

    public Kwadraty(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Kwadraty(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int szer = getWidth();
        int wys  = getHeight();

        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setStyle(Paint.Style.FILL);
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            p.setARGB(255, r.nextInt(256), r.nextInt(256), r.nextInt(256));

            // --- Wersja z kółkami ---
            // canvas.drawCircle(r.nextInt(szer), r.nextInt(wys), r.nextInt(100), p);

            // --- Wersja z kwadratami ---
            int side = r.nextInt(200) + 20;
            int x    = r.nextInt(Math.max(1, szer - side));
            int y    = r.nextInt(Math.max(1, wys  - side));
            canvas.drawRect(x, y, x + side, y + side, p);
        }

        // Borderline
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(5);
        p.setColor(Color.YELLOW);
        canvas.drawRect(2, 2, szer - 3, wys - 3, p);

        super.onDraw(canvas);
    }
}