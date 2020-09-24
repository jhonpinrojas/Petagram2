package com.jhon.petagram;


public class Contacto {
    private String nombre;
    private String telefono;
    private String like;
    private int foto;



    public Contacto(int foto, String nombre, String telefono, String like) {
        this.foto=foto;
        this.nombre = nombre;
        this.telefono = telefono;
        this.like= like;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

}
