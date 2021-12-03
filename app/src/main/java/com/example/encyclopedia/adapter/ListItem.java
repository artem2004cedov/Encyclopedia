package com.example.encyclopedia.adapter;

public class ListItem {
    private String text;
    private boolean favarite;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isFavarite() {
        return favarite;
    }

    public void setFavarite(boolean favarite) {
        this.favarite = favarite;
    }
}
