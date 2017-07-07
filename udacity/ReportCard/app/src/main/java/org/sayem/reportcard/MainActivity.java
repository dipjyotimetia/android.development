package org.sayem.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReportCard reportCard = new ReportCard();

        reportCard.addGrade(ReportCard.Marks.A);
        reportCard.addGrade(ReportCard.Marks.B);
        reportCard.addGrade(ReportCard.Marks.A);
        reportCard.addGrade(ReportCard.Marks.C);
        reportCard.addGrade(ReportCard.Marks.D);
        reportCard.addGrade(ReportCard.Marks.F);

        Log.v("Test", reportCard.toString());
    }
}
