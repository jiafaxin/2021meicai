package com.example.demo.visitor;

import java.math.BigDecimal;


public class PayBill implements Bill {

    private BigDecimal bill;

    private String desc;

    public PayBill(BigDecimal bill, String desc) {
        this.bill = bill;
        this.desc = desc;
    }

    @Override
    public void accept(AccountBookViewer accountBookViewer) {
        accountBookViewer.pay(this);
    }

    public BigDecimal getBill() {
        return bill;
    }

    public void setBill(BigDecimal bill) {
        this.bill = bill;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
