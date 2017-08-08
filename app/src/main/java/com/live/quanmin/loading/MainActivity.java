package com.live.quanmin.loading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRvMain;
    private LoadingRelativeLayout mLrlRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLrlRoot = (LoadingRelativeLayout) findViewById(R.id.lrv_root);

        mLrlRoot.setViewStatus(LoadingRelativeLayout.STATUS_LOADING);

        mRvMain = (RecyclerView) findViewById(R.id.rv_main);
        mRvMain.setLayoutManager(new LinearLayoutManager(this));

        mLrlRoot.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRvMain.setAdapter(new TestAdapter());
                mLrlRoot.setViewStatus(LoadingRelativeLayout.STATUS_CONTENT);
                mLrlRoot.setViewStatus(LoadingRelativeLayout.STATUS_EMPTY);
                mLrlRoot.setViewStatus(LoadingRelativeLayout.STATUS_ERROR);
            }
        }, 5000);
    }

}
