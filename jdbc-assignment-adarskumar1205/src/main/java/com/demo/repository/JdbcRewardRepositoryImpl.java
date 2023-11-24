package com.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.demo.model.Reward;



public class JdbcRewardRepositoryImpl implements RewardRepository {
	
	private DataSource dataSource;
	
	

	public JdbcRewardRepositoryImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void addReward(Reward reward) throws SQLException {
		Connection connection=dataSource.getConnection();
		String insertQuery="insert into reward(rewardAmount,accountNumber) values(?,?)";
		
		PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
		preparedStatement.setInt(1, reward.getRewardAmount());
		preparedStatement.setLong(2, reward.getAccountNumber());
		
		int rowsAffected = preparedStatement.executeUpdate();		
		
		if(rowsAffected > 0)
			System.out.println("rewards added");
		else 
			System.out.println("rewards not added");
		
	}

	public int getTotalRewardAmount(Long accountNumber) {
	
		return 0;
	}

	public List<Reward> getAllRewardsForAccount(Long accountNUmber) {
		
		return null;
	}

}
