package ru.mirea.maksimov.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(ShareActivity.class.getSimpleName(), "Opoen ShareActivity");

        setContentView(R.layout.activity_share);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView textView = findViewById(R.id.textView);
            String university = extras.getString(MainActivity.KEY);
            textView.setText(String.format("Мой любимая книга: %s", university));
        }

    }

    public void returnUserBook(View view) {
        // Отправка введенных пользователем данных по нажатию на кнопку
        Intent data = new Intent();
        EditText editText = findViewById(R.id.EditText);
        data.putExtra(MainActivity.USER_MESSAGE, editText.getText().toString());
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}