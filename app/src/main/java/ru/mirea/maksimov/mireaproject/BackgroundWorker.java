package ru.mirea.maksimov.mireaproject;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class BackgroundWorker extends Worker {

    private static final String TAG = "BackgroundWorker";

    public BackgroundWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            Thread.sleep(5000);
            Data inputData = getInputData();
            String value = inputData.getString("key");
            Log.d(TAG, "Фоновая задача выполнена. Значение: " + value);

            Data outputData = new Data.Builder()
                    .putString("result", "Задача выполнена успешно")
                    .build();

            return Result.success(outputData);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
    }
}
