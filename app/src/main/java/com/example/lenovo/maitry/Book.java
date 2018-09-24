package com.example.lenovo.maitry;

public class Book {
    String bid;
    String uname;
    String phno;
    String bookname;
    String sub;
    String year;
    String price;
    String des;

    public Book() {
    }

    public Book(String uname, String phno, String bookname) {
        this.uname = uname;
        this.phno = phno;
        this.bookname = bookname;
    }
    @Override
    public final String toString(){
        return bookname;
    }

    public Book(String bid, String uname, String phno, String bookname, String sub, String year, String price, String des) {
        this.bid = bid;
        this.uname = uname;
        this.phno = phno;
        this.bookname = bookname;
        this.sub = sub;
        this.year = year;
        this.price = price;
        this.des = des;
    }

    public String getBid() {
        return bid;
    }

    public String getUname() {
        return uname;
    }

    public String getPhno() {
        return phno;
    }

    public String getBookname() {
        return bookname;
    }

    public String getSub() {
        return sub;
    }

    public String getYear() {
        return year;
    }

    public String getPrice() {
        return price;
    }

    public String getDes() {
        return des;
    }
}
