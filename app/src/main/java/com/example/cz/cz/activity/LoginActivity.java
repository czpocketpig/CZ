package com.example.cz.cz.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cz.cz.R;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import entity.User;
import okhttp3.Call;
import okhttp3.Request;
import utils.SPUtil;

import static android.content.ContentValues.TAG;


public class LoginActivity extends Activity implements OnClickListener {


    private EditText password, account;
    private View mProgressView;
    private View mLoginFormView;
    private SPUtil spUtil;
    private Button sign;
    private View pro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        getData();


    }

    void initView() {
        password = findViewById(R.id.password);
        account = findViewById(R.id.account);
        sign = findViewById(R.id.sign_in_button);
        spUtil = new SPUtil(this, "user");
        pro = findViewById(R.id.login_progress);
        mLoginFormView = findViewById(R.id.login_form);
        sign.setOnClickListener(this);

    }

    void getData() {
    }

    void doLogin() {
        OkHttpUtils
                .post()
                .url(URLManger.LOGIN_URL)
                .addParams("name", account.getText().toString())
                .addParams("pwd", password.getText().toString())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i(TAG, "onError: " + e.toString());

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        User user=new User();
                        Gson gson=new Gson();
                        Log.i(TAG, "=======> "+response.toString()+id);
                         if (null != response &&  !"".equals(response))
                         {
                             user=gson.fromJson(response.toString(),User.class);
                             Log.i(TAG, "=======> " +URLManger.LOGIN_URL );
                             spUtil.putString("username",user.getName());
                             spUtil.putString("pwd",user.getPwd());
                             spUtil.putInt("id",user.getId());
                             startActivity(new Intent(LoginActivity.this, Home.class));
                         }


                    }
                });

//        OkHttpUtils
//                .post()
//                .url("http://192.168.0.108:8080/LibraryManagement/loginApp?name=tom&pwd=123")
//                .addParams("name", "hyman")
//                .addParams("pwd", "123")
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        Log.d(TAG, "onResponse: =====" + response);
//                    }
//                });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_in_button:
                doLogin();


        }
    }
}

