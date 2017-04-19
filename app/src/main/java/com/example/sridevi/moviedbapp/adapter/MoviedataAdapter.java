package com.example.sridevi.moviedbapp.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sridevi.moviedbapp.R;

/**
 * Created by Sridevi on 4/14/2017.
 */
public class MoviedataAdapter extends BaseAdapter {

    public Context mcontext;
    public String[] mtitles;
    //public String[] mdesc;

    public MoviedataAdapter(Context context,String[] titles){

        mcontext = context;
        mtitles = titles;
      //  mdesc = desc;

    }


    @Override
    public int getCount() {
        return mtitles.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowview = null;

        LayoutInflater layoutInflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rowview = layoutInflater.inflate(R.layout.layout_list,null);

        TextView tv;
        tv = (TextView)rowview.findViewById(R.id.text_list);
        tv.setText(mtitles[i]);
        return rowview;



    }
}
