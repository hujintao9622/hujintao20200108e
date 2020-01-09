package com.bawei.hujintao.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.hujintao.R;
import com.bawei.hujintao.model.bean.AddressBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/9 0009 上午 8:59
 */
public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.MyViewHolder> {
    private List<AddressBean.ResultBean> list;

    public AddressAdapter(List<AddressBean.ResultBean> result) {

        list = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_address, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AddressBean.ResultBean resultBean = list.get(position);
        holder.itName.setText(resultBean.getRealName());
        holder.itPhone.setText(resultBean.getPhone());
        holder.itAddress.setText(resultBean.getAddress());
        holder.itRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.itUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.it_name)
        TextView itName;
        @BindView(R.id.it_phone)
        TextView itPhone;
        @BindView(R.id.it_address)
        TextView itAddress;
        @BindView(R.id.it_rb)
        RadioButton itRb;
        @BindView(R.id.it_update)
        Button itUpdate;
        @BindView(R.id.it_delete)
        Button itDelete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void OnItemClick();
    }
}
