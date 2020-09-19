package com.santiago.listamascotas.pojo;

import java.io.Serializable;
import java.text.BreakIterator;
import java.util.Date;

public class Mascota implements Serializable {

    private int id;
    private int favorito;
    private String nombre;
    private int imagen;
    private Date ultimosLikes;

    public Mascota() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getUltimosLikes() {
        return ultimosLikes;
    }

    public void setUltimosLikes(Date ultimosLikes) {
        this.ultimosLikes = ultimosLikes;
    }

}
