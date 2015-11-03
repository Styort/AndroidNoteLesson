package com.example.notelesson.uil.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notelesson.R;

/**
 * Created by Виктор on 30.10.2015.
 */
public class AddNewNoteActivity extends AppCompatActivity {
    EditText nameEditText,fullTextEditText;
    Button addNewNoteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_note);

        initUi();
    }

    private void initUi() {
        initEditTexts();
        initButton();
    }

    private void initButton() {
        addNewNoteButton = (Button)findViewById(R.id.create_new_note_button);
        addNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditTextsNotFilled()){
                    Toast.makeText(getApplicationContext(),"Не все поля заполнены!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent();
                    intent.putExtra("NoteName",nameEditText.getText().toString());
                    intent.putExtra("NoteFullText",fullTextEditText.getText().toString());

                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    private boolean isEditTextsNotFilled() {
        return (nameEditText.getText().toString().equals("")||
                fullTextEditText.getText().toString().equals(""));
    }

    private void initEditTexts() {
        nameEditText = (EditText)findViewById(R.id.note_name_edit_text);
        fullTextEditText = (EditText)findViewById(R.id.note_fulltext__edit_text);
    }
}
