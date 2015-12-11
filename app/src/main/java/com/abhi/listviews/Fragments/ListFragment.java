package com.abhi.listviews.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.abhi.listviews.DataType.Ingredient;
import com.abhi.listviews.R;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {

    int i=0;
    ListView list_view;

View view;
    List<Ingredient> ingredientsList= new ArrayList<Ingredient>();
    Ingredient ingredient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_list, container, false);
        list_view=(ListView)view.findViewById(R.id.list_view);
        for(i=0;i<=100;i++)
        {
            String kl= String.valueOf(i);
            ingredientsList.add(new Ingredient(kl));
        }        final ArrayAdapter<Ingredient> adapter = new ArrayAdapter<Ingredient>(getActivity(),R.layout.quant_row_item,ingredientsList);
        adapter.notifyDataSetChanged();
                list_view.setAdapter(adapter);

        return view;



    }

}
