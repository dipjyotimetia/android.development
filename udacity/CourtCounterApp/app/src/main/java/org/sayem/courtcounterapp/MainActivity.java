package org.sayem.courtcounterapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int teamAPoint = 0;
    private int teamBPoint = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Team A "+1 POINTS" button is clicked.
     */
    public void addOnePointToTeamA(View view) {
        teamAPoint = teamAPoint + 1;
        displayTeamAValue(teamAPoint);
    }

    /**
     * This method is called when the Team A "+2 POINTS" button is clicked.
     */
    public void addTwoPointToTeamA(View view) {
        teamAPoint = teamAPoint + 2;
        displayTeamAValue(teamAPoint);
    }

    /**
     * This method is called when the Team A "+3 POINTS" button is clicked.
     */
    public void addThreePointToTeamA(View view) {
        teamAPoint = teamAPoint + 3;
        displayTeamAValue(teamAPoint);
    }

    /**
     * This method is called when the Team B "+1 POINTS" button is clicked.
     */
    public void addOnePointToTeamB(View view) {
        teamBPoint = teamBPoint + 1;
        displayTeamBValue(teamBPoint);
    }

    /**
     * This method is called when the Team B "+2 POINTS" button is clicked.
     */
    public void addTwoPointToTeamB(View view) {
        teamBPoint = teamBPoint + 2;
        displayTeamBValue(teamBPoint);
    }

    /**
     * This method is called when the Team B "+3 POINTS" button is clicked.
     */
    public void addThreePointToTeamB(View view) {
        teamBPoint = teamBPoint + 3;
        displayTeamBValue(teamBPoint);
    }

    /**
     * This method is called when the RESET button is clicked.
     */
    public void resetPoints(View view) {
        teamAPoint = 0;
        teamBPoint = 0;
        displayTeamAValue(teamAPoint);
        displayTeamBValue(teamBPoint);
    }

    /**
     * This method display Team A points on the screen.
     */
    private void displayTeamAValue(int number){
        TextView quantity = (TextView) findViewById(R.id.teamAValue);
        quantity.setText("" + number);
    }

    /**
     * This method display Team B points on the screen.
     */
    private void displayTeamBValue(int number){
        TextView quantity = (TextView) findViewById(R.id.teamBValue);
        quantity.setText("" + number);
    }

}
