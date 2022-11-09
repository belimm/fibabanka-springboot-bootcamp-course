package com.example.orm.configuration;

public class MyBean {
    private Long myLong;

    private String myString;

    private Double myDouble;

    public MyBean() {
    }

    public MyBean(Long myLong, String myString, Double myDouble) {
        this.myLong = myLong;
        this.myString = myString;
        this.myDouble = myDouble;
    }

    public Long getMyLong() {
        return myLong;
    }

    public void setMyLong(Long myLong) {
        this.myLong = myLong;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public Double getMyDouble() {
        return myDouble;
    }

    public void setMyDouble(Double myDouble) {
        this.myDouble = myDouble;
    }
}
