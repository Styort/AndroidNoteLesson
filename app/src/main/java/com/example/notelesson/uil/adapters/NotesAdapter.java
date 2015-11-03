package com.example.notelesson.uil.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.notelesson.R;
import com.example.notelesson.bll.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виктор on 30.10.2015.
 */
public class NotesAdapter extends ArrayAdapter {

    ArrayList<Note> notes;
    Activity activity;
    int resource;

    public NotesAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.notes = (ArrayList<Note>) objects;
        this.resource = resource;
        this.activity = (Activity)context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(resource,null);
            ViewHolder viewHolder = new ViewHolder();

            viewHolder.name = (TextView)convertView.findViewById(R.id.note_name_text_view);
            viewHolder.shortText =(TextView)convertView.findViewById(R.id.note_short_text_text_view);

            viewHolder.name.setText(notes.get(position).getName());
            viewHolder.shortText.setText(notes.get(position).getShortText());

        }
        if(notes.get(position).isChecked()){
            convertView.setBackgroundColor(Color.GREEN);
        }
        return convertView;
    }
    private class ViewHolder {
        public TextView name;
        public TextView shortText;

    }
}
