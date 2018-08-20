package com.jxedu.bean;

public enum Season {

     SPRING("spring"),SUMMER("summer"),AUTUMUN("autumun"),WINTER("winter");

    private String value;

    Season(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
