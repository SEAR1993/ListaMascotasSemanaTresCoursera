package com.santiago.listamascotas.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.santiago.listamascotas.R;

import com.santiago.listamascotas.adaptadores.MascotaAdaptador;
import com.santiago.listamascotas.adaptadores.PerfilAdaptador;
import com.santiago.listamascotas.pojo.Mascota;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {
    private TextView nombre_perfil;
    private CircularImageView circularImageView;
    RecyclerView rvPerfilMascotas;
    ArrayList<Mascota> perfilMascotas;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.perfil_recyclerview, container, false);

        //Cambia la imagen y nombre al dar click.

        /*Intent intent=getActivity().getIntent();
        String nombre = intent.getStringExtra(MascotaAdaptador.EXTRA_NOMBRE);
        //int imagen = intent.getIntExtra("EXTRA_IMAGEN",0);
        circularImageView=v.findViewById(R.id.circularImageView);
        nombre_perfil=v.findViewById(R.id.nombre_perfil);
        nombre_perfil.setText(nombre);
        //circularImageView.setImageResource(imagen);*/

        perfilMascotas = new ArrayList<>();
        rvPerfilMascotas = v.findViewById(R.id.rvPerfilMascotas);
        GridLayoutManager glm =new GridLayoutManager(getActivity(),3);
        glm.setOrientation(RecyclerView.VERTICAL);
        rvPerfilMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();

        CircularImageView circularImageView = v.findViewById(R.id.circularImageView);
        // Set Color
        circularImageView.setCircleColor(Color.WHITE);
        // or with gradient
        circularImageView.setCircleColorStart(Color.WHITE);
        circularImageView.setCircleColorEnd(Color.BLUE);
        circularImageView.setCircleColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

        // Set Border
        circularImageView.setBorderWidth(10f);
        circularImageView.setBorderColor(Color.BLACK);
        // or with gradient
        circularImageView.setBorderColorStart(Color.WHITE);
        circularImageView.setBorderColorEnd(Color.BLUE);
        circularImageView.setBorderColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

        // Add Shadow with default param
        circularImageView.setShadowEnable(false);
        // or with custom param
        circularImageView.setShadowRadius(7f);
        circularImageView.setShadowColor(Color.BLUE);
        circularImageView.setShadowGravity(CircularImageView.ShadowGravity.CENTER);



        return v;
    }
    public void inicializarAdaptador() {
        PerfilAdaptador adaptador= new PerfilAdaptador(perfilMascotas, getActivity());
        rvPerfilMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        perfilMascotas = new ArrayList<>();

        perfilMascotas.add(new Mascota(R.drawable.twitter, 4));
        perfilMascotas.add(new Mascota(R.drawable.twitter,7));
        perfilMascotas.add(new Mascota(R.drawable.twitter,2));
        perfilMascotas.add(new Mascota(R.drawable.twitter,9));
        perfilMascotas.add(new Mascota(R.drawable.twitter,5));
        perfilMascotas.add(new Mascota(R.drawable.twitter,6));
        perfilMascotas.add(new Mascota(R.drawable.twitter,8));
        perfilMascotas.add(new Mascota(R.drawable.twitter,3));
        perfilMascotas.add(new Mascota(R.drawable.twitter,1));
    }

}
