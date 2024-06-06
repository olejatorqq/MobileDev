package ru.mirea.orlovsky.looper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class MyLooper extends Thread {
    public Handler mHandler;
    private final Handler mainThreadHandler;

    public MyLooper(Handler mainThreadHandler) {
        this.mainThreadHandler = mainThreadHandler;
    }

    @Override
    public void run() {
        Looper.prepare();
        mHandler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(Message msg) {
                try {
                    String ageStr = msg.getData().getString("AGE");
                    int age = Integer.parseInt(ageStr);
                    String job = msg.getData().getString("JOB");
                    Thread.sleep(age * 1000);
                    Message mainMsg = mainThreadHandler.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putString("result", "Age: " + age + ", Job: " + job);
                    mainMsg.setData(bundle);
                    mainThreadHandler.sendMessage(mainMsg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Looper.loop();
    }
}
