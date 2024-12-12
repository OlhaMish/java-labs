package com.olechok.task1;


public class Bank {
    public void transfer(Account from, Account to, int amount) {
        Account first = from.hashCode() < to.hashCode() ? from : to;
        Account second = from.hashCode() < to.hashCode() ? to : from;

        first.getLock().lock();
        try {
            second.getLock().lock();
            try {
                if (from.getBalance() < amount) {
                    throw new IllegalArgumentException("Insufficient funds in source account");
                }
                from.withdraw(amount);
                to.deposit(amount);
            } finally {
                second.getLock().unlock();
            }
        } finally {
            first.getLock().unlock();
        }
    }
}
