package com.example.demo.visitor;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class IncomeBill implements Bill {

    private BigDecimal bill;

    private String desc;

    public IncomeBill(BigDecimal bill, String desc) {
        this.bill = bill;
        this.desc = desc;
    }

    @Override
    public void accept(AccountBookViewer accountBookViewer) {
        accountBookViewer.income(this);
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
