package com.live.quanmin.loading;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by guo_hx on 2017/7/18 11:06.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.Holder> {

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.mTvTitle.setText("title     " + position);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    static class Holder extends RecyclerView.ViewHolder {

        private TextView mTvTitle;

        public Holder(View itemView) {
            super(itemView);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

}
