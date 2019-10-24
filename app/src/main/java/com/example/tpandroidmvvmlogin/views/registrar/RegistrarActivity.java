package com.example.tpandroidmvvmlogin.views.registrar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tpandroidmvvmlogin.R;
import com.example.tpandroidmvvmlogin.models.Usuario;
import com.example.tpandroidmvvmlogin.request.ApiClient;
import com.example.tpandroidmvvmlogin.views.login.ViewModelMain;

public class RegistrarActivity extends AppCompatActivity {

    private EditText nombre, apellido, documento, correo, clave;
    private Button guardar;
    private ViewModelRegistro vmr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        inicializar();

        vmr = ViewModelProviders.of(this).get(ViewModelRegistro.class);
        vmr.getMldUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(final Usuario usuario) {
                if(usuario != null) {
                    nombre.setText(usuario.getNombre());
                    apellido.setText(usuario.getApellido());
                    documento.setText(usuario.getDni()+"");
                    correo.setText(usuario.getCorreo());
                    clave.setText(usuario.getClave());
                } else {
                    nombre.setText("");
                    apellido.setText("");
                    documento.setText("");
                    correo.setText("");
                    clave.setText("");
                }
            }
        });

        Intent x = getIntent();

        boolean vieneDeRegistrar = x.getBooleanExtra("registrar",false);

        if(vieneDeRegistrar) {
            nombre.setText("");
            apellido.setText("");
            documento.setText("");
            correo.setText("");
            clave.setText("");
        } else {
            Usuario us = vmr.ver(getApplicationContext());
            nombre.setText(us.getNombre());
            apellido.setText(us.getApellido());
            documento.setText(us.getDni()+"");
            correo.setText(us.getCorreo());
            clave.setText(us.getClave());
        }


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long doc = Long.parseLong(documento.getText()+"");
                String nom = nombre.getText()+"";
                String ape = apellido.getText()+"";
                String corr = correo.getText()+"";
                String clav = clave.getText()+"";
                vmr.alta(getApplicationContext(),doc,nom,ape,corr,clav);
            }
        });
    }

    private void inicializar() {
       nombre = findViewById(R.id.EtNombre);
       apellido = findViewById(R.id.EtApellido);
       documento = findViewById(R.id.EtDni);
       correo = findViewById(R.id.EtCorreo);
       clave = findViewById(R.id.EtClave);
       guardar = findViewById(R.id.Guardar);
    }
}
