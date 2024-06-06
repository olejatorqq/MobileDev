package ru.mirea.orlovsky.intentapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.textView);
        String currentTime = getIntent().getStringExtra("current_time");

        int myNumber = 14;
        int squaredNumber = myNumber * myNumber;
        String resultText = "КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ "
                + squaredNumber + ", а текущее время " + currentTime;

        textView.setText(resultText);
    }
}

