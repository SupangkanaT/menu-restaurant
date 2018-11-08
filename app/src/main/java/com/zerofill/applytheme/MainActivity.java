 package com.zerofill.applytheme;

import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Da Tony Restaurant & Pizza");
        getSupportActionBar().setSubtitle("Antonio");

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            toolbar.setElevation(10f);

        }else {

        }

        setUpDrawer();

        setUpRecyclerView();


    }

     private void setUpDrawer() {

        fr = (NavDrwFragment)getSupportFragmentManager().findFragmentById(R.id.nav_drw_fragm);
        //fr = (NavDrwFragment)getSupportFragmentManager().findFragmentById(R.id.nav_drw_fragm);
         DrawerLayout dl = (DrawerLayout)findViewById(R.id.drwLayout);
         fr.setUpDrawer(R.id.nav_drw_fragm, dl, toolbar);

     }
     NavDrwFragment fr;

     private RecyclerView recyclerView;
     private void setUpRecyclerView() {

         recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
         RecyclerAdapter adapter = new RecyclerAdapter(this, MyCard.getData("Appetizers"));
         recyclerView.setAdapter(adapter);

         LinearLayoutManager llManager = new LinearLayoutManager(this);
         llManager.setOrientation(LinearLayoutManager.VERTICAL);
         recyclerView.setLayoutManager(llManager);

         recyclerView.setItemAnimator(new DefaultItemAnimator());

         fr.setUpDrawerForMainView(recyclerView, this);
     }


     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu,menu);
         return true;
     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
         String msg = "";


         switch (item.getItemId()){

             case R.id.place_order:
                 /*
                 RecyclerAdapter adapter = new RecyclerAdapter(this, MyCard.getData(""));
                 recyclerView.setAdapter(adapter);
                 */
                 break;
/*
             case R.id.add:
                 msg = "Click add";
                 break;

             case R.id.remove:
                 msg = "Click remove";
                 break;

             case R.id.bye:
                 msg = "Click bye";
                 break;
*/


/*
             case R.id.m_linearViewVertical:
                 LinearLayoutManager lv = new LinearLayoutManager(this);
                 lv.setOrientation(LinearLayoutManager.VERTICAL);
                 recyclerView.setLayoutManager(lv);
                 break;

             case R.id.m_linearViewHorizontal:
                 LinearLayoutManager lh = new LinearLayoutManager(this);
                 lh.setOrientation(LinearLayoutManager.HORIZONTAL);
                 recyclerView.setLayoutManager(lh);
                 break;

             case R.id.m_gridView:
                 GridLayoutManager g = new GridLayoutManager(this, 2);
                 recyclerView.setLayoutManager(g);
                 break;

             case R.id.m_staggeredVertical:
                 StaggeredGridLayoutManager sv = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                 recyclerView.setLayoutManager(sv);
                 break;

             case R.id.m_StaggeredViewHorizontal:
                 StaggeredGridLayoutManager sh = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
                 recyclerView.setLayoutManager(sh);
                 break;
*/

         }

         Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();

         return super.onOptionsItemSelected(item);
     }
 }
