package ru.mirea.orlovsky.lesson1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewAvatar;
    private TextView textViewName;
    private EditText editTextBirthday, editTextEmail, editTextPhone;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson1_layout);

        imageViewAvatar = findViewById(R.id.imageViewAvatar);
        textViewName = findViewById(R.id.textViewName);
        editTextBirthday = findViewById(R.id.editTextBirthday);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        buttonSave = findViewById(R.id.buttonSave);

        textViewName.setText("Walter White");
        imageViewAvatar.setImageResource(R.drawable.walter_white);

        buttonSave.setOnClickListener(view -> {
            String birthday = editTextBirthday.getText().toString();
            String email = editTextEmail.getText().toString();
            String phone = editTextPhone.getText().toString();
            String gender = radioButtonMale.isChecked() ? "Мужской" : "Женский";

            System.out.println("Дата рождения: " + birthday);
            System.out.println("Email: " + email);
            System.out.println("Номер телефона: " + phone);
            System.out.println("Пол: " + gender);
        });
    }
}
