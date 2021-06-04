package com.example.demo.visitor;

public interface AccountBookViewer {

    void income(IncomeBill incomeBill);
    void pay(PayBill payBill);
}
