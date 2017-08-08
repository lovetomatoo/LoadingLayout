package com.live.quanmin.loading;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by guo_hx on 2017/7/18 10:41.
 */

public class LoadingRelativeLayout extends RelativeLayout {

    private static final String TAG = LoadingRelativeLayout.class.getSimpleName();

    public static final int STATUS_CONTENT = 0;//show content
    public static final int STATUS_LOADING = 1;//show loading
    public static final int STATUS_ERROR = 2;//show error
    public static final int STATUS_EMPTY = 3;//show empty

    //loading data default
    private static int LOADING_ANIM = R.drawable.anim_loading;
    private static String LOADING_TXT = "正在努力加载中...";

    //error data default
    private static int ERROR_PIC = R.mipmap.img_tips_no_network;
    private static String ERROR_TXT = "加载失败...";

    //empty data default
    private static int EMPTY_PIC = R.mipmap.img_tips_no_data;
    private static String EMPTY_TXT = "啥都木有...";

    private int mViewStatus = STATUS_LOADING;//default status

    //view
    private ImageView mIv;
    private TextView mTv;
    private LinearLayout mLLRoot;

    public LoadingRelativeLayout(Context context) {
        this(context, null);
    }

    public LoadingRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public LoadingRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        LayoutInflater.from(getContext()).inflate(R.layout.view_loading, this);

        mLLRoot = (LinearLayout) findViewById(R.id.ll_root);
        mIv = (ImageView) findViewById(R.id.iv);
        mTv = (TextView) findViewById(R.id.tv);

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.LoadingRelativeLayout);

        int status = a.getResourceId(R.styleable.LoadingRelativeLayout_loading_status, STATUS_LOADING);

        switch (status) {
            case STATUS_CONTENT: {
                mViewStatus = STATUS_CONTENT;
            }
            break;
            case STATUS_LOADING: {
                mViewStatus = STATUS_LOADING;
            }
            break;
            case STATUS_ERROR: {
                mViewStatus = STATUS_ERROR;
            }
            break;
            case STATUS_EMPTY: {
                mViewStatus = STATUS_EMPTY;
            }
            break;
            default:
                throw new RuntimeException("status not fount exception");
        }

        a.recycle();

        refreshView();
    }

    private void refreshView() {
        switch (mViewStatus) {
            case STATUS_CONTENT: {
                //show content
                mLLRoot.setVisibility(GONE);
            }
            break;
            case STATUS_LOADING: {
                //show loading
                mIv.setImageResource(LOADING_ANIM);
                ((AnimationDrawable) mIv.getDrawable()).start();
                mTv.setText(LOADING_TXT);
            }
            break;
            case STATUS_ERROR: {
                //show error
                mIv.setImageResource(ERROR_PIC);
                mTv.setText(ERROR_TXT);
            }
            break;
            case STATUS_EMPTY: {
                //show empty
                mIv.setImageResource(EMPTY_PIC);
                mTv.setText(EMPTY_TXT);
            }
            break;
        }
    }


    //-------------------------PUBLIC MEHTOD------------------------------------//

    public void setViewStatus(int status) {
        if (status != mViewStatus) {
            mViewStatus = status;
            refreshView();
        }
    }

}
