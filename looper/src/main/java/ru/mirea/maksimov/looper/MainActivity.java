package ru.mirea.maksimov.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

import ru.mirea.maksimov.looper.databinding.ActivityMainBinding;

public	class	MainActivity	extends	AppCompatActivity	{
    private ActivityMainBinding binding;
    MyLooper looper;
    @Override
    protected	void	onCreate(Bundle	savedInstanceState)	{
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding	= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Handler mainThreadHandler =	new	Handler(Looper.getMainLooper())	{
            @Override
            public void handleMessage(Message msg) {
                Log.d(MainActivity.class.getSimpleName(), "Task execute. This is result: "	+ msg.getData().getString("result"));

            }
        };
        MyLooper myLooper = new	MyLooper(mainThreadHandler);
        myLooper.start();
        binding.editTextMirea.setText("Мой номер по списку №12");
        binding.buttonMirea.setOnClickListener(new	View.OnClickListener()	{
            @Override
            public	void onClick(View v) {
                int age = 21;
                Message	msg	=	Message.obtain();
                Bundle	bundle	=	new	Bundle();
                bundle.putString("KEY","21");
                bundle.putString("job", " Каменщиком");
                msg.setData(bundle);
                myLooper.mHandler.sendMessage(msg);
            }

        });
    }
}
