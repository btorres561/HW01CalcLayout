package com.briantorres.hw01calclayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main_view);

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    public void loadTableLayout(View clickedView) {
        setContentView(R.layout.secondary_view);
        onClick(clickedView);
        ViewGroup parent = findViewById(R.id.parentTableLayout);
    }

    public void loadLinearLayout(View clickedView) {
        setContentView(R.layout.main_view);
        onClick(clickedView);
        ViewGroup parent = findViewById(R.id.parentVerticalLayout);
    }

    public void onClick(View v)
    {
        Button b = (Button) v;
        Toast.makeText(this, b.getText().toString(), Toast.LENGTH_SHORT).show();
        Log.d("BTN_CLICK", b.getText().toString());
    }
}