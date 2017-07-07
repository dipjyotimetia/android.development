package org.sayem.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView beaches = (TextView) findViewById(R.id.landmark);

        // Set a click listener on that View
        beaches.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent beachesIntent = new Intent(MainActivity.this, LandmarkActivity.class);

                // Start the new activity
                startActivity(beachesIntent);
            }
        });

        TextView trails = (TextView) findViewById(R.id.museum);

        // Set a click listener on that View
        trails.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent trailsIntent = new Intent(MainActivity.this, MuseumsActivity.class);

                // Start the new activity
                startActivity(trailsIntent);
            }
        });

        TextView fun = (TextView) findViewById(R.id.park);

        // Set a click listener on that View
        fun.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent funIntent = new Intent(MainActivity.this, ParkActivity.class);

                // Start the new activity
                startActivity(funIntent);
            }
        });

        TextView food = (TextView) findViewById(R.id.shopping);

        // Set a click listener on that View
        food.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent foodIntent = new Intent(MainActivity.this, ShoppingActivity.class);

                // Start the new activity
                startActivity(foodIntent);
            }
        });
    }
}
