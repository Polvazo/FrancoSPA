package ventureapp.francospa;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ResideMenu resideMenu;
    private ResideMenuItem itemHome;
    private ResideMenuItem itemProfile;
    private ResideMenuItem itemCalendar;
    private ResideMenuItem itemSettings;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        setUpMenu();

        if(savedInstanceState == null){
            changeFragment(new HomeFragment());

        }
    }

    private void setUpMenu() {
    //attach menu to current activity
        resideMenu = new ResideMenu(this);

        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);

        //setting width of the menu using scale factor between 0.1 f to 1.0 f
        resideMenu.setScaleValue(0.6f);

        //adding munu items
        itemHome = new ResideMenuItem(this,R.drawable.quienessomos,"¿Quiénes Somos?");
        itemProfile = new ResideMenuItem(this,R.drawable.nuestrsotrabajos,"Nuestros Trabajos");
        itemCalendar = new ResideMenuItem(this,R.drawable.llamame,"Llámame");
        itemSettings = new ResideMenuItem(this,R.drawable.estoyaqui,"Estoy Aquí");

        itemHome.setOnClickListener(this);
        itemSettings.setOnClickListener(this);
        itemCalendar.setOnClickListener(this);
        itemProfile.setOnClickListener(this);

        resideMenu.addMenuItem(itemHome,ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemProfile,ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemCalendar,ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemSettings,ResideMenu.DIRECTION_RIGHT);

        //you can disable a side by -->
     //   resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });

        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
           // Toast.makeText(mContext,"Menu is opened!",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            //Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View v) {

        if(v == itemHome){
            changeFragment(new HomeFragment());
        }else if(v == itemProfile){
            changeFragment(new ProfileFragment());
        }else if(v == itemCalendar){
            changeFragment(new CalendarFragment());
        }else if(v == itemSettings){
            changeFragment(new SettingsFragment());
        }

        resideMenu.closeMenu();
    }

    private void changeFragment(Fragment targetFragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment,targetFragment,"fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();


    }

public ResideMenu getResideMenu(){
    return resideMenu;
}
}
