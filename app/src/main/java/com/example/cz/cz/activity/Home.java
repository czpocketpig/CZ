package com.example.cz.cz.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.SearchView;
import android.util.Log;

import com.example.cz.cz.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import adapter.BookAdapter;
import entity.BookInfo;
import entity.User;
import okhttp3.Call;
import utils.SPUtil;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2017/10/25.
 */


public class Home extends Activity {
    private SearchView bookSearch;
    private RecyclerView recyclerView;
    private BookAdapter bookadapter;
    private RecyclerView.LayoutManager lay;
    private List<BookInfo> list;
    private SPUtil spUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        getData();
        lay = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lay);


    }


    void initView() {
        bookSearch = findViewById(R.id.book_search);
        recyclerView = findViewById(R.id.recycleview);
        spUtil = new SPUtil(this, "user");

    }


    void getData() {
        OkHttpUtils
                .get()
                .url(URLManger.PERSON_URL)
                .addParams("userId", spUtil.getInt("id", 0) + "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i(TAG, "onError: " + e.toString());

                    }

                    @Override
                    public void onResponse(String response, int id) {


                        if (null != response &&  !"".equals(response)) {

                            list=new Gson().fromJson(response.toString(), new TypeToken<List<BookInfo>>(){}.getType());
                            bookadapter = new BookAdapter(list);
                            recyclerView.setAdapter(bookadapter);
                        }


                    }
                });


    }
}
