package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.TransferDAO;
import com.techelevator.tenmo.exception.UserNotFoundException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.security.UserNotActivatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;


@PreAuthorize("isAuthenticated()")
@RestController
public class AccountController {


    @Autowired
    private AccountDAO dao;


    @Autowired
    private TransferDAO transferDAO;

    @PreAuthorize("permitAll")
    @RequestMapping(path = "accounts/{user_id}", method = RequestMethod.GET)
    public Account retrieveBalanceByUserId(@PathVariable int user_id) throws UserNotFoundException {
        return dao.getAccountBalance(user_id);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "accounts", method = RequestMethod.GET)
    public List<Account> retrieveAccounts() {
        return dao.retrieveListOfAccounts();
    }


    @PreAuthorize("permitAll")
    @RequestMapping(path = "transfers/{account_from}", method = RequestMethod.GET)
    public List<Transfer> getTransfers(@PathVariable int account_from) throws UserNotFoundException {  //principal
        System.out.println("i  am here");
        return transferDAO.retrieveTransferList(account_from);

    }
}