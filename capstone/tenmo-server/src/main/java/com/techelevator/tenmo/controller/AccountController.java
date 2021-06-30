package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.exception.UserNotFoundException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.security.UserNotActivatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;


@PreAuthorize("isAuthenticated()")
@RestController
public class AccountController {


    @Autowired
    private AccountDAO  dao;

    @PreAuthorize("permitAll")
    @RequestMapping(path = "accounts/{user_id}", method = RequestMethod.GET)
    public Account retrieveBalanceByUserId(@PathVariable int  user_id) throws UserNotFoundException {
        return dao.getAccountBalance(user_id);
    }



}
