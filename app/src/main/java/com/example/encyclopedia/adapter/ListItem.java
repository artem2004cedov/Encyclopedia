package com.example.encyclopedia.adapter;

public class ListItem {
    private String text;
    private String cat;
    private boolean favarite;

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

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
