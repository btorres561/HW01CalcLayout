package com.briantorres.hw01calclayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    TextView aDisplay = null;
    TextView bDisplay = null;
    String A = "0";
    String op = "+";
    String B = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main_view);
        aDisplay = (TextView) findViewById(R.id.ADisplay);
        bDisplay = (TextView) findViewById(R.id.BDisplay);
        refreshDisplays();

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    private void refreshDisplays()
    { // update the top two row displays with the formula
        aDisplay.setText(A+op);
        bDisplay.setText(B);
    }


    public void onClick(View v)
    {
        Button b = (Button) v;
        Toast.makeText(this, b.getText().toString(), Toast.LENGTH_SHORT).show();

        Log.d("BTN_CLICK", b.getText().toString());
    }

    public void btnPressNumber(View v)
    {
        refreshDisplays();
        String value = (String) ((Button) v).getText();
    }

    public void btnPressOperator(View v)
    {
        refreshDisplays();
        String value = (String) ((Button) v).getText();
    }

    public void btnPressAC(View v)
    {
        refreshDisplays();
    }

    public void btnPressSign(View v)
    {
        refreshDisplays();
    }

    public void btnPressPercent(View v)
    {
        refreshDisplays();
    }

    public void btnPressPeriod(View v)
    {
        refreshDisplays();
    }

    public void btnPressEqual(View v)
    {
        refreshDisplays();
    }
}