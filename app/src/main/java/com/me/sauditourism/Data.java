package com.me.sauditourism;

class Data {

   private int position;

   private String txt;

   private int [] images;

    Data(int position, String txt, int[] images) {
        this.position = position;
        this.txt = txt;
        this.images = images;
    }

    int getPosition() { return position; }

    String getTxt() {
        return txt;
    }

    int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }
}