package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.UserNotFoundException;
import com.techelevator.tenmo.model.Account;

public interface AccountDAO {
    public Account getAccountBalance(int user_id) throws UserNotFoundException;

}
