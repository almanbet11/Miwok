package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorRecourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){
        super(context, 0, words);

        mColorRecourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.miwok_translation);
        miwokTranslation.setText(currentWord.getMiwokTranslation());

        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.default_translation);
        defaultTranslation.setText(currentWord.getDefaultTranslation());

        ImageView image = (ImageView) listItemView.findViewById(R.id.image_for_word);


        if(currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageResourceId());

            image.setVisibility(View.VISIBLE);
        }
        else{
            //it is when there is no image, so it has not to take some places on the screen.
            image.setVisibility(View.GONE);
        }

        //this is for passing background color to the view and setting it
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorRecourceId);
        textContainer.setBackgroundColor(color);

        ImageView micContainer = (ImageView) listItemView.findViewById(R.id.mic);
        micContainer.setBackgroundColor(color);

        return listItemView;
    }
}