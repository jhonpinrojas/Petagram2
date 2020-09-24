package com.jhon.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contacto> contactos;
    public ContactoAdapter adaptador;
    private RecyclerView ListaMascotas;
    private ImageButton favoritoimagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tootb = findViewById(R.id.actionbar);
        tootb.setLogo(R.drawable.icons8_dog_paw_96);

        final TextView like1;
        setSupportActionBar(tootb);

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.abejita,"Katty","5242566","5"));
        contactos.add(new Contacto(R.drawable.castor,"Mateo","4575752","3"));
        contactos.add(new Contacto(R.drawable.gato,"Garfield ","5242566","3"));
        contactos.add(new Contacto(R.drawable.perrito,"Otto","8543374","2"));
        contactos.add(new Contacto(R.drawable.zorrito,"Foxy","2773727","1"));
        ListaMascotas = findViewById(R.id.ListaMascotas);
        /*LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);*/
        GridLayoutManager glm = new GridLayoutManager(this ,2 );

        ListaMascotas.setLayoutManager(glm);
        inicializarAdaptador();
        like1 = findViewById(R.id.likenumber);
        favoritoimagen = findViewById(R.id.favoritoimagen);
        favoritoimagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(MainActivity.this, MisContactos.class);
                //intent1.putExtra("like", String.valueOf(like1));
                startActivity(intent1);

            }
        });
    }

    public void inicializarAdaptador (){
        //asigan a contacto adaptador a la lista contactos
        adaptador = new ContactoAdapter(contactos,this);
        ListaMascotas.setAdapter(adaptador);

    }
}