package com.jhon.petagram;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>
{
    ArrayList <Contacto> contactos;
    Activity activity;
    String valor;
    public int v1;
    public ContactoAdapter (ArrayList<Contacto> contactos,Activity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }
    //inflar el layout y lo pasara al vieholder para que el obtena cada elemento view
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);// inflar la lista y crear los cardview
        //Asociar layout card_view a nuestro recicler view mediante el adapter
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        //setear los valores de la lista de contactos,asocia cada elemento de la lista con cada view
        final Contacto contacto = contactos.get(position);

        holder.imageView.setImageResource(contacto.getFoto());
        holder.name.setText(contacto.getNombre());
        holder.likenumber.setText(contacto.getLike());
        holder.imagebuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Diste like " + contacto.getNombre(),Toast.LENGTH_LONG).show();
                v1 = Integer.parseInt(contacto.getLike());
                v1++;
                valor = String.valueOf(v1);
                contacto.setLike(valor);
            }
        });
    }

    @Override
    public int getItemCount() { //cantidad de elememntos que contienela lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name;
        private ImageButton imagebuton;
        public TextView likenumber;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView   = (ImageView) itemView.findViewById(R.id.imageView);
            name        = itemView.findViewById(R.id.name);
            imagebuton = itemView.findViewById(R.id.imagebuton);
            likenumber      = itemView.findViewById(R.id.likenumber);

        }
    }
}
