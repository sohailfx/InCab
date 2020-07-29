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
import android.widget.LinearLayout;

public class odnd extends AppCompatActivity {
    //    final CardView trailerCard = (CardView) findViewById(R.id.trailerCardId);
//    final CardView hzmtCardId = (CardView) findViewById(R.id.hzmtCardId);
//    final CardView dvirCardId = (CardView) findViewById(R.id.dvirCardId);
    public static Bundle extras = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odnd_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());
        // ******** code for back button begins *********//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        // ******** code for back button ends *********//
        ImageButton mImageButton = findViewById(R.id.connectButtonId);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(odnd.this, connect.class);
                startActivity(intent);
            }
        });
        FloatingActionButton odndSubmit = findViewById(R.id.odndSubmitId);
        final CardView trailerCardId = findViewById(R.id.trailerCardId);
        final CardView hzmtCardId = findViewById(R.id.hzmtCardId);
        final CardView dvirCardId = findViewById(R.id.dvirCardId);
        final FloatingActionButton odndSubmitId = findViewById(R.id.odndSubmitId);
        final LinearLayout odndSubSetLayout = findViewById(R.id.odndSubSetLayout);
        ImageView toolbarStatusImage = findViewById(R.id.toolbarStatusIconId);

        Intent intent = getIntent();
        final String selectedDuty = intent.getStringExtra(duty.DUTY_EXTRA_TEXT);
        extras.putString("DUTY",selectedDuty);

        if (selectedDuty.equals("odnd"))
        {
            toolBarLayout.setTitle("On Duty Not Driving");
            toolbarStatusImage.setImageResource(R.drawable.ic_odnd);
            toolbarStatusImage.setColorFilter(getResources().getColor(R.color.odnd_color));
            toolBarLayout.setExpandedTitleTextAppearance(R.style.odndExpandedToolBarTitleTheme);
            odndSubSetLayout.setVisibility(View.VISIBLE);
            odndSubmit.setVisibility(View.INVISIBLE);
        }
        else if (selectedDuty.equals("yard"))
        {
            odndSubSetLayout.setVisibility(View.GONE);
            odndSubmit.setVisibility(View.VISIBLE);
            toolbarStatusImage.setImageResource(R.drawable.ic_yard);
            toolbarStatusImage.setColorFilter(getResources().getColor(R.color.odnd_color));
            toolBarLayout.setExpandedTitleTextAppearance(R.style.odndExpandedToolBarTitleTheme);
            toolBarLayout.setTitle("Yard Move");
        }
        else if (selectedDuty.equals("offduty"))
        {
            odndSubSetLayout.setVisibility(View.GONE);
            odndSubmit.setVisibility(View.VISIBLE);
            toolbarStatusImage.setImageResource(R.drawable.ic_offduty);
            toolBarLayout.setTitle("Off Duty");
            toolBarLayout.setExpandedTitleTextAppearance(R.style.HomeExpandedToolBarTitleTheme);
            toolBarLayout.setCollapsedTitleTextAppearance(R.style.HomeCollapsedToolBarTitleTheme);
            toolbarStatusImage.setColorFilter(getResources().getColor(R.color.whiteColor));
        }
        else if (selectedDuty.equals("sleeperberth"))
        {
            odndSubSetLayout.setVisibility(View.GONE);
            odndSubmit.setVisibility(View.VISIBLE);
            toolbarStatusImage.setImageResource(R.drawable.ic_sleeperberth);
            toolBarLayout.setTitle("Sleeper Berth");
            toolBarLayout.setExpandedTitleTextAppearance(R.style.HomeExpandedToolBarTitleTheme);
            toolBarLayout.setCollapsedTitleTextAppearance(R.style.HomeCollapsedToolBarTitleTheme);
            toolbarStatusImage.setColorFilter(getResources().getColor(R.color.whiteColor));
        }

        trailerCardId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isSelected()) {
                    view.setSelected(false);
                    odndSubmitId.setVisibility(View.INVISIBLE);
                } else {
                    view.setSelected(true);
                    odndSubmitId.setVisibility(View.VISIBLE);
                }
                hzmtCardId.setSelected(false);
                dvirCardId.setSelected(false);
            }
        });
        hzmtCardId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isSelected()) {
                    view.setSelected(false);
                    odndSubmitId.setVisibility(View.INVISIBLE);
                } else {
                    view.setSelected(true);
                    odndSubmitId.setVisibility(View.VISIBLE);
                }
                trailerCardId.setSelected(false);
                dvirCardId.setSelected(false);
            }
        });
        dvirCardId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isSelected()) {
                    view.setSelected(false);
                    odndSubmitId.setVisibility(View.INVISIBLE);
                } else {
                    view.setSelected(true);
                    odndSubmitId.setVisibility(View.VISIBLE);
                }
                trailerCardId.setSelected(false);
                hzmtCardId.setSelected(false);
            }
        });
        odndSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedDuty.equals("odnd")) {
                    if (trailerCardId.isSelected()) {
                        String selectedMode = "Trailer";
                        Intent intent = new Intent(odnd.this, odnd_trailer.class);
                        extras.putString("MODE", selectedMode);
                        intent.putExtras(extras);
                        startActivity(intent);
                    } else if (hzmtCardId.isSelected()) {
                        String selectedMode = "HZMT";
                        Intent intent = new Intent(odnd.this, odnd_trailer.class);
                        extras.putString("MODE", selectedMode);
                        intent.putExtras(extras);
                        startActivity(intent);
                    }
                }
                else if (selectedDuty.equals("yard"))
                {
                    Intent intent = new Intent(odnd.this, odnd_trailer.class);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
                else if (selectedDuty.equals("offduty"))
                {
                    Intent intent = new Intent(odnd.this, odnd_trailer.class);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
                else if (selectedDuty.equals("sleeperberth"))
                {
                    Intent intent = new Intent(odnd.this, odnd_trailer.class);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
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
//    public void gotoTrailerPage(View view) {
//        CardView trailerCard = (CardView) findViewById(R.id.trailerCardId);
//        if (trailerCard.isSelected()) {
//            Intent intent = new Intent(odnd.this, odnd_trailer.class);
//            startActivity(intent);
//        }
//    }
}