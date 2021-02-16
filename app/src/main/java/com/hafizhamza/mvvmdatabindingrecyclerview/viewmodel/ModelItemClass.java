package com.hafizhamza.mvvmdatabindingrecyclerview.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.hafizhamza.mvvmdatabindingrecyclerview.model.ModelClass;

public class ModelItemClass extends BaseObservable {
    ModelClass modelClass;
    public ModelItemClass(ModelClass modelClass) {
        this.modelClass=modelClass;
    }
    @Bindable
    public String getFirst()
    {
        return modelClass.getFname();
    }
    public void setFirst(String first)
    {
        modelClass.setFname(first);
        notifyPropertyChanged(BR.first);
    }
    @Bindable
    public String getLast()
    {
        return modelClass.getLname();
    }
    public void setLast(String last)
    {
        modelClass.setLname(last);
        notifyPropertyChanged(BR.last);
    }
}
