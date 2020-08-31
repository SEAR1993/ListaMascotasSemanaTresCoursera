package com.santiago.listamascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota>mascotas;
    private RecyclerView ListaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mascotas =new ArrayList<Mascota>();
        ListaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);
        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        ListaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas, this);
        ListaMascotas.setAdapter(adaptador);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent=new Intent(this, About.class);
                startActivity(intent);
                break;
            case R.id.mSettings:
                Intent i = new Intent(this, Settings.class);
                startActivity(i);
                break;
        }
        switch (item.getItemId()){
            case R.id.btnFav:
                Intent i = new Intent(this, ListaMascotas.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}