package com.example.tpandroidmvvmlogin.views.login;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpandroidmvvmlogin.models.Usuario;
import com.example.tpandroidmvvmlogin.request.ApiClient;

public class ViewModelMain extends ViewModel {

    private MutableLiveData<Usuario> mldUsuario;
    private ApiClient api;

    public LiveData<Usuario> getMldUsuario() {
        if(mldUsuario==null) {
            mldUsuario = new MutableLiveData<>();
        }
        return mldUsuario;
    }

    public Usuario enviarUsuario(Context context, String correo, String clave) {
        if(correo!= "" && clave != "") {
            Usuario us = api.login(context,correo,clave);
            return us;
        } else {
            return  null;
        }
    }
}
