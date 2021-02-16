package com.hafizhamza.mvvmdatabindingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.hafizhamza.mvvmdatabindingrecyclerview.databinding.ActivityMainBinding;
import com.hafizhamza.mvvmdatabindingrecyclerview.viewmodel.DataViewModel;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
private DataViewModel dataViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
       dataViewModel=new DataViewModel();
        binding.setViewmodel(dataViewModel);
        dataViewModel.setdata();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataViewModel.setdata();
    }
}
