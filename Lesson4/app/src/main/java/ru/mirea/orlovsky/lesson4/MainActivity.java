package ru.mirea.orlovsky.lesson4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import ru.mirea.orlovsky.lesson4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Инициализация binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Установите необходимые слушатели и логику для элементов управления
        binding.playButton.setOnClickListener(v -> {
            // Логика воспроизведения музыки
            binding.songTitle.setText("Playing...");
        });

        // Другие настройки элементов управления
    }
}
