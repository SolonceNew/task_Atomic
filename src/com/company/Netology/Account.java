package com.company.Netology;

import java.awt.*;
import java.util.Random;
import java.util.stream.IntStream;

public class Account extends Thread {
    private final static int MAX_DAILY_PURCHASES = 20;
    private final static int MAX_PRICE_PER_ITEM = 100000;
    TaxReport taxReport;


    public Account(String name, TaxReport taxReport) {
        super(name);
        this.taxReport = taxReport;
    }

    @Override
    public void run() {
        long dailyRevenue = sumOfRevenues();
        System.out.printf("Выручка у %s за день составила %d\n",
                Thread.currentThread().getName(), dailyRevenue);
        taxReport.addToAdder(dailyRevenue);

    }

    private int[] createRevenuesAccount() {
        Random random = new Random();
        int dailyPurchases = random.nextInt(MAX_DAILY_PURCHASES);
        int[] revenues = new int[dailyPurchases];
        for(int i = 0; i < revenues.length; i++) {
            revenues[i] = random.nextInt(MAX_PRICE_PER_ITEM);
        }
        return revenues;
    }

    private int sumOfRevenues(){
        int[] revenuesAccount = createRevenuesAccount();
        int sumRevenues = IntStream.of(revenuesAccount).sum();
        return sumRevenues;
    }
}
