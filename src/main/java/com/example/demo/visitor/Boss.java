package com.example.demo.visitor;

import java.math.BigDecimal;

public class Boss implements AccountBookViewer {

    private BigDecimal income = new BigDecimal(0);

    private BigDecimal pay = new BigDecimal(0);


    @Override
    public void income(IncomeBill incomeBill) {
        income = income.add(incomeBill.getBill());
    }

    @Override
    public void pay(PayBill payBill) {
        pay = pay.add(payBill.getBill());
    }

    public BigDecimal getTotalIncome() {
        System.out.println("老板查看一共收入多少，数目是：" + income);
        return income;
    }

    public BigDecimal getTotalConsume() {
        System.out.println("老板查看一共花费多少，数目是：" + pay);
        return pay;
    }

}
