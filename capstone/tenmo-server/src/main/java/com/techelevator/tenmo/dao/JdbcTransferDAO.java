package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDAO implements TransferDAO {
    private JdbcTemplate jdbcTemplate;

    public JdbcTransferDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Transfer makeTransfer(Transfer transfer) {
        String transferSQL = "INSERT INTO transfers (transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount) VALUES (?, ?, ?, ?, ?, ?);\n";
        jdbcTemplate.update(transferSQL,
                transfer.getTransfer_id(),
                transfer.getTransfers_type_id(),
                transfer.getTransfers_status_id(),
                transfer.getAccount_from(),
                transfer.getAccount_to(),
                transfer.getAmount());
        return transfer;
    }

    @Override
    public List<Transfer> retrieveTransferList(int account_from) {
        List<Transfer> transfers = new ArrayList<Transfer>();

        String sql = "SELECT transfers.transfer_id, transfers.transfer_type_id, transfers.transfer_status_id, transfers.account_from, transfers.account_to, transfers.amount, accounts.balance, users.username from transfers " +
                "JOIN accounts ON accounts.account_id=transfers.account_to " +
                "JOIN users ON users.user_id=accounts.user_id " +
                "WHERE transfers.account_from = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,account_from);

        while (rowSet.next()) {
            Transfer transfer = mapRowToTransfer(rowSet);
            transfers.add(transfer);
        }

        return transfers;
    }

    private Transfer mapRowToTransfer(SqlRowSet rows) {
        Transfer transfer = new Transfer();
        transfer.setTransfer_id(rows.getInt("transfer_id"));
        transfer.setTransfers_type_id(rows.getInt("transfer_type_id"));
        transfer.setTransfers_status_id(rows.getInt("transfer_status_id"));
        transfer.setAccount_from(rows.getInt("account_from"));
        transfer.setAccount_to(rows.getInt("account_to"));
        transfer.setAmount(rows.getDouble("amount"));
        transfer.setUserBalance(rows.getDouble("balance"));
        transfer.setUserIdentity(rows.getString("username"));

        return transfer;
    }


}



