package com.example.persistenciat5;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.persistenciat5.adaptador.PageAdapter;
import com.example.persistenciat5.vistafragment.PerfilFragment;
import com.example.persistenciat5.vistafragment.RecyclerViewFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity { public ImageButton btnEstrella;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar miActionBarbtn = findViewById(R.id.miActionBarbtn);
        setSupportActionBar(miActionBarbtn);


        toolbar = (Toolbar)  findViewById(R.id.toolbar);
        tabLayout = (TabLayout)  findViewById(R.id.tabLayout);
        viewPager = (ViewPager)  findViewById(R.id.viewPager);
        setUpViewPager();

        btnEstrella = (ImageButton)  findViewById(R.id.btnEstrella);


        if ((toolbar != null)){
            setSupportActionBar(toolbar);
        }


        btnEstrella.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Top 5 de Animales ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetalleMascota.class);
                startActivity(intent);

            }
        });
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.pets1);
        tabLayout.getTabAt(1).setIcon(R.drawable.pets1);
    }
    private void setSupportActionBar(Toolbar miActionBarbtn) {
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