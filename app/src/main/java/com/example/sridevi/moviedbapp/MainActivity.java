package com.example.sridevi.moviedbapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CommunicationBetFrag{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//       // FragmentManager fragmentManager = getSupportFragmentManager();
//        //SearchMovieFragment searchMovieFragment = (SearchMovieFragment) fragmentManager.findFragmentById(R.id.searchMovie_frag);
//        SearchMovieFragment fragment = new SearchMovieFragment();
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        fragment.beginTransaction().add(R.id.searchMovie_frag,fragment).commit();

        Toast.makeText(getApplicationContext(),"msg",Toast.LENGTH_SHORT).show();
}
    @Override
    public void respond(int i){
        FragmentManager fragmanager = getFragmentManager();
        MovieDetailsFragment movfrag = (MovieDetailsFragment)fragmanager.findFragmentById(R.id.detailsMovie_frag);
        movfrag.changeText(i);

}
}