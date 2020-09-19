package com.santiago.listamascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.santiago.listamascotas.adaptadores.MascotaAdaptador;
import com.santiago.listamascotas.pojo.Mascota;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {
    private Toolbar toolbar;
    ArrayList<Mascota> mascotasMasLikes;
    private RecyclerView mLikes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        toolbar = (Toolbar)findViewById(R.id.toolbar_lista_mascotas);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.fav_mas
        ));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_mascota));
        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

        mascotasMasLikes =new ArrayList<Mascota>();
        mLikes=(RecyclerView)findViewById(R.id.rvfavMascotas);

        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        mLikes.setLayoutManager(llm);
        inicializarmLikes();
        inicializarAdaptador();

    }

    public void inicializarmLikes() {
        mascotasMasLikes = new ArrayList<Mascota>();

        mascotasMasLikes.add(new Mascota("Pluto", R.drawable.dog));
        mascotasMasLikes.add(new Mascota("Elephant", R.drawable.elephant));
        mascotasMasLikes.add(new Mascota("Cowie", R.drawable.cow));
        mascotasMasLikes.add(new Mascota("Simba", R.drawable.lion));
        mascotasMasLikes.add(new Mascota("Porky", R.drawable.pig));
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotasMasLikes, this);
        mLikes.setAdapter(adaptador);
    }

}