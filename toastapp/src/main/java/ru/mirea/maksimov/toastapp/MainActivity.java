package ru.mirea.maksimov.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick1(View view) {
        EditText editText = findViewById(R.id.editTextTextPersonName);
        Toast toast = Toast.makeText(this,
                "СТУДЕНТ №12 ГРУППА БСБО-17-20 КОЛИЧЕСТВО СИМВОЛОВ " + editText.getText().toString().length(),
            Toast.LENGTH_LONG
        );
        toast.show();
    }
}