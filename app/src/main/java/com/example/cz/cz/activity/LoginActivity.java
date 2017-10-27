package com.example.cz.cz.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cz.cz.R;

import utils.SPUtil;



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
        if (password.getText().toString().equals("123456") && account.getText().toString().equals("123456")) {
            spUtil.putString("password", "123456");
            spUtil.putString("account", "123456");
            startActivity(new Intent(this, Home.class));
            finish();
        } else {
            Toast.makeText(this, "账号密码错误", Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_in_button:
                doLogin();


        }
    }
}

