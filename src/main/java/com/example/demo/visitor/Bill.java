package com.example.demo.visitor;

public interface Bill {
    void accept(AccountBookViewer accountBookViewer);
}
