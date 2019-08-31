package ood.builder;

import javax.print.DocFlavor;

// a normal bank account class
public class BankAccount {
    private long accountNumber;
    private String owner;
    private String branch;
    private double balance;
    private double interestRate;

    public BankAccount(long accountNumber, String owner, String branch, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.branch = branch;
        this.balance = balance;
        this.interestRate = interestRate;
    }
}

class BankAccountWithBuilder{
    private long accountNumber; // this is important, give it to the constructor
    private String owner;
    private String branch;
    private double balance;
    private double interestRate;
    // constructor is now private
    private BankAccountWithBuilder() {

    }
    public static class Builder {
        private long accountNumber; // this is important, give it to the constructor
        private String owner;
        private String branch;
        private double balance;
        private double interestRate;

        public Builder(long accountNumber) {
            this.accountNumber = accountNumber;
        }

        public Builder withOwner(String owner) {
            this.owner = owner;
            return this; // by returning the builder each time, we get a fluent interface
        }

        public Builder atBranch(String branch) {
            this.branch = branch;
            return this;
        }

        public Builder openingBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder openingInterestRate(double interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public BankAccountWithBuilder build() {
            BankAccountWithBuilder account = new BankAccountWithBuilder();
            account.accountNumber = this.accountNumber;
            account.owner = this.owner;
            account.branch = this.branch;
            account.balance = this.balance;
            account.interestRate = this.interestRate;
            return account;
        }
    }
}
