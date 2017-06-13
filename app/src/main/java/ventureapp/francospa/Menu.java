package ventureapp.francospa;

import java.util.ArrayList;

/**
 * Created by VENTURE on 30/01/2017.
 */

public class Menu {
    private int idImagen;
    private String titulo;

    public Menu(){
        idImagen=0;
        titulo="";
    }
    public Menu(int idImagen, String titulo){
            this.titulo=titulo;
            this.idImagen=idImagen;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<Menu>listaMenu(){

        Menu menu;
        ArrayList<Menu> lista = new ArrayList<Menu>();

        Integer[]IdImagenes=new Integer[]{R.drawable.francospa,R.drawable.francospa2,R.drawable.francospa3,R.drawable.francospa4,
                R.drawable.francospa5,R.drawable.francospa6,R.drawable.francospa7,R.drawable.francospa8,
                R.drawable.francospa9,R.drawable.francospa11,R.drawable.francospa20,};
        String[]titulos=new String[]{"Mira que bonito quedo :3","Feliz de su corte","Nuestros clientes nos respaldan",
                "El engreido de la casa","Tu puedes ser el siguiente","Eres el mejor de todos","Estoy feliz de mi corte"
        ,"Gracias por mi corte","Me siento feliz","Gracias a mi amor estoy asi :D","Estoy kawai :3 :3 :3 :3 "};

        for (int i=0; i<IdImagenes.length;i++){
            menu = new Menu(IdImagenes[i],titulos[i]);
            lista.add(menu);  }
        return lista;
    }
}
