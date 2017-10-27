package com.example.cz.cz.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.cz.cz.R;

import utils.NetworkConnected;
import utils.SPUtil;

/**
 * Created by Administrator on 2017/10/26.
 */

public class Welcome extends Activity {
    private SPUtil spUtil;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        spUtil=new SPUtil(this,"user");
        if (!NetworkConnected.isNetworkConnected(Welcome.this)) {
            Toast.makeText(Welcome.this, "当前网络状态不佳", Toast.LENGTH_SHORT).show();
        }
        //方法一：开启一个子线程执行跳转任务
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                        Thread.sleep(2000);
                        if(spUtil.contains("account")){
                            startActivity(new Intent(Welcome.this, Home.class));
                            finish();
                        }else{
                            startActivity(new Intent(Welcome.this, LoginActivity.class));
                            finish();
                        }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();



    }
}
