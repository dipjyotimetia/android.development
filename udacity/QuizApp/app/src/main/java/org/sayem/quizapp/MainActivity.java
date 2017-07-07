package org.sayem.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mScore = 0;
    private int mEditor = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onSubtract(View view) {

        RadioButton firstRadioButton = (RadioButton) findViewById(R.id.subtraction1);
        RadioButton secondRadioButton = (RadioButton) findViewById(R.id.subtraction2);
        RadioButton thirdRadioButton = (RadioButton) findViewById(R.id.subtraction3);
        RadioButton fourthRadioButton = (RadioButton) findViewById(R.id.subtraction4);

        if (firstRadioButton.isChecked()) {
            Toast.makeText(this, "Your answer is wrong", Toast.LENGTH_SHORT).show();
        } else if (secondRadioButton.isChecked()) {
            Toast.makeText(this, "Your answer is correct", Toast.LENGTH_SHORT).show();
            mScore += 1;
        } else if (thirdRadioButton.isChecked()) {
            Toast.makeText(this, "Your answer is wrong", Toast.LENGTH_SHORT).show();
        } else if (fourthRadioButton.isChecked()) {
            Toast.makeText(this, "Your answer is wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void onEvenNumber(View view) {

        CheckBox firstCheckBox = (CheckBox) findViewById(R.id.thirteen);
        CheckBox secondCheckBox = (CheckBox) findViewById(R.id.eighteen);
        CheckBox thirdCheckBox = (CheckBox) findViewById(R.id.fifteen);
        CheckBox fourthCheckBox = (CheckBox) findViewById(R.id.twenty);

        if (firstCheckBox.isChecked()) {
            Toast.makeText(this, "Your answer is wrong", Toast.LENGTH_SHORT).show();
        } else if (secondCheckBox.isChecked()) {
            Toast.makeText(this, "Your answer is correct", Toast.LENGTH_SHORT).show();
            mScore += 1;
        } else if (thirdCheckBox.isChecked()) {
            Toast.makeText(this, "Your answer is wrong", Toast.LENGTH_SHORT).show();
        } else if (fourthCheckBox.isChecked()) {
            Toast.makeText(this, "Your answer is correct", Toast.LENGTH_SHORT).show();
            mScore += 1;
        }
    }

    public void onOddNumber(View view) {
        CheckBox firstCheckBox = (CheckBox) findViewById(R.id.five);
        CheckBox secondCheckBox = (CheckBox) findViewById(R.id.six);
        CheckBox thirdCheckBox = (CheckBox) findViewById(R.id.seven);
        CheckBox fourthCheckBox = (CheckBox) findViewById(R.id.eight);

        if (firstCheckBox.isChecked()) {
            Toast.makeText(this, "Your answer is correct", Toast.LENGTH_SHORT).show();
            mScore += 1;
        } else if (secondCheckBox.isChecked()) {
            Toast.makeText(this, "Your answer is wrong", Toast.LENGTH_SHORT).show();
        } else if (thirdCheckBox.isChecked()) {
            Toast.makeText(this, "Your answer is correct", Toast.LENGTH_SHORT).show();
            mScore += 1;
        } else if (fourthCheckBox.isChecked()) {
            Toast.makeText(this, "Your answer is wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void onSubmit(View view) {
        EditText addition = (EditText) findViewById(R.id.answer);
        if (addition.getText().toString().equalsIgnoreCase(String.valueOf(mEditor))) {
            Toast.makeText(this, "Your answer is correct", Toast.LENGTH_SHORT).show();
            mScore += 1;
        } else {
            Toast.makeText(this, "Your answer is wrong", Toast.LENGTH_SHORT).show();
        }

        TextView text = (TextView) findViewById(R.id.submitButton);
        String answer = text.getText().toString();
        Toast.makeText(this, answer + ", " + "Total score is " + mScore, Toast.LENGTH_SHORT).show();

        mScore = 0;
    }
}
