package com.zerofill.applytheme;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kronosboy on 14/02/16.
 */
public class MyCard {


    private String title;
    private String desc;
    private int imageId;
    private boolean isDescExpanded;
    private boolean isImgExpanded;
    private int quantity;


    public static ArrayList<MyCard> getData(String title) {
        ArrayList<MyCard> dataList = new ArrayList<MyCard>();

        /*
        int[] imgs = getImages();

        for(int i=0; i< imgs.length; i++){
            MyCard myCard = new MyCard();

            myCard.setImageId(imgs[i]);
            if("Appetizers".equals(title))
                myCard.setTitle("Appetizers #"+i);
            if("Main course".equals(title))
                myCard.setTitle("Main #"+i);
            if("Steaks".equals(title))
                myCard.setTitle("Steaks #"+i);

            myCard.setDesc("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod...");
            dataList.add(myCard);
        }*/


        HashMap<String, Integer> map = getImagesMap(title);
        for(String key : map.keySet()){
            MyCard myCard = new MyCard();

            myCard.setImageId(map.get(key));
            myCard.setTitle(key);

            myCard.setDesc("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod...");
            dataList.add(myCard);
        }



        return dataList;
    }

    private static int[] getImages() {
        int[] imgs = {

                R.drawable.appetizers,
                R.drawable.beverages,
                R.drawable.pizza,
                R.drawable.desserts,
                R.drawable.fishes,
                R.drawable.steaks,
                R.drawable.appetizers,
                R.drawable.maincourse

        };

        return imgs;
    }

    private static HashMap<String, Integer> getImagesMap(String title){
        HashMap<String, Integer> res = new HashMap<String, Integer>();

        if("Appetizers".equals(title)){
            res.put("Fried mix",R.drawable.ap_fri);
            res.put("Italian fantasy",R.drawable.ap_mix);
            res.put("Vegan",R.drawable.ap_veg);
        }

        if("Main course".equals(title)){
            res.put("Carbonara",R.drawable.pa_car);
            res.put("Cold pasta",R.drawable.pa_fre);
            res.put("Mushrooms & Sausages",R.drawable.pa_fun);
            res.put("Lasagna",R.drawable.pa_las);
            res.put("Pasta with tomato sauce",R.drawable.pa_pom);

            res.put("Carbonara 2",R.drawable.pa_car);
            res.put("Cold pasta 2",R.drawable.pa_fre);
            res.put("Mushrooms & Sausages 2",R.drawable.pa_fun);
            res.put("Lasagna 2",R.drawable.pa_las);
            res.put("Pasta with tomato sauce 2",R.drawable.pa_pom);
        }

        if("Steaks".equals(title)){
            res.put("Angus",R.drawable.st_ang);
            res.put("Fiorentina",R.drawable.st_fio);
            res.put("Cotoletta alla milanese",R.drawable.st_mil);

        }

        if("Fishes".equals(title)){
            res.put("Fried mix",R.drawable.fi_fri);
            res.put("Cod fish with tomatoes",R.drawable.fi_mer);
            res.put("Grilled salmon",R.drawable.fi_sal);
            res.put("Grilled swordfish",R.drawable.fi_spa);

            res.put("Fried mix 2",R.drawable.fi_fri);
            res.put("Cod fish with tomatoes 2",R.drawable.fi_mer);
            res.put("Grilled salmon 2",R.drawable.fi_sal);
            res.put("Grilled swordfish 2",R.drawable.fi_spa);

            res.put("Fried mix 3",R.drawable.fi_fri);
            res.put("Cod fish with tomatoes 3",R.drawable.fi_mer);
            res.put("Grilled salmon 3",R.drawable.fi_sal);
            res.put("Grilled swordfish 3",R.drawable.fi_spa);
        }

        if("Pizza".equals(title)){
            res.put("Diavola",R.drawable.p_dia);
            res.put("Mushroom",R.drawable.p_fun);
            res.put("Potatoes",R.drawable.p_pat);
            res.put("Vegetables",R.drawable.p_veg);
            res.put("Diavola 2",R.drawable.p_dia);
            res.put("Mushroom 2",R.drawable.p_fun);
            res.put("Potatoes 2",R.drawable.p_pat);
            res.put("Vegetables 2",R.drawable.p_veg);
            res.put("Diavola 3",R.drawable.p_dia);
            res.put("Mushroom 3",R.drawable.p_fun);
            res.put("Potatoes 3",R.drawable.p_pat);
            res.put("Vegetables 3",R.drawable.p_veg);

        }


        return res;
    }

    public MyCard() {
    }

    public MyCard(int imageId, String title) {
        this.imageId = imageId;
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean isDescExpanded() {
        return isDescExpanded;
    }

    public void setDescExpanded(boolean descExpanded) {
        isDescExpanded = descExpanded;
    }
    public boolean isImgExpanded() {
        return isImgExpanded;
    }

    public void setImgExpanded(boolean imgExpanded) {
        isImgExpanded = imgExpanded;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
