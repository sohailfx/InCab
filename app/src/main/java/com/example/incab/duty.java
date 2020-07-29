package com.example.incab;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class duty extends AppCompatActivity {
    public static final String DUTY_EXTRA_TEXT = "Default Value";
    public static Bundle extras = new Bundle();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duty_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

//        Typeface typeface = Typeface.createFromAsset(getAssets(),'fonts/Roboto-Bold.ttf');
//        textView.setTypeface(typeface);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        final LinearLayout linearLayout1 = findViewById(R.id.linearLayout1);
        final LinearLayout linearLayout4 = findViewById(R.id.linearLayout4);
        final ConstraintLayout yardWrap = findViewById(R.id.yardWrapID);

        // ******** code for back button begins *********//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//            getSupportActionBar().setDisplayShowHomeEnabled(false);
//        }
        // ******** code for back button ends *********//

        AppBarLayout appBarLayout = findViewById(R.id.app_bar);;
        appBarLayout.setExpanded(false);

//        ImageButton vehicleOnMap = findViewById(R.id.vehicleCardId);
//        vehicleOnMap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(duty.this, Maps.class);
//                startActivity(intent);
//            }
//        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        CardView onndCard = (CardView) findViewById(R.id.onndCardId);
        onndCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(duty.this, odnd.class);
                String selectedDuty ="odnd";
                intent.putExtra(DUTY_EXTRA_TEXT, selectedDuty);
                startActivity(intent);
            }
        });

        CardView vehicleCardId = (CardView) findViewById(R.id.vehicleCardId);
        vehicleCardId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(duty.this, Maps.class);
                startActivity(intent);
            }
        });

//

        CardView yardCard = (CardView) findViewById(R.id.yardCardId);
        yardCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(duty.this, odnd.class);
                String selectedDuty ="yard";
                intent.putExtra(DUTY_EXTRA_TEXT, selectedDuty);
                startActivity(intent);
            }
        });

        CardView offdutyCard = (CardView) findViewById(R.id.offdutyCardId);
        offdutyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(duty.this, odnd.class);
                String selectedDuty ="offduty";
                intent.putExtra(DUTY_EXTRA_TEXT, selectedDuty);
                startActivity(intent);
            }
        });

        CardView sleeperberthCard = (CardView) findViewById(R.id.sleeperberthCardId);
        sleeperberthCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(duty.this, odnd.class);
                String selectedDuty ="sleeperberth";
                intent.putExtra(DUTY_EXTRA_TEXT, selectedDuty);
                startActivity(intent);
            }
        });

        CardView drivingCard = (CardView) findViewById(R.id.drivingCardId);
        drivingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(duty.this, odnd_trailer.class);
                String selectedDuty = "driving";
                String selectedMode = "driving";
                extras.putString("DUTY",selectedDuty);
                extras.putString("MODE",selectedMode);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
        CardView inspectCard = (CardView) findViewById(R.id.inspectCardId);
        inspectCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(duty.this, inspect.class);
                startActivity(intent);
            }
        });
    }
    // ******** code for back button begins *********//
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    // ******** code for back button ends *********//
}