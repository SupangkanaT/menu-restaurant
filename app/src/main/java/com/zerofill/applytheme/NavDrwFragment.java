package com.zerofill.applytheme;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kronosboy on 15/02/16.
 */
public class NavDrwFragment extends Fragment {

    private ActionBarDrawerToggle mDrwToggle;
    private DrawerLayout mDrwLayout;
    private RecyclerView recyclerViewMain;
    private Context mainContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_drw, container, false);

        setUpRecyclerView(v);

        return v;
    }

    private void setUpRecyclerView(View v) {

        RecyclerView rv = (RecyclerView)v.findViewById(R.id.drwList);


        adapter = new NavigationDrawerAdapter(getActivity(), NavigationDrawerItem.getData());
        rv.setAdapter(adapter);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
    NavigationDrawerAdapter adapter;


    public void setUpDrawerForMainView(RecyclerView rcvm, Context context){
        recyclerViewMain = rcvm;

        mainContext = context;

        if(recyclerViewMain==null){
            Log.d("YY","null");
        }else{
            Log.d("YY","no null");
        }

        adapter.setRecyclerViewMain(recyclerViewMain, mainContext);
    }

    public void setUpDrawer(int fragmentIt, DrawerLayout dl, Toolbar toolbar){

        mDrwLayout = dl;

        mDrwToggle = new ActionBarDrawerToggle(getActivity(), dl, toolbar, R.string.open, R.string.close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };

        mDrwLayout.setDrawerListener(mDrwToggle);

        mDrwLayout.post(new Runnable() {
            @Override
            public void run() {
                 mDrwToggle.syncState();

            }
        });



    }

}
