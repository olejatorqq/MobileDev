package ru.mirea.orlovsky.thread;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public String calculateAveragePairs(int totalPairs, int totalDays) {
        if (totalDays == 0) return "0";
        int average = totalPairs / totalDays;
        return String.valueOf(average);
    }
}
