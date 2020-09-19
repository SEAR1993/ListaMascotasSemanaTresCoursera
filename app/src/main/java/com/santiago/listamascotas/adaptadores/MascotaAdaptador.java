package com.santiago.listamascotas.adaptadores;

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

import com.santiago.listamascotas.R;
import com.santiago.listamascotas.db.ConstructorMascotas;
import com.santiago.listamascotas.fragments.PerfilFragment;
import com.santiago.listamascotas.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    //public static final String EXTRA_NOMBRE = "com.santiago.listamascotas.adaptadores.EXTRA_NOMBRE";

    int like;
    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_listamascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, final int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.tvNombreMAscota.setText(mascota.getNombre());
        mascotaViewHolder.imgFoto.setImageResource(mascota.getImagen());
        mascotaViewHolder.tvContador.setText(String.valueOf(mascota.getFavorito()));

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvContador.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));

            }
        });
    }

    @Override
    public int getItemCount() { return mascotas.size();}

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvNombreMAscota;
        private TextView tvContador;
        private ImageButton btnLike;
        private ImageView ivFav;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreMAscota=(TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvContador=(TextView)itemView.findViewById(R.id.tvContador);
            btnLike = (ImageButton)itemView.findViewById(R.id.btnLike);
            ivFav =(ImageView)itemView.findViewById(R.id.iv_fav);
        }
    }

}


