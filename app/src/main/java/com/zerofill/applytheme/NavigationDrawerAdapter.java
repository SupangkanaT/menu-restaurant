package com.zerofill.applytheme;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by kronosboy on 15/02/16.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {

    private static final String TAG = NavigationDrawerAdapter.class.getSimpleName();

    private List<NavigationDrawerItem> mDataList = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context, mainContext;
    private RecyclerView recyclerViewMain;

    public void setRecyclerViewMain(RecyclerView rcvm, Context context){
        recyclerViewMain = rcvm;
        mainContext = context;
    }

    public NavigationDrawerAdapter(Context context, List<NavigationDrawerItem> l){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.mDataList = l;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.nav_drw_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        NavigationDrawerItem current = mDataList.get(position);

        Log.d("MY", "position "+position+", current.getImageId()"+current.getImageId()+", current.getTitle()"+current.getTitle());

       holder.imgIcon.setImageResource(current.getImageId());
        holder.title.setText(current.getTitle());
        holder.setData(current);
        holder.setListeners();



    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{


        ImageView imgIcon;
        TextView title;
        NavigationDrawerItem current;

        public MyViewHolder(View itemView) {

            super(itemView);

            imgIcon = (ImageView) itemView.findViewById(R.id.imgDrwIco);
            title = (TextView) itemView.findViewById(R.id.drwItemTitle);

        }

        public void setData(NavigationDrawerItem data){
            current = data;
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.imgDrwIco:
                case R.id.drwItemTitle:
                    Log.d(TAG,"current title: "+current.getTitle());

                    RecyclerAdapter adapter = new RecyclerAdapter(mainContext, MyCard.getData(current.getTitle()));
                    recyclerViewMain.setAdapter(adapter);

                    break;
            }
        }


        public void setListeners() {
            imgIcon.setOnClickListener(MyViewHolder.this);
            title.setOnClickListener(MyViewHolder.this);
        }
    }

}
