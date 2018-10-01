package com.example.naiapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            //Display the about page when about is clicked
            RelativeLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.about_page, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
            setTitle("About");

        } else if (id == R.id.top_experiences) {
            //Display the top expreiences page
            RelativeLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.top_experiences, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
            setTitle("Top Experiences");

            //Initialize the imagiViews for the page
            ImageView nationpark = findViewById(R.id.national_park);
            ImageView davidShe = findViewById(R.id.david_sher);
            ImageView karenBlixen = findViewById(R.id.karen_blixen);
            ImageView nationalMuseum = findViewById(R.id.national_museum);
            ImageView girrafeCentre = findViewById(R.id.girrafe_centre);
            ImageView kazuri = findViewById(R.id.kazuri);
            ImageView goDown = findViewById(R.id.go_dowm);
            ImageView bomas = findViewById(R.id.Bomas);


            //Resize the HD images and set images for the page
            nationpark.setImageDrawable(resizeImage(R.drawable.national_museum));
            davidShe.setImageDrawable(resizeImage(R.drawable.david_sheldrick));
            karenBlixen.setImageDrawable(resizeImage(R.drawable.karen_blixen));
            nationalMuseum.setImageDrawable(resizeImage(R.drawable.national_museum));
            girrafeCentre.setImageDrawable(resizeImage(R.drawable.giraffe_centre));
            kazuri.setImageDrawable(resizeImage(R.drawable.kazuri));
            goDown.setImageDrawable(resizeImage(R.drawable.go_down));
            bomas.setImageDrawable(resizeImage(R.drawable.bomas_of_kenya));

        } else if (id == R.id.nav_home) {
            //Display the about page when Home is clicked
            RelativeLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.content_main, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
        } else if (id == R.id.nav_restaurants) {
            //Display the about page when Restaurants is clicked
            RelativeLayout mainLayout = findViewById(R.id.main_container);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.restaurants, null);
            mainLayout.removeAllViews();
            mainLayout.addView(layout);
            setTitle("Restaurants");

            ImageView tinroof = findViewById(R.id.tinRoof);
            ImageView carnivore = findViewById(R.id.carnivore);
            ImageView roadHouse = findViewById(R.id.roadHouseGrill);
            ImageView karenBlixen = findViewById(R.id.karenBlixen);
            ImageView mamaOliech = findViewById(R.id.mamaOliech);
            ImageView talisMan = findViewById(R.id.talisman);
            ImageView alYusra = findViewById(R.id.alYusra);
            ImageView bomas = findViewById(R.id.bomas);



            tinroof.setImageDrawable(resizeImage(R.drawable.tin_roof));
            carnivore.setImageDrawable(resizeImage(R.drawable.carnivore));
            roadHouse.setImageDrawable(resizeImage(R.drawable.roadhouse_grill));
            karenBlixen.setImageDrawable(resizeImage(R.drawable.karen_blixen_coffee));
            mamaOliech.setImageDrawable(resizeImage(R.drawable.mama_oliech));
            talisMan.setImageDrawable(resizeImage(R.drawable.talisman));
            alYusra.setImageDrawable(resizeImage(R.drawable.al_yusra));
            bomas.setImageDrawable(resizeImage(R.drawable.bomas_of_kenya));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Resize HD images

    public Drawable resizeImage(int imageResource) {// R.drawable.large_image
        // Get device dimensions
        Display display = getWindowManager().getDefaultDisplay();
        double deviceWidth = display.getWidth();

        BitmapDrawable bd = (BitmapDrawable) this.getResources().getDrawable(
                imageResource);
        double imageHeight = bd.getBitmap().getHeight();
        double imageWidth = bd.getBitmap().getWidth();

        double ratio = deviceWidth / imageWidth;
        int newImageHeight = (int) (imageHeight * ratio);

        Bitmap bMap = BitmapFactory.decodeResource(getResources(), imageResource);
        Drawable drawable = new BitmapDrawable(this.getResources(),
                getResizedBitmap(bMap, newImageHeight, (int) deviceWidth));

        return drawable;
    }

    /************************ Resize Bitmap *********************************/
    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {

        int width = bm.getWidth();
        int height = bm.getHeight();

        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        // create a matrix for the manipulation
        Matrix matrix = new Matrix();

        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);

        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
                matrix, false);

        return resizedBitmap;
    }
}
