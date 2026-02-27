package tech.makers.bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankAccount {

    public String transaction = "";
    public float balance;
    public LocalDate openingDate;

    public BankAccount(Integer openingBalance) {
        this.balance = openingBalance;
        this.openingDate = LocalDate.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = openingDate.format(formatObj);
        this.transaction = String.format("%s ||  -  ||  -  || %.2f%n", formattedDate, this.balance );
    }


    public void deposit(float amount, LocalDate date) {
        this.balance = this.balance + amount;
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatObj);
        this.transaction = String.format("%s || %.2f  ||  -  || %.2f%n", formattedDate, amount, this.balance ) + this.transaction;
    };

    public void withdraw(float amount, LocalDate date) {
        this.balance = this.balance - amount;
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatObj);
        this.transaction = String.format("%s ||   -    || %.2f || %.2f%n", formattedDate, amount, this.balance) + this.transaction;
    };

    public String generateStatement() {
        return String.format("date       || credit || debit || balance%n") + this.transaction;
    };

}
