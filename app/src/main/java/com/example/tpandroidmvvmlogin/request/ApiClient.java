package com.example.tpandroidmvvmlogin.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.tpandroidmvvmlogin.models.Usuario;

public class ApiClient {
    private static SharedPreferences sp;

    private static SharedPreferences conectar (Context context) {
        if(sp == null) {
            sp = context.getSharedPreferences("datos",0);
        }
        return sp;
    }

    public static void guardar(Context context, Usuario usuario) {
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("Documento",usuario.getDni());
        editor.putString("Nombre",usuario.getNombre());
        editor.putString("Apellido",usuario.getApellido());
        editor.putString("Correo",usuario.getCorreo());
        editor.putString("Clave",usuario.getClave());
        editor.commit();
        Toast.makeText(context, "Exito", Toast.LENGTH_SHORT).show();
    }

    public static Usuario leer(Context context) {
        SharedPreferences sp = conectar(context);
        Long dni = sp.getLong("Documento",-1);
        String nombre = sp.getString("Nombre","-1");
        String apellido = sp.getString("Apellido","-1");
        String correo = sp.getString("Correo","-1");
        String clave = sp.getString("Clave","-1");

        Usuario us = new Usuario(dni,nombre,apellido,correo,clave);
        return  us;
    }

    public static Usuario login(Context context, String corr, String clav) {
        Usuario us = null;
        SharedPreferences sp = conectar(context);

        Long dni = sp.getLong("Documento",-1);
        String nombre = sp.getString("Nombre","-1");
        String apellido = sp.getString("Apellido","-1");
        String correo = sp.getString("Correo","-1");
        String clave = sp.getString("Clave","-1");

        if(corr.equals(correo) && clav.equals(clave)) {
            us = new Usuario(dni,nombre,apellido,correo,clave);
        }
        return  us;
    }
}
