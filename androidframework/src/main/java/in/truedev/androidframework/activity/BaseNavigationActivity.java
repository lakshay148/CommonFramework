package in.truedev.androidframework.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

/**
 * @author lakshaygirdhar
 * @version 1.0
 * @since 24/10/16
 */

public abstract class BaseNavigationActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, getToolBar(), R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(getNavigationHeader() != null)
            navigationView.addHeaderView(getNavigationHeader());

        navigationView.inflateMenu(getNavigationMenu());

    }

    public abstract int getNavigationMenu();

    protected View getNavigationHeader(){
        return null;
    }

    @Override
    public String getScreenName()
    {
        return null;
    }

    public View getActivityLayout(){
        View view = View.inflate(this,R.layout.navigation_layout,null);
        FrameLayout navigationFrame = (FrameLayout) view.findViewById(R.id.contentFrameNavigation);
        getLayoutInflater().inflate(getLayout(),navigationFrame);
        return view;
    }

    public abstract int getLayout();

    public abstract Toolbar getToolBar();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
