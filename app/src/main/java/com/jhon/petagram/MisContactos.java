package com.jhon.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MisContactos extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    public ContactoAdapter adaptador1;
    private RecyclerView FavoritosMascotas;
    //String like1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_contactos);
        Toolbar tootb = findViewById(R.id.actionbar);
        setSupportActionBar(tootb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tootb.setLogo(R.drawable.icons8_dog_paw_96);
        tootb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        contactos = new ArrayList<Contacto>();
       /* Bundle paramentros = getIntent().getExtras();
        int like    = paramentros.getInt("like");
        like1   = String.valueOf(like);*/
        contactos.add(new Contacto(R.drawable.abejita,"Katty","5242566","5"));
        contactos.add(new Contacto(R.drawable.castor,"Mateo","4575752","3"));
        contactos.add(new Contacto(R.drawable.gato,"Garfield ","5242566","3"));
        contactos.add(new Contacto(R.drawable.perrito,"Otto","8543374","3"));
        contactos.add(new Contacto(R.drawable.zorrito,"Foxy","2773727","1"));
        FavoritosMascotas = findViewById(R.id.FavoritosMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        FavoritosMascotas.setLayoutManager(llm);
        inicializarAdaptador();

    }
    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent= new Intent(MisContactos.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
    public void inicializarAdaptador (){
        //asigan a contacto adaptador a la lista contactos
        adaptador1 = new ContactoAdapter(contactos,this);
        FavoritosMascotas.setAdapter(adaptador1);

    }
}
