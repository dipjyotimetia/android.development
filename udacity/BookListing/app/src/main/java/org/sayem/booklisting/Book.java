package org.sayem.booklisting;

import android.text.TextUtils;

/**
 * Created by sayem on 7/11/16.
 */
public class Book {

    private String mTitle;
    private String[] mAuthors;

    public Book(String title, String[] authors) {
        mTitle = title;
        mAuthors = authors;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthors() {
        return TextUtils.join(", ", mAuthors);
    }
}
