package com.example.ramdantraining.View.AnimationApp;

import android.os.Bundle;

import com.example.ramdantraining.View.QuizApp.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.View;
import android.widget.TextView;

import com.example.ramdantraining.R;

import java.util.Objects;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main2Activity";
    Toolbar toolbar;
    TextView textToolBar;
    NavController navController;
    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        navController = Navigation.findNavController(Main2Activity.this, R.id.nav_host_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        toolbar = findViewById(R.id.toolbar);
        setupToolBar();
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }
    private void setupToolBar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
    }

}
