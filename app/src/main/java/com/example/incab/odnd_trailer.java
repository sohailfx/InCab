package com.example.incab;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class odnd_trailer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odnd_trailer_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        ImageView toolbarStatusImage = findViewById(R.id.toolbarStatusIconId);
        toolBarLayout.setTitle(getTitle());

        // ******** code for back button begins *********//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // ******** code for back button ends *********//
        Intent intent = getIntent();
//        final String otherDuty = intent.getStringExtra(duty.DUTY_EXTRA_TEXT);

        Bundle extras = intent.getExtras();
        String selectedDuty = extras.getString("DUTY");
        String drivingMode = extras.getString("MODE");
//        toolBarLayout.setTitle(selectedDuty);

        if (selectedDuty.equals("odnd")) {
            if (drivingMode.equals("Trailer")) {
                toolBarLayout.setTitle("ODND - Trailer");
                toolbarStatusImage.setImageResource(R.drawable.ic_trailer);
                toolBarLayout.setCollapsedTitleTextAppearance(R.style.odndExpandedToolBarTitleTheme);
                toolbarStatusImage.setColorFilter(getResources().getColor(R.color.odnd_color));
            }
            if (drivingMode.equals("HZMT")) {
                toolBarLayout.setTitle("ODND - HZMT");
                toolbarStatusImage.setImageResource(R.drawable.ic_hzmt);
                toolBarLayout.setCollapsedTitleTextAppearance(R.style.odndExpandedToolBarTitleTheme);
                toolbarStatusImage.setColorFilter(getResources().getColor(R.color.odnd_color));
            }
        }
        else if (selectedDuty.equals("yard"))
        {
            toolBarLayout.setTitle("Yard Move");
            toolbarStatusImage.setImageResource(R.drawable.ic_yard);
            toolBarLayout.setCollapsedTitleTextAppearance(R.style.odndExpandedToolBarTitleTheme);
            toolbarStatusImage.setColorFilter(getResources().getColor(R.color.odnd_color));
        }
        else if (selectedDuty.equals("offduty"))
        {
            toolBarLayout.setTitle("Off Duty");
            toolbarStatusImage.setImageResource(R.drawable.ic_offduty);
            toolBarLayout.setExpandedTitleTextAppearance(R.style.HomeExpandedToolBarTitleTheme);
            toolBarLayout.setCollapsedTitleTextAppearance(R.style.HomeCollapsedToolBarTitleTheme);
            toolbarStatusImage.setColorFilter(getResources().getColor(R.color.whiteColor));
        }
        else if (selectedDuty.equals("sleeperberth"))
        {
            toolBarLayout.setTitle("Sleeper Berth");
            toolbarStatusImage.setImageResource(R.drawable.ic_sleeperberth);
            toolBarLayout.setExpandedTitleTextAppearance(R.style.HomeExpandedToolBarTitleTheme);
            toolBarLayout.setCollapsedTitleTextAppearance(R.style.HomeCollapsedToolBarTitleTheme);
            toolbarStatusImage.setColorFilter(getResources().getColor(R.color.whiteColor));
        }
        else if (selectedDuty.equals("driving"))
        {
            toolBarLayout.setTitle("Driving");
            toolbarStatusImage.setImageResource(R.drawable.ic_driving);
            toolBarLayout.setExpandedTitleTextAppearance(R.style.DrivingExpandedToolBarTitleTheme);
            toolBarLayout.setCollapsedTitleTextAppearance(R.style.DrivingCollapsedToolBarTitleTheme);
            toolbarStatusImage.setColorFilter(getResources().getColor(R.color.greenColor));
        }

        CardView hosCard = findViewById(R.id.hosCardId);
        hosCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(odnd_trailer.this, hos.class);
                startActivity(intent);
            }
        });

        CardView eldCard = findViewById(R.id.eldCardId);
        eldCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(odnd_trailer.this, eld.class);
                startActivity(intent);
            }
        });

        CardView inspectCard = findViewById(R.id.inspectCardId);
        inspectCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(odnd_trailer.this, inspect.class);
                startActivity(intent);
            }
        });

        ImageButton mImageButton = findViewById(R.id.connectButtonId);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(odnd_trailer.this, connect.class);
                startActivity(intent);
            }
        });
        ImageButton backButton = findViewById(R.id.backButtonId);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(odnd_trailer.this, duty.class);
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
//    public void onBackPressed()
//    {
//        Intent intent = new Intent(this,duty.class);
//        startActivity(intent);
//    }
    // ******** code for back button ends *********//
}