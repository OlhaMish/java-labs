package com.olechok.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankTest {
    public static void main(String[] args) throws InterruptedException {
        int numberOfAccounts = 100;
        int initialBalance = 1000;
        int numberOfThreads = 1000;

        Bank bank = new Bank();
        List<Account> accounts = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfAccounts; i++) {
            accounts.add(new Account(initialBalance));
        }

        int initialTotalBalance = accounts.stream().mapToInt(Account::getBalance).sum();
        System.out.println("Initial total balance: " + initialTotalBalance);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                Account from = accounts.get(random.nextInt(accounts.size()));
                Account to = accounts.get(random.nextInt(accounts.size()));
                int amount = random.nextInt(100);
                if (from != to) {
                    try {
                        bank.transfer(from, to, amount);
                    } catch (IllegalArgumentException ignored) {
                    }
                }
            });
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(10);
        }

        int finalTotalBalance = accounts.stream().mapToInt(Account::getBalance).sum();
        System.out.println("Final total balance: " + finalTotalBalance);

        if (initialTotalBalance == finalTotalBalance) {
            System.out.println("Test passed: Total balance is consistent");
        } else {
            System.err.println("Test failed: Total balance is inconsistent");
        }
    }
}
