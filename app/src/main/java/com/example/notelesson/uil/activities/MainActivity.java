package com.example.notelesson.uil.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.notelesson.R;
import com.example.notelesson.bll.Note;
import com.example.notelesson.dbl.NotesDBHelper;
import com.example.notelesson.uil.adapters.NotesAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Note> notes;
    Button addNewNoteButton;
    ListView notesListView;
    NotesDBHelper notesDBHelper;
    NotesAdapter notesAdapter;

    final int ADD_NEW_NOTE_ACTIVITY_REQUEST_CODE = 1;
    final int VIEW_NOTE_ACTIVITY_REQUEST_CODE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNotes();
        initAdapter();
        initUi();
    }

    private void initAdapter() {
        notesAdapter = new NotesAdapter(this,R.layout.note_template,notes);
    }

    private void initNotes() {
        notesDBHelper = new NotesDBHelper();
        notes = notesDBHelper.getNotes();
    }

    private void initUi() {
        initNoteListView();
        initAddNewNoteButton();
    }

    private void initAddNewNoteButton() {
        addNewNoteButton = (Button)findViewById(R.id.add_new_note_button);
        addNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddNewNoteActivity.class);
                startActivityForResult(intent, ADD_NEW_NOTE_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case ADD_NEW_NOTE_ACTIVITY_REQUEST_CODE:
                onAddNewActivityResult(resultCode, data);
                break;
            case VIEW_NOTE_ACTIVITY_REQUEST_CODE:
                onViewNoteActivityResult(resultCode,data);
                break;
        }
    }

    private void onViewNoteActivityResult(int resultCode, Intent data) {
    }

    private void onAddNewActivityResult(int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String name = bundle.getString("NoteName");
            String fullText = bundle.getString("NoteFullText");

            Note newNote = new Note(name,fullText);

            notes.add(newNote);
            notesAdapter.notifyDataSetChanged();
        }
    }
    
    private void initNoteListView() {
        notesListView = (ListView)findViewById(R.id.notes_list_view);
        if(notesAdapter != null) {
            notesListView.setAdapter(notesAdapter);
        }
    }
}
