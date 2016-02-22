package com.example.zhaoting.qiandao.module.activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.utils.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhaoting on 16/1/12.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    public UserAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(position + "");

    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.id_tv_user)
        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Utils.ToastShort("onClick" + getPosition());
                }
            });
        }


    }
}
