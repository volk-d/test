package ru.dixy.sorting.model;

import java.util.Arrays;

public class Units {

    private String str;

    public Units() {
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String[] getArr(){
            return str.split("\r\n");
    }
}

