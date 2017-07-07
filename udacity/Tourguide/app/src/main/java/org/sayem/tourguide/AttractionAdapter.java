package org.sayem.tourguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sayem on 7/10/16.
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {
    private int mImageResourceId;
    private int mColorResourceId;

    public AttractionAdapter(Context context, ArrayList<Attraction> attractions, int imageResourceId, int colorResourceId) {
        super(context, 0, attractions);
        mImageResourceId = imageResourceId;
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Attraction currentWord = getItem(position);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentWord.getTitle());
        titleTextView.setBackgroundColor(color);

        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        descriptionTextView.setText(currentWord.getDescription());
        descriptionTextView.setBackgroundColor(color);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(mImageResourceId);
        imageView.setBackgroundColor(color);

        LinearLayout textContainer = (LinearLayout) listItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}

