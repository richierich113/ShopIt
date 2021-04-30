package com.richardduahboakye.shopit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class ItemDetailsActivity extends AppCompatActivity {

    ImageView Iimg;
    TextView Iname, Irating, Iprice, Istock;

    TextView nIcategory, nIdescription, nIrating, nIprice, nIstock;

    TextView  titleIrating, titleIprice, titleIstock,titleIcategory,titleIdescription;

    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        //Collapsing bar items
        Iimg = findViewById(R.id.itemImg1);
        /*Irating = findViewById(R.id.rating1);
        Iprice = findViewById(R.id.price1);
        Istock = findViewById(R.id.stock1);
        Iname = findViewById(R.id.name1);*/

        // bottom items
        nIrating = findViewById(R.id.rating2);
        nIprice = findViewById(R.id.price2);
        nIstock = findViewById(R.id.stock2);

        nIcategory = findViewById(R.id.category);
        nIdescription = findViewById(R.id.description);

        // bottom items titles
        titleIrating = findViewById(R.id.rating_title);
        titleIprice = findViewById(R.id.price_title);
        titleIstock = findViewById(R.id.stock_title);
        titleIcategory = findViewById(R.id.category_title);
        titleIdescription = findViewById(R.id.description_title);

        appBarLayout = findViewById(R.id.appBarLayout);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolBar);
        toolbar = findViewById(R.id.toolbar);


        String Iimg1 = getIntent().getStringExtra("img");
        String Irating1 = getIntent().getStringExtra("rating");
        String Iprice1 = getIntent().getStringExtra("price");
        String Istock1 = getIntent().getStringExtra("stock");
        String Icategory1 = getIntent().getStringExtra("category");
        String Iname1 = getIntent().getStringExtra("name");
        String Idescription1 = getIntent().getStringExtra("description");


        collapsingToolbarLayout.setTitle(Iname1);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);


//set values for collapsing items
       /* Irating.setText(Irating1);
        Iprice.setText(Iprice1);
        Istock.setText(Istock1);
        nIcategory.setText(Icategory1);
        Iname.setText(Iname1);
        nIdescription.setText(Idescription1);*/

        Glide.with(this).load(Iimg1).into(Iimg);


//set values for bottom items
        nIrating.setText(Irating1);
        nIprice.setText(Iprice1);
        nIstock.setText(Istock1);
        nIcategory.setText(Icategory1);
        // nIname.setText(Iname1);
        nIdescription.setText(Idescription1);

    }
}