package com.anfaas.doctorauthenticator.ui.about;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class aboutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public aboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is about fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}