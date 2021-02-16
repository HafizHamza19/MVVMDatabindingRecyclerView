package com.hafizhamza.mvvmdatabindingrecyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.hafizhamza.mvvmdatabindingrecyclerview.model.ModelClass;
import com.hafizhamza.mvvmdatabindingrecyclerview.databinding.RvListBinding;

import com.hafizhamza.mvvmdatabindingrecyclerview.viewmodel.ModelItemClass;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    List<ModelClass> data;
    LayoutInflater layoutInflater;
    public MainAdapter()
    {
this.data=new ArrayList<>();
    }
    @NonNull
    @Override
    public MainAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(layoutInflater==null)
            layoutInflater=LayoutInflater.from(parent.getContext());
//        RvListBinding rvListBinding =
//                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
//                        R.layout.rv_list, parent, false);
        RvListBinding binding= DataBindingUtil.inflate(layoutInflater,R.layout.rv_list,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MyViewHolder holder, int position) {
        ModelClass modelClass=data.get(position);
        Log.d("TAGGOnBindview",data.get(1).getFname());
        holder.rvListBinding.setModel(new ModelItemClass(modelClass));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateData(List<ModelClass> data) {
        Log.d("TAGG",data.get(1).getFname());
if (data==null||data.isEmpty())
{
    this.data.clear();
}else {
    this.data.addAll(data);
}
notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private RvListBinding rvListBinding;
        public MyViewHolder(RvListBinding binding) {
            super(binding.getRoot());
            this.rvListBinding=binding;
        }
    }
}
