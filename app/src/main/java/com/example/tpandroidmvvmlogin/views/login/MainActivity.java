package com.example.tpandroidmvvmlogin.views.login;

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
import com.example.tpandroidmvvmlogin.views.registrar.RegistrarActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usuarioCorreo, clave;
    private Button logear, registar;
    private ViewModelMain vmm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

        registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),RegistrarActivity.class);
                i.putExtra("registrar",true);
                startActivity(i);
            }
        });
        logear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario res = vmm.enviarUsuario(getApplicationContext(),usuarioCorreo.getText()+"",clave.getText()+"");
                if(res == null) {
                    Toast.makeText(MainActivity.this, "No existe", Toast.LENGTH_SHORT).show();
                } else {
                    //entra a el segundo activity.
                    Intent i = new Intent(getApplicationContext(),RegistrarActivity.class);
                    i.putExtra("registrar",false);
                    startActivity(i);
                }
            }
        });
        vmm = ViewModelProviders.of(this).get(ViewModelMain.class);

    }

    private void inicializar() {
        usuarioCorreo = findViewById(R.id.EtUsuarioCorreo);
        clave = findViewById(R.id.EtClave);
        logear = findViewById(R.id.btnLogin);
        registar = findViewById(R.id.btnRegistrar);
    }
}
