package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTransferDAO implements TransfersDAO {
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
}



