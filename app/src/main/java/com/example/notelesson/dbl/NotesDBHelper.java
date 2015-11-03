package com.example.notelesson.dbl;

import com.example.notelesson.bll.Note;

import java.util.ArrayList;

/**
 * Created by Виктор on 30.10.2015.
 */
public class NotesDBHelper {

    ArrayList<Note> notes;
    public NotesDBHelper(){
        notes = new ArrayList<>();
        loadFromDB();
    }

    private void loadFromDB() {
        notes.add(new Note("adasda","adsda"));
        notes.add(new Note("adasda","adsda"));
        notes.add(new Note("adasda","adsda"));
        notes.add(new Note("adasda","adsda"));
        notes.add(new Note("adasda","adsda"));
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }
}
