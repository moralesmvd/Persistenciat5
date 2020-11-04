package com.example.persistenciat5;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.persistenciat5.adaptador.MascotaAdaptador;
import com.example.persistenciat5.pojo.Mascota;


import java.util.ArrayList;

public class DetalleMascota extends AppCompatActivity {

    ArrayList <Mascota> mascotas;
    public RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);
        androidx.appcompat.widget.Toolbar miActionBar = findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotasFragment);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

    }

    private void setSupportActionBar(Toolbar miActionBar) {
    }

    private void setSupportActionBar(ActionBar miActionBar) {

    }

    public void inicializarAdaptador (){
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas,this);
        rvMascotas.setAdapter(mascotaAdaptador);
    }


    public void inicializarListaContactos () {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.gato1, "Kero", 0));
        mascotas.add(new Mascota(R.drawable.gato2, "Pikachu", 0));
        mascotas.add(new Mascota(R.drawable.gato3, "Ramon", 0));
        mascotas.add(new Mascota(R.drawable.gato4, "Pato", 0));
        mascotas.add(new Mascota(R.drawable.gato5, "Milu", 0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(this, ActivityAcerca.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                Intent i = new Intent(this, ActivityContacto.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}