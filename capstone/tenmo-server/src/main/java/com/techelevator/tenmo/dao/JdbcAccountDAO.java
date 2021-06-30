package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.UserNotFoundException;
import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component

public class JdbcAccountDAO implements AccountDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getAccountBalance(int user_id) throws UserNotFoundException {
Account account = null;
String sql = "SELECT accounts.account_id, accounts.user_id, accounts.balance FROM accounts\n" +
        "JOIN users ON users.user_id = accounts.user_id \n" +
        "WHERE users.user_id =? ;";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql,user_id);
        if(rows.next()) {
            account=mapRowAccount(rows);
        }
        if( account==null){
            throw new UserNotFoundException();
        }
        return account;

    }
    private Account mapRowAccount(SqlRowSet rows){
        Account account = new Account();
        account.setAccount_id(rows.getInt("account_id"));
        account.setUser_id(rows.getInt("user_id"));
        account.setBalance(rows.getDouble("balance"));
        account.setUser_name(rows.getString("username"));
return account;
    }
}