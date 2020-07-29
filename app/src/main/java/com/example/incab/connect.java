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

import android.view.MenuItem;
import android.view.View;

public class connect extends AppCompatActivity {
    public static Bundle extras = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        // ******** code for back button begins *********//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        // ******** code for back button ends *********//

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.logoutButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(connect.this, MainActivity.class);
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

    public void gotoHomePage(View view) {
        Intent intent = new Intent(connect.this, duty.class);
//        Intent intent = new Intent(connect.this, odnd_trailer.class);
//        String selectedDuty = "driving";
//        String selectedMode = "driving";
//        extras.putString("DUTY",selectedDuty);
//        extras.putString("Mode",selectedMode);
//        intent.putExtras(extras);
        startActivity(intent);


    }

}