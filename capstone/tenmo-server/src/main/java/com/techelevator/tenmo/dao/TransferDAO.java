package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDAO {
Transfer makeTransfer(Transfer transfer);

public List<Transfer> retrieveTransferList(int account_from) ;


}
