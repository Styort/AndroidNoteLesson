package com.example.notelesson.bll;

/**
 * Created by Виктор on 30.10.2015.
 */
public class Note {
    private String name;
    private String shortText;
    private String fullText;
    private boolean isChecked;

    public Note(String fullText, String name) {
        this.fullText = fullText;
        this.name = name;
        this.shortText = fullText.length()<20?fullText:fullText.substring(0,20) + "...";
        isChecked = false;
    }

    public void  setAsChecked(){
        isChecked = true;
    }
    public  boolean isChecked(){
        return isChecked;
    }
    public String getName() {
        return name;
    }

    public String getShortText() {
        return shortText;
    }

    public String getFullText() {
        return fullText;
    }
}
