package com.example.persistenciat5.vistafragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.persistenciat5.R;
import com.example.persistenciat5.pojo.Mascota;
import com.example.persistenciat5.presentador.IRecyclerViewFragmentPresenter;
import com.example.persistenciat5.presentador.RecyclerViewFragmentPresenter;


import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    ArrayList <Mascota> mascotas;
    public RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this vista.vistafragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        rvMascotas = ( RecyclerView) v.findViewById(R.id.rvMascotasFragment);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(linearLayoutManager);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());

        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}