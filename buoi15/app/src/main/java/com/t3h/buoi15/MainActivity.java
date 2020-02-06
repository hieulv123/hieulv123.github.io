package com.t3h.buoi15;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.t3h.basemodule.base.ActivityBase;
import com.t3h.basemodule.base.FragmentBase;
import com.t3h.buoi15.Service.MP3Service;
import com.t3h.buoi15.databinding.ActivityMainBinding;
import com.t3h.buoi15.fragment.Album.AlbumFragment;
import com.t3h.buoi15.fragment.Artist.ArtistFragment;
import com.t3h.buoi15.fragment.Song.SongFragment;

public class MainActivity extends ActivityBase<ActivityMainBinding> implements BottomNavigationView.OnNavigationItemSelectedListener {
    private SongFragment fmSong = new SongFragment();
    private AlbumFragment fmAlbum = new AlbumFragment();
    private ArtistFragment fmArtist = new ArtistFragment();
    private MP3Service service ;
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void init() {

        doRequestPermission(
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                new RequestPermissionCallback() {
                    @Override
                    public void onGranted() {

                        Intent intent = new Intent(
                                MainActivity.this ,
                                MP3Service.class
                                ) ;

                        bindService(intent,connection ,BIND_AUTO_CREATE );



                        setSupportActionBar(MainActivity.this.binding.toolbar);
                        MainActivity.this.getSupportActionBar().setHomeButtonEnabled(true);
                        MainActivity.this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                        mDrawerToggle = new ActionBarDrawerToggle(
                                MainActivity.this,
                                MainActivity.this.binding.drawerLayout,
                                MainActivity.this.binding.toolbar,
                                R.string.app_name,
                                R.string.app_name);
                        MainActivity.this.binding.drawerLayout.addDrawerListener(mDrawerToggle);
                        mDrawerToggle.syncState();

                    }

                    @Override
                    public void onDenied() {
                    }

                }
        );

    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            MP3Service.MP3Binder binder = (MP3Service.MP3Binder) iBinder ;
            service = binder.getService() ;
            initFragment();
            binding.nav.setOnNavigationItemSelectedListener(MainActivity.this);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    } ;

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fmSong);
        transaction.add(R.id.container, fmAlbum);
        transaction.add(R.id.container, fmArtist);
        transaction.commit();
        showFragment(fmSong);

    }

    private void showFragment(FragmentBase fmShow) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        transaction.hide(fmSong);
        transaction.hide(fmArtist);
        transaction.hide(fmAlbum);
        transaction.show(fmShow);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_song:
                showFragment(fmSong);
                break;
            case R.id.nav_artist:
                showFragment(fmArtist);
                break;
            case R.id.nav_album:
                showFragment(fmAlbum);
                break;

        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    public MP3Service getService() {
        return service;
    }
}
