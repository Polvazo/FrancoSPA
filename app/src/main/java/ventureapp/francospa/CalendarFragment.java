package ventureapp.francospa;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class   CalendarFragment extends DialogFragment {


    public CalendarFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View decorView = getActivity().getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;

        decorView.setSystemUiVisibility(uiOptions);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(CalendarFragment.this.getContext());
        View mview = LayoutInflater.from(getActivity()).inflate(R.layout.contacto,null);
        mBuilder.setView(mview);
        AlertDialog dialog = mBuilder.create();
        dialog.show();

        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }



}
