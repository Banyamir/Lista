package com.example.array_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //private ImageView avatar2;
    private TextView tv1;
    private TextView tv;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;

    private ListView lista;  //Agregamos en la lista los datos
    String titulos []={ "Juan", "Mario", "Mariana", "Juan", "Ricardo", "Pedro", "Diego", "Rocio"};
    String descripciones[]={"Ing. Sistemas", "Piloto", "Novelista", "Cantante", "Abogado", "Militar", "Ing. Sistemas", "Arquitecta"};
    int avatar[]={R.drawable.ba, R.drawable.bb,  R.drawable.bc,  R.drawable.bd,  R.drawable.be, R.drawable.bf,
            R.drawable.bg,  R.drawable.bh};
    String edades[]={"34","35","70","30","45","30","85","40"};
    String telefono[]={"2265893567","263892657","6222478654","5268937657","1826637819","1726527399","187364987", "1237364987"};
    String ciudades[]={"México","Colima","Veracruz","Tlaxcala","Tijuana","Tamaulipas","Oaxaca","Veracruz"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciamos lista
        lista = (ListView) findViewById(R.id.lista);

        //avatar2= (ImageView) findViewById(R.id.avatar2);
        tv1 =(TextView)findViewById(R.id.tv1);
        tv =(TextView)findViewById(R.id.tv);
        tv3 =(TextView)findViewById(R.id.tv3);
        tv4 =(TextView)findViewById(R.id.tv4);
        tv5 =(TextView)findViewById(R.id.tv5);


        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,R.layout.item_fila, titulos );
        lista.setAdapter(adapter);

        //Instanciar elementos que contiene la lista mediante SetAdapter
        lista.setAdapter (new Datos(this, titulos,descripciones,avatar ));

        // mostar informacion, mediante Método OnClick
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                tv1.setText("Su Nombre  " + "es: " + titulos[position] + "   \n" );
                tv.setText("Su edadad " + "es de: " + edades[position] + "  años \n" );
                tv3.setText("Su profesion es: " + descripciones[position] +"\n" );
                tv4.setText("Su telefono es:  "  + telefono[position] +"\n" );
                tv5.setText("Vive en:  "  + ciudades[position] + "\n" );
            }
        });

    }

}