package com.example.waterfall;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private androidx.recyclerview.widget.RecyclerView RecyclerView;
    private androidx.recyclerview.widget.RecyclerView RecyclerView1;


    Float[] floats={
            2f,4f,5.5f
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        List<Float> floatList = new ArrayList<>();
        List<Float> floatList1 = new ArrayList<>();
        for(int i=0;i<15;i++){
            floatList.add(floats[new Random().nextInt(3)]);
            floatList1.add(floats[new Random().nextInt(3)]);
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager =new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        RecyclerView.setLayoutManager(staggeredGridLayoutManager);


        RecyclerView1.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
     //   RecyclerView1.setLayoutManager(new GridLayoutManager(this,2));
        RecyclerView.setAdapter(new RecyclerViewAdapter(this,floatList));
        RecyclerView1.setAdapter(new RecyclerViewAdapter1(this,floatList1));
       // RecyclerView1.setAdapter(new );




       // RecyclerView.setBackgroundColor(R.color.red);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                OkHttpClient okHttpClient =new OkHttpClient();
//                Request request =new Request.Builder()
//                        .url("http://apis.juhe.cn/cxdq/brand?key=5f2035b9997dffb1715dc966375462a1")
//                        .build();
//                Call call = okHttpClient.newCall(request);
//                try {
//                    Response response = call.execute();
//                    assert response.body() != null;
//                    Bean bean = new Gson().fromJson(response.body().string(),Bean.class);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            RecyclerView.setAdapter(new RecyclerViewAdapter(MainActivity.this,bean.getResult()));
//                        }
//                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

    }
    static void get(){
        OkHttpClient okHttpClient =new OkHttpClient();
        Request request =new Request.Builder()
                .url("http://apis.juhe.cn/cxdq/brand?key=5f2035b9997dffb1715dc966375462a1")
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        RecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        RecyclerView1 = (RecyclerView) findViewById(R.id.RecyclerView1);
    }
}