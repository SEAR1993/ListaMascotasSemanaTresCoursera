package com.santiago.listamascotas.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.santiago.listamascotas.R;
import com.santiago.listamascotas.pojo.Mascota;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>{

    ArrayList<Mascota> perfilMascotas;
    Activity activity;
    public PerfilAdaptador(ArrayList<Mascota> perfilMascotas, Activity activity) {
        this.perfilMascotas = perfilMascotas;
        this.activity = activity;
    }
    @NonNull
    @Override
    public PerfilAdaptador.PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PerfilAdaptador.PerfilViewHolder holder, final int position) {
        final Mascota perfil = perfilMascotas.get(position);
        holder.likes_galeria.setText(String.valueOf(perfil.getFavorito()));
        //holder.fotoGaleria.setImageResource(perfil.getImagen());


    }

    @Override
    public int getItemCount() {return perfilMascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {
        private ImageView fotoGaleria;
        private TextView likes_galeria;
        private ImageView huesoGaleria;

        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoGaleria= itemView.findViewById(R.id.fotoGaleria);
            likes_galeria= itemView.findViewById(R.id.likes_galeria);
            huesoGaleria=itemView.findViewById(R.id.huesoGaleria);
        }
    }
}