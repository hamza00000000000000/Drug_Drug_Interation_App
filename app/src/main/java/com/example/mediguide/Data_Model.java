package com.example.mediguide;

public class Data_Model {
    private String medicine_name;
    private int remove_img;

    public Data_Model(String medicine_name, int remove_img) {
        this.medicine_name = medicine_name;
        this.remove_img = remove_img;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public int getRemove_img() {
        return remove_img;
    }

    public void setRemove_img(int remove_img) {
        this.remove_img = remove_img;
    }
}

