package ru.mirea.orlovsky.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import ru.mirea.orlovsky.thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new MainViewModel();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        String mainThreadName = Thread.currentThread().getName();
        binding.tvThreadName.setText("Main Thread: " + mainThreadName);

        Thread.currentThread().setName("NewMainThreadName");
        binding.tvThreadName.setText("New Main Thread: " + Thread.currentThread().getName());

        binding.btnCalculate.setOnClickListener(v -> {
            int totalPairs = Integer.parseInt(binding.etTotalPairs.getText().toString());
            int totalDays = Integer.parseInt(binding.etTotalDays.getText().toString());

            new Thread(() -> {
                String averagePairs = viewModel.calculateAveragePairs(totalPairs, totalDays);

                new Handler(Looper.getMainLooper()).post(() -> binding.tvAveragePairs.setText("Average Pairs: " + averagePairs));
            }).start();
        });
    }
}
