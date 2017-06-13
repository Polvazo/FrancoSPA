package ventureapp.francospa;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class DialogFragmentGaleria extends DialogFragment {
    View view;
    TextView titulo;
    ImageView imagen;
    RecyclerView recyclerViewgaleria;

    ArrayList<Menu> listaMenu;
    RecyclerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view    = inflater.inflate(R.layout.fragment_dialog_fragment_galeria, container, false);
        titulo = (TextView)view.findViewById(R.id.titulo);
        imagen = (ImageView)view.findViewById(R.id.imagen);
        recyclerViewgaleria=(RecyclerView)view.findViewById(R.id.galeria);

        //Para regresar o cerrar
        /*imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              getDialog().dismiss();
            }
        });*/

        recyclerViewgaleria.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        listaMenu= new Menu().listaMenu();
        adapter=new RecyclerAdapter(listaMenu, new RecyclerAdapter.OnClickRecycler() {
            @Override
            public void OnClickItemRecycler(Menu menu) {
                Glide.with(getContext()).load(menu.getIdImagen()).into(imagen);
                titulo.setText(menu.getTitulo());
            }
        });

        recyclerViewgaleria.setAdapter(adapter);
        return view;
    }


}
