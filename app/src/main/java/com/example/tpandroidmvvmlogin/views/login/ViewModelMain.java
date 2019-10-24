package com.example.tpandroidmvvmlogin.views.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpandroidmvvmlogin.models.Usuario;

public class ViewModelMain extends ViewModel {

    private MutableLiveData<Usuario> mldUsuario;

    public LiveData<Usuario> getMldUsuario() {
        if(mldUsuario==null) {
            mldUsuario = new MutableLiveData<>();
        }
        return mldUsuario;
    }


}
