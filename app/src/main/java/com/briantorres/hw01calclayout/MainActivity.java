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

        ViewGroup parent = findViewById(R.id.parentVerticalLayout);

        View.OnClickListener listener = v -> {
            Button b = (Button) v;
            Toast.makeText(this, b.getText().toString(), Toast.LENGTH_SHORT).show();
            Log.d("BTN_CLICK", b.getText().toString());
        };

        attachListenerToAllButtons(parent, listener);

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    public void loadTableLayout(View clickedView) {
        setContentView(R.layout.secondary_view);
        Button load = (Button) clickedView;
        Toast.makeText(this, load.getText().toString(), Toast.LENGTH_SHORT).show();
        Log.d("BTN_CLICK", load.getText().toString());
        ViewGroup parent = findViewById(R.id.parentTableLayout);

        View.OnClickListener listener = v -> {
            Button b = (Button) v;
            Toast.makeText(this, b.getText().toString(), Toast.LENGTH_SHORT).show();
            Log.d("BTN_CLICK", b.getText().toString());
        };

        attachListenerToAllButtons(parent, listener);
    }

    public void loadLinearLayout(View clickedView) {
        setContentView(R.layout.main_view);
        Button load = (Button) clickedView;
        Toast.makeText(this, load.getText().toString(), Toast.LENGTH_SHORT).show();
        Log.d("BTN_CLICK", load.getText().toString());
        ViewGroup parent = findViewById(R.id.parentVerticalLayout);

        View.OnClickListener listener = v -> {
            Button b = (Button) v;
            Toast.makeText(this, b.getText(), Toast.LENGTH_SHORT).show();
            Log.d("BTN_CLICK", b.getText().toString());
        };

        attachListenerToAllButtons(parent, listener);
    }

    void attachListenerToAllButtons(View view, View.OnClickListener listener) {
        if (view instanceof Button) {

            int id = view.getId();

            // 🚫 skip specific buttons
            if (id == R.id.button9 || id == R.id.button20) {
                return;
            }

            view.setOnClickListener(listener);

        } else if (view instanceof ViewGroup) {

            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                attachListenerToAllButtons(group.getChildAt(i), listener);
            }
        }
    }
}