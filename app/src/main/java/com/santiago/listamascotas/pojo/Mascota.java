package com.santiago.listamascotas.pojo;

import java.text.BreakIterator;

public class Mascota {


    int favorito;
    private String nombre;
    private int imagen;

    public Mascota(int imagen, int favorito){
        this.favorito=favorito;
        this.imagen=imagen;
    }

    public Mascota(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getImagen() {return imagen;}

    public void setImagen(int imagen) {this.imagen = imagen;}

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

}