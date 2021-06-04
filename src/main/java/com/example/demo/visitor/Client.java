package com.example.demo.visitor;

import java.math.BigDecimal;

/**
 * 访问者模式
 */
public class Client {
    public static void main(String[] args) {
        AccountBook accountBook = new AccountBook();
        //添加两条收入
        accountBook.addBill(new IncomeBill(new BigDecimal(11000), "卖商品"));
        accountBook.addBill(new IncomeBill(new BigDecimal(12000), "卖广告位"));
        //添加两条支出
        accountBook.addBill(new PayBill(new BigDecimal(1000), "工资"));
        accountBook.addBill(new PayBill(new BigDecimal(2000), "材料费"));

        AccountBookViewer boss = new Boss();


        //两个访问者分别访问账本

        accountBook.show(boss);

        ((Boss) boss).getTotalConsume();
        ((Boss) boss).getTotalIncome();
    }
}
