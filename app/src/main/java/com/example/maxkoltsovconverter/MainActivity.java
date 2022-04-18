package com.example.maxkoltsovconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spFrom, spTo;
    EditText textFrom;
    TextView textTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFrom = findViewById(R.id.spinnerFrom);
        spTo = findViewById(R.id.spinnerTo);
        textFrom = findViewById(R.id.TextInputBox);
        textTo = findViewById(R.id.textViewResult);

        ArrayAdapter <String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("Mm");
        adp.add("Cm");
        adp.add("M");
        adp.add("Km");

        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }

    public void onConvert(View v){
        double from = Double.parseDouble(textFrom.getText().toString());

        String sFrom = spFrom.getSelectedItem().toString();
        String sTo = spTo.getSelectedItem().toString();

        double to = from;

        if(sFrom.equals("Mm")){
            if(sTo.equals("Cm")) to = from * 0.1f;
            else if(sTo.equals("M")) to = from * 0.001f;
            else if(sTo.equals("Km")) to = from * 0.000001f;
        }
        else if(sFrom.equals("Cm")){
            if(sTo.equals("Mm")) to = from * 10.0f;
            else if(sTo.equals("M")) to = from * 0.01f;
            else if(sTo.equals("Km")) to = from * 0.00001f;
        }
        else if(sFrom.equals("M")){
            if(sTo.equals("Mm")) to = from * 1000.0f;
            else if(sTo.equals("Cm")) to = from * 100.0f;
            else if(sTo.equals("Km")) to = from * 0.001f;
        }
        else if(sFrom.equals("Km")){
            if(sTo.equals("Mm")) to = from * 1000000.0f;
            else if(sTo.equals("Cm")) to = from * 100000.0f;
            else if(sTo.equals("M")) to = from * 1000.0f;
        }

        textTo.setText(String.valueOf(to));
    }
}