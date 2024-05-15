package ru.mirea.orlovsky.toastapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }
    public void calculateCharacterCount(View view) {
        String inputText = editText.getText().toString();
        int charCount = inputText.length();

        // Выводим Toast с количеством символов
        String toastMessage = "Количество символов: " + charCount;
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }
}

