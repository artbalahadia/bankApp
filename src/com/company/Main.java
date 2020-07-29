package com.company;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("DeLuxe Bank");

        bank.addBranch("Ibiza");
        bank.addCustomer("Ibiza", "Arturo", 750000);
        bank.addCustomer("Ibiza", "Cody", 45000);

        bank.addBranch("Maldives");
        bank.addCustomer("Maldives", "Czar", 60000);
        bank.addCustomer("Maldives", "Adrian", 50000);

        bank.addTransaction("Ibiza", "Arturo",20000.75);
        bank.addTransaction("Ibiza", "Cody", 1000.50);

        bank.addTransaction("Maldives", "Czar", 5000.10);
        bank.addTransaction("Maldives", "Adrian", 750.75);

        bank.listCustomers("Ibiza", true);
        bank.listCustomers("Maldives",true);

    }
}
