package ventureapp.francospa;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment implements OnMapReadyCallback {


    public SettingsFragment() {
        // Required empty public constructor
    }

    static View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View decorView = getActivity().getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        if(view==null){
            view = inflater.inflate(R.layout.fragment_settings, container, false);
        }

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        SupportMapFragment fragment = new SupportMapFragment();
        transaction.add(R.id.fragmentMapa, fragment);
        transaction.commit();
        fragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap map) {

        LatLng position = new LatLng(-12.0119045,-76.8228431);

        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

           map.moveCamera(CameraUpdateFactory.newLatLngZoom(position,15));
            // Zoom in, animating the camera.
            map.animateCamera(CameraUpdateFactory.zoomIn());

            map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

             map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.icmarker))
                .position(position)
                .title("FRANCO SPA")
                .snippet("UCV 26 Lote 25 Zona B - Huaycan"));



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        Fragment fragment = (fm.findFragmentById(R.id.fragmentMapa));

        if(fragment!=null){
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(fragment);
        ft.commit();}
    }
}
