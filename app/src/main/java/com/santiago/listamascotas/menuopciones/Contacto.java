package com.santiago.listamascotas.menuopciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.santiago.listamascotas.javamail.JavaMailAPI;
import com.santiago.listamascotas.R;

public class Contacto extends AppCompatActivity {
    private Toolbar toolbar;

    public EditText mSubject;
    public EditText mEmail;
    public EditText mMesage;
    public Button boton_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.name_contacto));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_mascota));
        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

        mSubject =(EditText)findViewById(R.id.tiet_nombre);
        mEmail=(EditText)findViewById(R.id.tiet_email);
        mMesage=(EditText)findViewById(R.id.tiet_mensaje);
        boton_send=(Button)findViewById(R.id.boton_send);
        boton_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });

    }
    private void enviarEmail(){
        String mail=mEmail.getText().toString().trim();
        String message=mMesage.getText().toString();
        String subject=mSubject.getText().toString().trim();

        JavaMailAPI javaMailAPI=new JavaMailAPI(this,mail,subject,message);
        javaMailAPI.execute();
    }
}