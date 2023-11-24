package com.demo.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.demo.model.Account;
import com.demo.model.TransactionDetail;
import com.demo.model.TransactionType;

public class JdbcTransactionRepositoryImpl implements TransactionRepository {
	
	private DataSource dataSource;	

	public JdbcTransactionRepositoryImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public Long addTransaction(TransactionDetail transactionDetail) throws SQLException {
		Connection connection = this.dataSource.getConnection();
		//create the statement object 
		String insertQuery = "INSERT INTO transactiondetail(accountNumber,transactionDate,amount,txtype) values(?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
		
		preparedStatement.setLong(1, transactionDetail.getAccountNumber());
		preparedStatement.setDate(2, new Date(transactionDetail.getTransactionDate().getTime()));
		preparedStatement.setInt(3, transactionDetail.getAmount());
		preparedStatement.setString(4, transactionDetail.getTxType().getType());
		
		//execute the statements 
		preparedStatement.executeUpdate();		
		
		ResultSet resultSet=preparedStatement.getGeneratedKeys();
		
		if(resultSet.next()){
			return resultSet.getLong(1);
		}
			
		return null;
	}

	public List<TransactionDetail> getAllTransactionDetailsByAccountNumber(Long accountNumber) throws SQLException {
		List<TransactionDetail> list = new ArrayList<>();
		
		Connection connection = dataSource.getConnection();
		
		String selectQuery = "SELECT * FROM transactiondetail where accountNumber = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		preparedStatement.setLong(1, accountNumber);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			TransactionDetail transaction = new TransactionDetail();
			transaction.setAccountNumber(resultSet.getLong("accountNumber"));
			transaction.setTransactionId(resultSet.getLong("transactionId"));
			transaction.setTransactionDate(resultSet.getDate("transactionDate"));
			transaction.setAmount(resultSet.getInt("amount"));
			String transactionType=resultSet.getString("txtype");
			
			if(transactionType.equals(TransactionType.CREDIT)){
				transaction.setTxType(TransactionType.CREDIT);
			}else{
				transaction.setTxType(TransactionType.DEBIT);
			}
		
			list.add(transaction);
		}	
	
		connection.close();

		return list;	
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	

}
