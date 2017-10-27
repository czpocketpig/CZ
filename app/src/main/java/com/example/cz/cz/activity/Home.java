package com.example.cz.cz.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.SearchView;
import com.example.cz.cz.R;

import java.util.ArrayList;
import java.util.List;

import adapter.BookAdapter;
import entity.BookInfo;

/**
 * Created by Administrator on 2017/10/25.
 */




public class Home extends Activity {
    private SearchView bookSearch;
    private RecyclerView recyclerView;
    private BookAdapter bookadapter;
     private RecyclerView.LayoutManager lay;
    private   List<BookInfo> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        getData();
        lay=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lay);
        bookadapter = new BookAdapter(list);
        recyclerView.setAdapter(bookadapter);

    }




    void  initView (){
        bookSearch=findViewById(R.id.book_search);
        recyclerView=findViewById(R.id.recycleview);

    }


    void  getData(){
       list=new ArrayList<BookInfo>();

        for (int i = 0; i <20 ; i++) {
            BookInfo book=new BookInfo();
            book.setBookname("测试书名"+i);
            book.setPubilsher("测试测试出版社"+i);
            book.setPlace("测试地点"+i);
            book.setAuthor("测试作者"+i);
            book.setBorrow(true);
            list.add(book);
        }

    }
}
