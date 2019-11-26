package com.architecture.three.order.model;

public class Order {
    private String no;
    private double totalPrice;
    private int number;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Order(String no, double totalPrice, int number) {
        this.no = no;
        this.totalPrice = totalPrice;
        this.number = number;
    }
}
