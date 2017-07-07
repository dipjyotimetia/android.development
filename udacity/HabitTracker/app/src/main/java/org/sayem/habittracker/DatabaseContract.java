package org.sayem.habittracker;

/**
 * Created by sayem on 7/14/16.
 */
public class DatabaseContract {

    public static final String DATABASE_NAME = "habits.db";

    public abstract class PostTable {

        public static final String TABLE_NAME = "habit_table";
        public static final String ID = "ID";
        public static final String GYM = "Gym";
        public static final String SPENDING = "Spending";
        public static final String FRUITS = "Eat 5 fruits/veggies a day";
        public static final String VITAMINS = "Take morning vitamins";

    }

}