package org.sayem.tourguide;

/**
 * Created by sayem on 7/10/16.
 */
public class Attraction {
    private String mTitle;
    private String mDescription;

    public Attraction(String title, String description) {
        mTitle = title;
        mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
