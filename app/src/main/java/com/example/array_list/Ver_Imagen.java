package com.example.array_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Ver_Imagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver__imagen);

        ImageView Avatar = (ImageView)findViewById(R.id.imagenGrande);

        Intent intent=getIntent();  //Creamos un Intent
        Bundle b=intent.getExtras();//Budle nos permite obtener los datos

        if(b!=null){ //se verifica que no sea nulo
            Avatar.setImageResource(b.getInt("IMG"));

        }


    }
}