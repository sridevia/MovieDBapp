package com.example.sridevi.moviedbapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sridevi.moviedbapp.adapter.MoviedataAdapter;
import com.example.sridevi.moviedbapp.utilities.NetworkManager;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchMovieFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SearchMovieFragment#newInstance} factory method to
 * create an instance of this fragment.
 */ //
public class SearchMovieFragment extends Fragment{

    public static final String TAG = "SearchMovieFragment";
    private OnFragmentInteractionListener mListener;

    private TextView mSearchTextView;
    private EditText mEditText;
    private ListView list;
    String[] titles = {"Avatar","X-men","Spider man"};
    int counter = 0;
    CommunicationBetFrag commfrag;
    public SearchMovieFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SearchMovieFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchMovieFragment newInstance() {
        SearchMovieFragment fragment = new SearchMovieFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        if(savedInstanceState == null)
//        {
//            counter = 0;
//        }
//        else {
//            counter = savedInstanceState.getInt("counter",0);
//        } implements AdapterView.OnItemClickListener

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_movie,container,false);

        }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //View rootView = inflater.inflate(R.layout.fragment_search_movie, container, false);

        // mSearchTextView = (TextView)getActivity().findViewById(R.id.search_textview);
        mEditText = (EditText) getActivity().findViewById(R.id.enetr_movie);
        commfrag = (CommunicationBetFrag) getActivity();
        list = (ListView) getActivity().findViewById(R.id.listView);

        Button mSearchButton = (Button) getActivity().findViewById(R.id.submit_button);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchMovie();
//                counter++;
//                commfrag.respond("The button counter times: " + counter);

      //          ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),R.array.titles,android.R.layout.activity_list_item);
                //ArrayAdapter adapter = new ArrayAdapter(this,R.array.titles,R.layout.layout_list);
                //list.setOnClickListener(this);
                MoviedataAdapter adapter = new MoviedataAdapter(getActivity(),titles);
                list.setAdapter(adapter);

           //     list.setOnClickListener(this);

         //      list.setOnItemClickListener((AdapterView.OnItemClickListener) getActivity());
            }
        });
        //return rootView;

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                commfrag.respond(i);
            }
        });


    }

//
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//
//        commfrag.respond(i);
//    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //outState.putInt("counter",counter);

    }
    private void searchMovie() {
           String searchText = mEditText.getText().toString();
        Request movieSearchRequest = NetworkManager.getInstance().createSearchRequest(searchText);
        NetworkManager.getInstance().getOkHttpClient().newCall(movieSearchRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, response.body().source().toString());
                }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

//    @Override

//    @Override
//    public void onClick(View view) {
//
//         }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
