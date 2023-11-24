package com.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.demo.model.Account;
import com.demo.model.Address;

public class JdbcAccountRepositoryImpl implements AccountRepository {
	
	private DataSource dataSource;
	
	public JdbcAccountRepositoryImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public Account findAccountByNumber(Long accountNUmber) throws SQLException {
		Account account = null;
		
			Connection connection = dataSource.getConnection();
			String selectQuery = "SELECT * FROM account where accountNumber =?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			
			preparedStatement.setLong(1, accountNUmber);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				Long num = resultSet.getLong("accountNumber");
				String name  = resultSet.getString("name");
				String city = resultSet.getString("city");
				String country = resultSet.getString("country");
				String emailaddress = resultSet.getString("emailaddress");
				int balance = resultSet.getInt("balance");
				boolean active = resultSet.getBoolean("isactive");
				
				account = new Account(num,name,active,balance,emailaddress,city,country);
			}	
		
			connection.close();

		return account;
	}

	public List<Account> findAllAccounts() throws SQLException {
		
		List<Account> list = new ArrayList<>();
		
		Account account = null;
		
		Connection connection = dataSource.getConnection();
		
		String selectQuery = "SELECT * FROM account ";
		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			Long num = resultSet.getLong("accountNumber");
			String name  = resultSet.getString("name");
			String city = resultSet.getString("city");
			String country = resultSet.getString("country");
			String emailaddress = resultSet.getString("emailaddress");
			int balance = resultSet.getInt("balance");
			boolean active = resultSet.getBoolean("isactive");
			
			list.add(new Account(num,name,active,balance,emailaddress,city,country));
		}	
	
		connection.close();

		return list;
	}

	public void save(Account account) throws SQLException {
			Connection connection = this.dataSource.getConnection();
			//create the statement object 
			String insertQuery = "INSERT INTO account(name,isactive,city,country,balance,emailaddress) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setString(1, account.getName());
			preparedStatement.setBoolean(2, account.isActive());
			preparedStatement.setString(3, account.getAddress().getCity());
			preparedStatement.setString(4, account.getAddress().getCountry());
			preparedStatement.setInt(5, account.getBalance());
			preparedStatement.setString(6, account.getEmailAddress());
			//execute the statements 
			int rowsAffected = preparedStatement.executeUpdate();		
			
			if(rowsAffected > 0)
				System.out.println("Account saved");
			else 
				System.out.println("Account not saved");	
	
	}

	public void update(Account account) throws SQLException {
		Connection connection = dataSource.getConnection();
		String updateQuery = "UPDATE account set name=?,isactive=?,city=?,country=?,balance=?,emailaddress=? where accountNumber =?";
		PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
		
		preparedStatement.setString(1, account.getName());
		preparedStatement.setBoolean(2, account.isActive());
		preparedStatement.setString(3, account.getAddress().getCity());
		preparedStatement.setString(4, account.getAddress().getCountry());
		preparedStatement.setInt(5, account.getBalance());
		preparedStatement.setString(6, account.getEmailAddress());	
		preparedStatement.setLong(7, account.getAccountNumber());
		int rowsAffected = preparedStatement.executeUpdate();
		
		if(rowsAffected>0) {
			System.out.println("account updated");
		}
		else {
			System.out.println("account not updated");
		}
	}

	public void delete(Account account) throws SQLException {
		Connection connection = dataSource.getConnection();
		String deleteQuery = "UPDATE account set isactive=? where accountNumber =?";
		PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
		preparedStatement.setInt(1, 0);	
		preparedStatement.setLong(2, account.getAccountNumber());
		
		int rowsAffected = preparedStatement.executeUpdate();	
	
		if(rowsAffected>0) {
			System.out.println("account deleted");
		}
		else {
			System.out.println("account not deleted");
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	

}
