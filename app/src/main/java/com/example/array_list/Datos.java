package com.example.array_list;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

//extends de baseAdapter y generar metodos
//base Adapter  Muestra inforrmacion del archivo XML
public class Datos extends BaseAdapter {
    //Variables globales
    //Layout inflater se utiliza para instanciar el archivo de diseño y que se muestre en MainActivity
    LayoutInflater inflater = null;
    //generar los datos
    Context context;
    String titulos[];
    String descripciones[];
    int avatar[];
    //generamos constructor

    public Datos( Context context, String[] titulos, String[] descripciones, int[] avatar) {

        this.context = context;
        this.titulos = titulos;
        this.descripciones = descripciones;
        this.avatar = avatar;

        //Iniializar Inflater
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

       //Generamos la vista y asignar mediante inflate los elementos del archivo xml
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vista = inflater.inflate(R.layout.item_fila, null);
        //Referenciar
        TextView Titulo = vista.findViewById(R.id.titulo);
        TextView Descripcion = vista.findViewById(R.id.descripcion);
        ImageView Avatar = vista.findViewById(R.id.avatar);

        //asignar datos a cada una de las posiciones
        Titulo.setText(titulos[position]);
        Descripcion.setText(descripciones[position]);
        Avatar.setImageResource(avatar[position]);

        Avatar.setTag(position); //asociamos info a un View
        Avatar.setOnClickListener(new View.OnClickListener() { //Iniciamos Accion para onClick

            @Override
            public void onClick(View v) {
             Intent Ver_Imagen = new Intent(context, Ver_Imagen.class);
             Ver_Imagen.putExtra("IMG", avatar[(Integer)v.getTag()]); //nos envia el id de la imagen
             context.startActivity(Ver_Imagen); //Iniciamos la actividad
            }
        });


        return vista;
    }

    @Override
    public int getCount() {
        return avatar.length;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

}
