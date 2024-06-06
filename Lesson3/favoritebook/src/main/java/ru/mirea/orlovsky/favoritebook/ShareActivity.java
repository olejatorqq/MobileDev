package ru.mirea.orlovsky.favoritebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        TextView textViewDeveloperBook = findViewById(R.id.textViewDeveloperBook);
        EditText editTextUserBook = findViewById(R.id.editTextUserBook);
        Button buttonSendBook = findViewById(R.id.buttonSendBook);

        // Получение данных из MainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String developerBook = extras.getString(MainActivity.KEY);
            textViewDeveloperBook.setText("Любимая книга разработчика – " + developerBook);
        }

        // Отправка введенных пользователем данных по нажатию на кнопку
        buttonSendBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userBook = editTextUserBook.getText().toString();
                Intent data = new Intent();
                data.putExtra(MainActivity.USER_MESSAGE, userBook);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}
