package com.example.icities;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelFragment extends ViewModel {

    private MutableLiveData<String> liveData;

    public LiveData<String> getData(){
        if (liveData!=null){
            setData(liveData.getValue());
        } else {
            liveData=new MutableLiveData<String>();
        }
        return liveData;
    }

    public void setData(String t){
        if (liveData==null) {
            liveData=new MutableLiveData<>();
        }
        liveData.setValue(t);
    }

}