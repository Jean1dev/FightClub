package com.voador.guardeiro.flightclub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.voador.guardeiro.flightclub.R;

public class SplashArtActivity extends BaseActivity {

    private ImageView splash;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_art);

        splash = findViewById(R.id.splash);
        animation = AnimationUtils.loadAnimation(this, R.anim.anim_splash);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashArtActivity.this, LoginActivity.class));
                if (!primeiraVezQueUsaOapp()) {
                    goTo(LoginActivity.class);
                    finish();
                } else {
                    goTo(MainActivity.class);
                    finish();
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        splash.startAnimation(animation);

    }

    protected boolean primeiraVezQueUsaOapp() {
        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean("login", false);
    }
}
