package com.richardduahboakye.shopit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.snackbar.Snackbar;
import com.richardduahboakye.shopit.Retrofit.APIClient;
import com.richardduahboakye.shopit.adapter.RecyclerAdapter;
import com.richardduahboakye.shopit.model.ItemModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    TextView appName;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    LinearLayoutManager layoutManager;
    public static List<ItemModel> list;

    ShimmerFrameLayout shimmerFrameLayout;

    private static int RETRY_CALL_LOADING = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //finding and setting toolbar as ActionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = findViewById(R.id.list_recyclerview);

        //finding shimmerFrameLayout view
        shimmerFrameLayout = findViewById(R.id.shimmer_view_container);
        shimmerFrameLayout.setVisibility(View.VISIBLE);

        //start shimmer animation
        shimmerFrameLayout.startShimmer();






        list = new ArrayList<>();

        //making server call
       makeServerCall();
    }

    Snackbar snackbar1;
    private void makeServerCall() {
        Call<List<ItemModel>> listCall = APIClient.apIinterface().getList();

        listCall.enqueue(new Callback<List<ItemModel>>() {
            @Override
            public void onResponse(@NotNull Call<List<ItemModel>> call, Response<List<ItemModel>> response) {
                if (response.isSuccessful()) {

                    list = response.body();
                    recyclerAdapter = new RecyclerAdapter(MainActivity.this, response.body());
                    layoutManager = new LinearLayoutManager(MainActivity.this);
                    layoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerView.setLayoutManager(layoutManager);

                    recyclerView.setAdapter(recyclerAdapter);



                    if (snackbar != null) {
                        isConnected = true;
                        snackbar.dismiss();
                        int DelayTime = 1000;
                        snackbar1 = Snackbar.make(recyclerView, "Back online", Snackbar.LENGTH_INDEFINITE).setDuration(DelayTime);
                        //snackbar.setText(R.string.back_online);
                        snackbar1.setActionTextColor(getResources().getColor(R.color.white));
                        snackbar1.setBackgroundTint(getResources().getColor(R.color.green));
                        snackbar1.show();

                    }

                    //manage shimmer and recyclerview on response success
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);

                } else {
                    Toast.makeText(MainActivity.this, "web server error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<ItemModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();

                if (snackbar != null) {
                    snackbar.isShown();
                }

                showNoconnectionSnack();

               //retrying server calling at time intervals when there is no connection
                //on connection gain, server can be connected
                new Handler().postDelayed(() -> makeServerCall(), RETRY_CALL_LOADING);




            }
        });

    }
    Snackbar snackbar;
    boolean isConnected = false;
    private void showNoconnectionSnack() {
        isConnected = false;
        //int DelayTime = 10000;
         snackbar = Snackbar.make(recyclerView, "No connection", Snackbar.LENGTH_INDEFINITE);


        snackbar.setActionTextColor(getResources().getColor(R.color.white));
        snackbar.setBackgroundTint(getResources().getColor(R.color.black));
        snackbar.show();
        snackbar.isShown();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Categories) {
            Toast.makeText(MainActivity.this, "You clicked Categories", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.Settings) {
            Toast.makeText(MainActivity.this, "You clicked Settings", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.Search) {
            Toast.makeText(MainActivity.this, "You clicked Search", Toast.LENGTH_SHORT).show();

        }

        if (id == R.id.HotDeals) {

            Toast.makeText(MainActivity.this, "You clicked Hot Deals", Toast.LENGTH_SHORT).show();
        }


        return true;
    }


}