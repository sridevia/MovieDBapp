package com.example.sridevi.moviedbapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicationBetweenFrag{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  getSupportFragmentManager().beginTransaction().add(R.id.search_container, SearchMovieFragment.newInstance(), "searchMoview").commit();
    }

    @Override
    public void respond(String data) {

        FragmentManager fragmentManager=getFragmentManager();
        MovieDetailsFragment moviefrag= (MovieDetailsFragment) fragmentManager.findFragmentById(R.id.detailsMovie_frag);


    }
}
