package com.richardduahboakye.shopit;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Objects;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class SplashActivity extends AppCompatActivity {


    TextView AppName, PoweredBy;

private static int SPLASH_TIME = 4000;
    // animations
    Animation topAnim, slideFromRightAnim,slideUpAnim;

    ConstraintLayout splashConstraintLayout;



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Typographica-Blp5.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()))
                .build());


        // setting fullscreen to hide status bar in activity
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);


        // lock screen orientation to portrait ...works when placed after setContentView
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);



        splashConstraintLayout = findViewById(R.id.splashConstraintLayout);


        AppName = (TextView) findViewById(R.id.app_name);
        PoweredBy = (TextView) findViewById(R.id.powered_by);




        //init animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        slideFromRightAnim = AnimationUtils.loadAnimation(this, R.anim.slide_from_right_animation);
        slideUpAnim = AnimationUtils.loadAnimation(this, R.anim.slide_up_anim);



        //set animations to views
        AppName.setAnimation(topAnim);

        PoweredBy.setAnimation(slideUpAnim);

        //delay of activity before launching next activity
        new  Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME);



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
