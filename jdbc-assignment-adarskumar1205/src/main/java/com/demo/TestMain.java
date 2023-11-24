package com.demo;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.commons.dbcp2.BasicDataSource;

import com.demo.config.DBUtil;
import com.demo.model.Account;
import com.demo.model.Address;
import com.demo.repository.AccountRepository;
import com.demo.repository.JPAAccountRepositoryImpl;
import com.demo.repository.JdbcAccountRepositoryImpl;
import com.demo.repository.JdbcTransactionRepositoryImpl;
import com.demo.repository.TransactionRepository;
import com.demo.service.BankService;
import com.demo.service.BankServiceImpl;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create BasicDataSource 
//		DBUtil dbUtil = new DBUtil();
//		BasicDataSource ds = dbUtil.getDataSource();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdbc-task");
		EntityManager entityManager =factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
//		Account account = new Account();
//			account.setAccountNumber((long)4);
//		 	account.setName("abc");
//			account.setActive(true);
//			account.setCity("Mumbai");
//			account.setCountry("India");
//			account.setBalance(6000);
//			account.setEmailAddress("abc123@gmail.com");
//		transaction.begin();
//		entityManager.persist(account);
//		transaction.commit();
//		//create JDBCAccountRepositoryImpl + JDBCTransactionRepositoryImpl
//		AccountRepository accRepoJDBC = new JdbcAccountRepositoryImpl(ds);
//		TransactionRepository transcRepoJDBC = new JdbcTransactionRepositoryImpl(ds);

		AccountRepository accRepoJPA = new JPAAccountRepositoryImpl(entityManager);
		
//		try {
//			accRepoJPA.delete(account);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//Create Bank Service 
//		BankService bankService = new BankServiceImpl(accRepoJDBC,transcRepoJDBC);
//		
//		//test the transfer() method
//		
//		try {
//			bankService.transfer((long)1,(long)2, 200);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
