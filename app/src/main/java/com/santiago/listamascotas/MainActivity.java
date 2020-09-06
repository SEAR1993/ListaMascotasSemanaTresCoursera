package com.santiago.listamascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.santiago.listamascotas.adaptadores.PageAdapter;
import com.santiago.listamascotas.fragments.PerfilFragment;
import com.santiago.listamascotas.fragments.RecyclerFragment;
import com.santiago.listamascotas.menuopciones.About;
import com.santiago.listamascotas.menuopciones.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_mascota));


        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewpager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> agregarFraments(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new RecyclerFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }
    private void setUpViewPager(){

        viewpager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFraments()));
        tabLayout.setupWithViewPager(viewpager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil_mascota);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.btnFav:
                Intent i = new Intent(this, ListaMascotas.class);
                startActivity(i);
                break;
        }
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent=new Intent(this, About.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                Intent i = new Intent(this, Contacto.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}