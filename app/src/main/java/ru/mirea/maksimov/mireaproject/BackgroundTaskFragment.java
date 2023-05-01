package ru.mirea.maksimov.mireaproject;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

public class BackgroundTaskFragment extends Fragment {

    private static final String TAG = "BackgroundTaskFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Создаем входные данные для фоновой задачи (необязательно)
        Data inputData = new Data.Builder()
                .putString("key", "value")
                .build();
        WorkRequest workRequest = new OneTimeWorkRequest.Builder(BackgroundWorker.class)
                .setInputData(inputData)
                .build();
        WorkManager.getInstance(requireContext()).enqueue(workRequest);
    }
}
