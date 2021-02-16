package com.hafizhamza.mvvmdatabindingrecyclerview.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.hafizhamza.mvvmdatabindingrecyclerview.BR;
import com.hafizhamza.mvvmdatabindingrecyclerview.MainAdapter;
import com.hafizhamza.mvvmdatabindingrecyclerview.model.ModelClass;

import java.util.ArrayList;
import java.util.List;

public class DataViewModel extends BaseObservable {
    List<ModelClass> data;
    MainAdapter adapter;
    public DataViewModel() {
        data=new ArrayList<>();
        adapter=new MainAdapter();
    }
    @BindingAdapter({"app:adapter","app:data"})
    public static void bind(RecyclerView recyclerView,MainAdapter adapter,List<ModelClass> data)
    {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data);
    }
    public void setdata() {
        SetDataonList();
    }
    @Bindable
    public List<ModelClass> getData() {
        return data;
    }
    @Bindable
    public MainAdapter getAdapter() {
        return adapter;
    }

    private void SetDataonList() {
    for (int i=0;i<10;i++)
    {
        ModelClass modelClass=new ModelClass();
        modelClass.setFname("Hafiz "+i);
        modelClass.setLname("Hamza "+i);
        data.add(modelClass);
    }
    notifyPropertyChanged(BR.data);
    }

}
