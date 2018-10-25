package com.sanmel.thread;

/**
 * @ Description: 线程通信
 * @ Author: yanhao
 * @ Date: 2018/9/7 11:19
 **/
public class CommunicationThread {

}

class Account {
    private String accountNo;
    private double balance;

    private boolean flag = false;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public synchronized void draw(double drawAmount) {
        try {
            if (!flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + "取钱:" + drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额：" + balance);
                flag = false;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void deposit(double depositAmount) {
        try {
            if (flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + "存钱：" + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为：" + balance);
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
