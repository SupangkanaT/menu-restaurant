package com.zerofill.applytheme;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kronosboy on 15/02/16.
 */
public class NavigationDrawerItem {

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int imageId;
    private String title;



    public static List<NavigationDrawerItem> getData() {
        List<NavigationDrawerItem> l = new ArrayList<NavigationDrawerItem>();

 //       int[] imageIds = getImages();
        String[] titles = getTitles();
/*
        for (int i=0; i<titles.length; i++){
            NavigationDrawerItem e = new NavigationDrawerItem();
            e.setTitle(titles[i]);
            e.setImageId(imageIds[i]);
            Log.d("MY", "titles[i]: "+titles[i]+",  imageIds[i]: "+imageIds[i]);
            l.add(e);
        }*/


        HashMap<String,Integer> imgMap = new HashMap<String,Integer>();
        imgMap.put("Appetizers", R.drawable.appetizers);
        imgMap.put("Main course", R.drawable.maincourse);
        imgMap.put("Steaks", R.drawable.steaks);
        imgMap.put("Fishes", R.drawable.fishes);
        imgMap.put("Pizza", R.drawable.pizza);
        imgMap.put("Desserts", R.drawable.desserts);
        imgMap.put("Beverages", R.drawable.beverages);
        imgMap.put("Other", R.drawable.other);

        for (int i=0; i<titles.length; i++){
            NavigationDrawerItem e = new NavigationDrawerItem();
            e.setTitle(titles[i]);

            if(imgMap.containsKey(titles[i])){
                e.setImageId(imgMap.get(titles[i]));
            }else{
                e.setImageId(imgMap.get("Other"));
            }

            l.add(e);
        }




        return l;
    }

    private static String[] getTitles() {

       // return new String[]{"Anto", "Jib", "Rob", "Matisse"};
        return new String[]{"Appetizers", "Main course", "Steaks", "Fishes", "Pizza", "Desserts","Beverages", "Other 1", "Other 2", "Other 3", "Other 4",};
      //  return new String[]{"Anto", "Jib", "Rob", "Beverages"};
    }

    private static int[] getImages() {

        return new int[]{
                R.drawable.j01,
                R.drawable.j02,
                R.drawable.j03,
                R.drawable.j04,
                R.drawable.j04,
                R.drawable.j04,
                R.drawable.j04,
                R.drawable.j04,
                R.drawable.j04,
                R.drawable.j04,
                R.drawable.j04,
                R.drawable.j04,
                R.drawable.j04,
                R.drawable.j04,
                R.drawable.j04,
                R.drawable.j04
        };
    }
}
