package edu.sjsu.android.mortgagecalculator;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText text;
    private SeekBar sBar;
    private TextView textFromBar;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.editText);
        textFromBar = (TextView) findViewById(R.id.textViewBar);
        result = (TextView) findViewById(R.id.textView);
        sBar = (SeekBar) findViewById(R.id.seekBar);
        textFromBar.setText(String.valueOf((float)sBar.getProgress()));
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float s = (float) i;
                textFromBar.setText(String.valueOf(s));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:

                CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
                RadioButton Button15 =
                        (RadioButton) findViewById(R.id.radioButton15);
                RadioButton Button20 =
                        (RadioButton) findViewById(R.id.radioButton20);
                RadioButton Button30 =
                        (RadioButton) findViewById(R.id.radioButton30);



                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                if (inputValue < 0) {
                    Toast.makeText(this, "Please enter a positive number",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                float interest = Float.parseFloat(textFromBar.getText().toString());
                float years = 15;

                if (Button15.isChecked()) {
                    years = 15;
                }
                else if (Button20.isChecked()) {
                    years = 20;
                }
                else if (Button30.isChecked()) {
                    years = 30;
                }

                 result.setText("Your monthly payment is $" + String
                        .format("%.2f",Calculator.CalculateInterest(inputValue, years,
                                interest, checkBox.isChecked())));
                break;
        }
    }


}