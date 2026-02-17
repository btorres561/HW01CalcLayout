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
        aDisplay.setText(A + " " + op);
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
        if (B.equals("0"))
        {
            B = value;
        }
        else
        {
            B = B + value;
        }
        refreshDisplays();
    }

    public void btnPressOperator(View v)
    {
        refreshDisplays();
        String value = (String) ((Button) v).getText();
        op = value;
        A = B;
        B = "0";
        refreshDisplays();
    }

    public void btnPressAC(View v)
    {
        refreshDisplays();
        A = "0";
        B = "0";
        op = "+";
        refreshDisplays();
    }

    public void btnPressSign(View v)
    {
        refreshDisplays();

        // Do nothing for plain zero
        if (B.matches("0(\\.0*)?"))
            return;

        if (B.contains(".")) {
            // decimal number → use float
            float bFloat = Float.parseFloat(B);
            bFloat *= -1;
            B = Float.toString(bFloat);
        } else {
            // whole number → use int
            int bInt = Integer.parseInt(B);
            bInt *= -1;
            B = Integer.toString(bInt);
        }

        refreshDisplays();
    }

    public void btnPressPercent(View v)
    {
        refreshDisplays();
        float answer = 0;
        if(!B.matches("0(\\.0*)?"))
        {
            answer = (Float.parseFloat(A)/Float.parseFloat(B))*100;
            A = A + "/" + B;
            B = Float.toString(answer);
        }
        else
        {
            A = A + "/" + B;
            B = "Cannot divide by zero";
        }
        op = "%";
        refreshDisplays();
        A = "0";
        B = "0";
        op = "+";
    }

    public void btnPressPeriod(View v)
    {
        refreshDisplays();
        if(!B.contains("."))
        {
            B = B + ".";
        }
        refreshDisplays();
    }

    public void btnPressEqual(View v)
    {
        refreshDisplays();
        float answer = 0;
        if(A.matches("0(\\.0*)?") && B.matches("0(\\.0*)?"))
        {
            return;
        }
        if(op.equals("/"))
        {
            if(B.matches("0(\\.0*)?"))
            {
                A = A + " / " + B;
                B = "Cannot divide by zero";
                refreshDisplays();
                A = "0";
                B = "0";
                op = "+";
                return;
            }
            else
            {
                answer = Float.parseFloat(A)/Float.parseFloat(B);
                A = A + " / " + B;
            }
        }
        else if (op.equals("*"))
        {
            answer = Float.parseFloat(A)*Float.parseFloat(B);
            A = A + " * " + B;
        }
        else if (op.equals("-"))
        {
            answer = Float.parseFloat(A)-Float.parseFloat(B);
            A = A + " - " + B;
        }
        else
        {
            answer = Float.parseFloat(A)+Float.parseFloat(B);
            A = A + " + " + B;
        }
        B = Float.toString(answer);
        op = " = ";
        refreshDisplays();
        A = "0";
        B = "0";
        op = "+";
    }

}