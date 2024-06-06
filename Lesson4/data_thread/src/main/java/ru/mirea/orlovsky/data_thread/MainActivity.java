package ru.mirea.orlovsky.data_thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import ru.mirea.orlovsky.data_thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnStart.setOnClickListener(v -> {
            StringBuilder processInfo = new StringBuilder();

            // Метод post
            new Handler(Looper.getMainLooper()).post(() -> {
                processInfo.append("post method executed\n");
                binding.tvProcessInfo.setText(processInfo.toString());
            });

            // Метод postDelayed
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                processInfo.append("postDelayed method executed\n");
                binding.tvProcessInfo.setText(processInfo.toString());
            }, 1000);

            // Метод runOnUiThread
            runOnUiThread(() -> {
                processInfo.append("runOnUiThread method executed\n");
                binding.tvProcessInfo.setText(processInfo.toString());
            });

            // Сравнение методов
            processInfo.append("\nDifferences:\n");
            processInfo.append("1. post: Executes a Runnable immediately if called from the main thread, otherwise posts it to the main thread.\n");
            processInfo.append("2. postDelayed: Posts a Runnable to the main thread to be executed after a specified delay.\n");
            processInfo.append("3. runOnUiThread: A method in Activity to run code on the main thread, typically used from background threads.\n");

            binding.tvProcessInfo.setText(processInfo.toString());
        });
    }
}
