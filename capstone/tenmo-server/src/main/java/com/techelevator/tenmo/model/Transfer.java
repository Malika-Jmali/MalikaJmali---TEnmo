package com.techelevator.tenmo.model;

public class Transfer {
    private int transfer_id;
    private int transfers_type_id;
    private int transfers_status_id;
    private int account_from;
    private int account_to;
    private double amount;
    private String userIdentity;
    private double userBalance;

    public Transfer(int transfer_id, int transfers_type_id, int transfers_status_id, int account_from, int account_to, double amount, String transfer_type_desc) {
        this.transfer_id = transfer_id;
        this.transfers_type_id = transfers_type_id;
        this.transfers_status_id = transfers_status_id;
        this.account_from = account_from;
        this.account_to = account_to;
        this.amount = amount;
    }

    public Transfer() {
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }

    public int getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(int transfer_id) {
        this.transfer_id = transfer_id;
    }

    public int getTransfers_type_id() {
        return transfers_type_id;
    }

    public void setTransfers_type_id(int transfers_type_id) {
        this.transfers_type_id = transfers_type_id;
    }

    public int getTransfers_status_id() {
        return transfers_status_id;
    }

    public void setTransfers_status_id(int transfers_status_id) {
        this.transfers_status_id = transfers_status_id;
    }

    public int getAccount_from() {
        return account_from;
    }

    public void setAccount_from(int account_from) {
        this.account_from = account_from;
    }

    public int getAccount_to() {
        return account_to;
    }

    public void setAccount_to(int account_to) {
        this.account_to = account_to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
