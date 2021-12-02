package com.company.Netology;

import java.util.concurrent.atomic.LongAdder;

public class TaxReport {
    private final LongAdder adder = new LongAdder();

    public long getTotalRevenues() {
        return adder.sum();
    }

    protected void addToAdder(long sumAccountRevenue) {
        adder.add(sumAccountRevenue);
    }

    public void printAdderResult() {
        System.out.println("Общая выручка 3-х магазинов составила " + getTotalRevenues());
    }


}
