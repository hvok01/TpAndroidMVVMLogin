package com.example.tpandroidmvvmlogin.views.registrar;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpandroidmvvmlogin.models.Usuario;
import com.example.tpandroidmvvmlogin.request.ApiClient;

public class ViewModelRegistro extends ViewModel {

    private MutableLiveData<Usuario> mldUsuario;
    private ApiClient api;

    public LiveData<Usuario> getMldUsuario() {
        if(mldUsuario==null) {
            mldUsuario = new MutableLiveData<>();
        }
        return mldUsuario;
    }

    public void alta(Context context, Long doc, String nom, String ape, String corr, String clav) {
        Usuario us = new Usuario(doc,nom,ape,corr,clav);
        api.guardar(context, us);
    }

    public Usuario ver(Context context) {
        Usuario us;
        us = api.leer(context);
        return  us;
    }
}
