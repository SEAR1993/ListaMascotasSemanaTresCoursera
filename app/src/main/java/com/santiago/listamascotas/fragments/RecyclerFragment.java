package com.santiago.listamascotas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.santiago.listamascotas.R;
import com.santiago.listamascotas.adaptadores.MascotaAdaptador;
import com.santiago.listamascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        mascotas =new ArrayList<Mascota>();
        rvMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm =new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        rvMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Pluto", R.drawable.dog));
        mascotas.add(new Mascota("Mishu", R.drawable.cat));
        mascotas.add(new Mascota("Twitter", R.drawable.twitter));
        mascotas.add(new Mascota("Elephant", R.drawable.elephant));
        mascotas.add(new Mascota("Bullie", R.drawable.bull));
        mascotas.add(new Mascota("Cowie", R.drawable.cow));
        mascotas.add(new Mascota("Simba", R.drawable.lion));
        mascotas.add(new Mascota("Porky", R.drawable.pig));
    }

}

