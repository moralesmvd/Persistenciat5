package com.example.persistenciat5.vistafragment;

import com.example.persistenciat5.pojo.Mascota;


import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador);


}

