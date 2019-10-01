package com.example.weatherlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.ResultSetMetaData;

public class MainActivity extends AppCompatActivity {

    TextView weatherNow;
    ImageView weatherIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        weatherNow = findViewById(R.id.weatherNow);
        weatherIcon = findViewById(R.id.weatherIcon);
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonUpdate:
                long temp = Math.round((Math.random() * 15) + 10);
                long wind = Math.round(Math.random() * 10);
                String text = "Сейчас " + temp + "℃, " + wind + "м/c";
                if (temp<16) {
                    weatherIcon.setImageResource(R.drawable.cloudy);
                } else {
                    weatherIcon.setImageResource(R.drawable.sunny);
                }
                weatherNow.setText(text);
                break;

            case R.id.buttonKeanu:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("<—Keanu says:")
                        .setMessage("You are breathtaking!")
                        .setIcon(R.drawable.keanu)
                        .setCancelable(false)
                        .setNeutralButton("No, you are breathtaking!",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

        }
    }
}
