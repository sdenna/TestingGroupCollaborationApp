package com.example.tipcalculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateTip(View v)
    {
        EditText billEditText = (EditText) findViewById(R.id.billEditText);
        EditText percentEditText = (EditText) findViewById(R.id.percentEditText);
        TextView totalTextView = (TextView) findViewById(R.id.totalTextView);
        TextView tipTextView = (TextView) findViewById(R.id.tipTextView);

        double bill_without_tip = Double.parseDouble(billEditText.getText().toString());
        double percent = Double.parseDouble(percentEditText.getText().toString());

        double tipAmount = percent / 100 * bill_without_tip;
        double finalTotal = bill_without_tip + tipAmount;

        DecimalFormat df = new DecimalFormat("$#.00");

        tipTextView.setText(df.format(tipAmount));
        totalTextView.setText(df.format(finalTotal));     // need to make it a string

    }
}
