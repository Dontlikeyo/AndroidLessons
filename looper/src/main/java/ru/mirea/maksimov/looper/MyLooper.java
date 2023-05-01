package ru.mirea.maksimov.looper;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import android.os.Handler;

import java.util.concurrent.TimeUnit;

public	class MyLooper extends Thread{
    public Handler mHandler;
    private	Handler	mainHandler;
    public	MyLooper(Handler mainThreadHandler) {
        mainHandler	= mainThreadHandler;
    }
    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();
        mHandler = new Handler(Looper.myLooper())	{
            public void handleMessage(Message msg)	{
                String	data = msg.getData().getString("KEY");
                String job = msg.getData().getString("job");
                Log.d("MyLooper	get	message: ", data);
                long delay = TimeUnit.SECONDS.toMillis(Integer.parseInt(data));
                Log.d("MyLooper Delay in ms: ", String.valueOf(delay));
                int	count	=	data.length();
                Message	message	=	new	Message();
                Bundle bundle	=	new	Bundle();
                bundle.putString("result",	String.format("Мне: " +data+ " я работаю: "+job));
                message.setData(bundle);
                mainHandler.sendMessage(message);
            }
        };
        Looper.loop();
    }
}