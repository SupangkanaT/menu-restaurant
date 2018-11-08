package com.zerofill.applytheme;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kronosboy on 14/02/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    private static final String TAG = RecyclerAdapter.class.getSimpleName();
    private Context context;


    public RecyclerAdapter(Context context, List<MyCard> mData) {
        this.context = context;
        this.mData = mData;
        this.mInfalter = LayoutInflater.from(context);
    }

    private List<MyCard> mData;
    private LayoutInflater mInfalter;


    public void removeItem(int position){

        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mData.size());

    }

    public void addItem(int position, MyCard card){
        mData.add(position ,card);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, mData.size());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = mInfalter.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder, position:"+position);

        MyCard currentMyData = mData.get(position);
        holder.setData(currentMyData,position);
        holder.setListeners();

    }

    class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{


        TextView title, desc, quantity;
        ImageView thumb, addBtn, delBtn;
        int position;
        MyCard current;
        boolean isDescExpanded;



        public MyViewHolder(View v) {
            super(v);

            title = (TextView) v.findViewById(R.id.myTitle);
            quantity = (TextView) v.findViewById(R.id.quantity);
            desc = (TextView) v.findViewById(R.id.myShortDesc);
            addBtn = (ImageView) v.findViewById(R.id.add_btn);
            delBtn = (ImageView) v.findViewById(R.id.del_btn);
            thumb = (ImageView) v.findViewById(R.id.img);


        }

        public void setData(MyCard currentMyData, int position) {
            this.title.setText(currentMyData.getTitle());
            this.desc.setText(currentMyData.getDesc());
            this.quantity.setText(currentMyData.getQuantity()+"");
            this.thumb.setImageResource(currentMyData.getImageId());
            this.position = position;
            this.current = currentMyData;
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.add_btn:
                  //  addItem(this.position, new MyCard());
                    setNewQuantity(1);
                    break;

                case R.id.del_btn:
                  //  removeItem(this.position);
                    setNewQuantity(-1);
                    break;

                case R.id.myShortDesc:
                case R.id.img: // expand or reduce text
                    final float scale = context.getResources().getDisplayMetrics().density;
                    int pixels = (int) (150 * scale + 0.5f);
                    if(!current.isDescExpanded()){
                        desc.setText(desc.getText().toString().substring(0, desc.getText().toString().length()-3) + " tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
                        current.setDescExpanded(true);
                    }else{
                        pixels = (int) (80 * scale + 0.5f);
                        desc.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod...");
                        current.setDescExpanded(false);
                    }
                    thumb.getLayoutParams().height = pixels;
                    thumb.getLayoutParams().width = pixels;
                    thumb.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;

               /*
                case R.id.myShortDesc: // expand or reduce text
                    if(!current.isDescExpanded()){
                        desc.setText(desc.getText().toString().substring(0, desc.getText().toString().length()-3) + " tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
                        current.setDescExpanded(true);
                    }else{
                        desc.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod...");
                        current.setDescExpanded(false);
                    }
                    break;

                case R.id.img: // zoom image
                    final float scale = context.getResources().getDisplayMetrics().density;
                    int pixels = (int) (150 * scale + 0.5f);
                    if(!current.isImgExpanded()){
                        current.setImgExpanded(true);
                    }else{
                        pixels = (int) (80 * scale + 0.5f);
                        current.setImgExpanded(false);
                    }
                    Log.d(TAG, "setting pixels: "+pixels);
                    thumb.getLayoutParams().height = pixels;
                    thumb.getLayoutParams().width = pixels;
                    thumb.setScaleType(ImageView.ScaleType.FIT_XY);

                    if(!current.isDescExpanded()){
                        desc.setText(desc.getText().toString().substring(0, desc.getText().toString().length()-3) + " tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
                        desc.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod...");
                    }else{
                        desc.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod...");
                        desc.setText(desc.getText().toString().substring(0, desc.getText().toString().length()-3) + " tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
                    }


                    break;
                    */
            }


        }

        private void setNewQuantity(int newQuantity){
            String q = quantity.getText().toString();
            try{
                int current = Integer.parseInt(q);
                if(current+newQuantity>-1 && current+newQuantity<51)
                    quantity.setText(current+newQuantity+"");
            }catch (Exception e){
                quantity.setText(0+newQuantity+"");
            }
        }

        public void setListeners() {
            addBtn.setOnClickListener(MyViewHolder.this);
            delBtn.setOnClickListener(MyViewHolder.this);
            desc.setOnClickListener(MyViewHolder.this);
            thumb.setOnClickListener(MyViewHolder.this);
        }
    }
}
