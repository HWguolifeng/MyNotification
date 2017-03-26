package com.guolifeng.android.mynotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.send_notice:
                baseNotification();

                break;
            default:
                break;
        }
    }

    /**
     * notification 的基本用法
     */
    private void baseNotification()
    {
        //notification 的点击动作的实现
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        //获取管理器
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //创建通知
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("guoLiFeng")//标题
//                .setContentText("this is a textasfasdfsdfsdfgsfvgsdwsdfsdfgsdfgvdfgbdfgbdfgbdfgbsdfgsdfgvsdf")//内容
                .setWhen(System.currentTimeMillis())//设置时间
                .setSmallIcon(R.mipmap.ic_launcher)//设置展示的小图标
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))//设置展示的大图标
                .setContentIntent(pi)//传入意图
                .setPriority(NotificationCompat.PRIORITY_MAX)
//                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Dream.ogg")))//播放音频
//                .setVibrate(new long[]{0, 1000, 1000, 1000, 1000, 1000})//设置震动 下标为偶数表示静止的时间反之震动的时间
//                .setLights(Color.GREEN,1000,1000)
//                .setDefaults(NotificationCompat.DEFAULT_ALL)//系统自己设置
//                .setAutoCancel(true)//设置自动结束的notification
                .setStyle(new NotificationCompat.BigTextStyle().bigText("this is a textasfasdfsdfsdfgsfvgsdwsdfsdfgsdfgvdfgbdfgbdfgbdfgbsdfgsdfgvsdf"))
                .build();//完成
        manager.notify(1, notification);//显示通知
    }
}
