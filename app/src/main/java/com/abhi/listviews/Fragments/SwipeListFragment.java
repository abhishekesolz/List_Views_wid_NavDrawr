package com.abhi.listviews.Fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.abhi.listviews.DataType.Ingredient;
import com.abhi.listviews.R;
import com.abhi.listviews.SwipeListView.SwipeMenu;
import com.abhi.listviews.SwipeListView.SwipeMenuCreator;
import com.abhi.listviews.SwipeListView.SwipeMenuItem;
import com.abhi.listviews.SwipeListView.SwipeMenuListView;

import java.util.ArrayList;
import java.util.List;


public class SwipeListFragment extends Fragment {

    int i=0;
    private SwipeMenuListView swipelistview;

View view;
    List<Ingredient> ingredientsList= new ArrayList<Ingredient>();
    Ingredient ingredient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_swipelist, container, false);
        swipelistview=(SwipeMenuListView)view.findViewById(R.id.swipe_listView);

        for(i=0;i<=100;i++)
        {
            String kl= String.valueOf(i);
            ingredientsList.add(new Ingredient(kl));
        }        final ArrayAdapter<Ingredient> adapter_swipe = new ArrayAdapter<Ingredient>(getActivity(),R.layout.swipe_row_item,ingredientsList);
//        adapter.notifyDataSetChanged();

        Log.d("array",ingredientsList.toString());
        swipelistview.setAdapter(adapter_swipe);




        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getActivity());

                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getActivity());
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                deleteItem.setWidth(dp2px(90));

                deleteItem.setIcon(R.drawable.ic_menu_share);
                menu.addMenuItem(deleteItem);
            }
        };

        swipelistview.setMenuCreator(creator);



        swipelistview.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(final int position, SwipeMenu menu, int index) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

                alertDialog.setTitle("Confirm Delete...");

                alertDialog.setMessage("Are you sure you want delete this?");

                alertDialog.setIcon(R.drawable.ic_menu_share);

                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                ingredient=ingredientsList.get(position);
                                adapter_swipe.remove(ingredient);
                                adapter_swipe.notifyDataSetChanged();
                                swipelistview.setAdapter(adapter_swipe);


                            }
                        });
                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                // Showing Alert Message
                alertDialog.show();
                return false;
            }
        });



        swipelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });


        swipelistview.setOnSwipeListener(new SwipeMenuListView.OnSwipeListener() {

            @Override
            public void onSwipeStart(int position) {
            }

            @Override
            public void onSwipeEnd(int position) {
            }
        });




        return view;



    }
    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

}
