package com.example.tipcalculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    SeekBar simpleSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        In this step we open MainActivity and add the code to initiate the seekbar
        and then perform seekbar changed listener event for getting the changes in
        the progress of the seekbar. By using this event listener we set get the
        current value of a seekbar and when a user stop the tracking touch, the
        value of progress is displayed by using a Toast.
         */

        // initiate  views
        simpleSeekBar=(SeekBar)findViewById(R.id.tipSeekBar);

        // perform seek bar change listener event used for getting the progress value
        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
              //  Toast.makeText(MainActivity.this, "Seek bar progress is :" + progressChangedValue,
                //        Toast.LENGTH_SHORT).show();

                updateTipTotalTextViews(progressChangedValue);
            }
        });

    }

    public void updateTipTotalTextViews(int tipPercent){
        EditText billEditText = (EditText) findViewById(R.id.billEditText);
        EditText percentEditText = (EditText) findViewById(R.id.percentEditText);
        TextView totalTextView = (TextView) findViewById(R.id.totalTextView);
        TextView tipTextView = (TextView) findViewById(R.id.tipTextView);

        double bill_without_tip = 0;

        try {
            bill_without_tip = Double.parseDouble(billEditText.getText().toString());

            double tipAmount = tipPercent / 100.0 * bill_without_tip;
            double finalTotal = bill_without_tip + tipAmount;

            DecimalFormat df = new DecimalFormat("$#.00");

            tipTextView.setText(df.format(tipAmount));
            totalTextView.setText(df.format(finalTotal));     // need to make it a string
            percentEditText.setText(tipPercent + "");



        }
        catch (Exception e) {
              Toast.makeText(MainActivity.this, "Please enter the amount of the bill",
                    Toast.LENGTH_SHORT).show();


        }


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
