package com.company.Netology;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final TaxReport taxReport = new TaxReport();

        Account accountShop1 = new Account("Магазин звездочка", taxReport);
        Account accountShop2 = new Account("Магазин зебра", taxReport);
        Account accountShop3 = new Account("Магазин лучик", taxReport);

        accountShop1.start();
        accountShop2.start();
        accountShop3.start();

        accountShop1.join();
        accountShop2.join();
        accountShop3.join();

        taxReport.printAdderResult();


    }
}
