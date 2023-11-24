package com.demo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import com.demo.model.Account;

public class JPAAccountRepositoryImpl implements AccountRepository {
	
	private EntityManager entityManager;
	
	public JPAAccountRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public Account findAccountByNumber(Long accountNUmber) throws SQLException {
		
		return entityManager.find(Account.class, accountNUmber);
	}
	
	public List<Account> findAllAccounts() throws SQLException {
		 TypedQuery<Account> query = entityManager.createQuery("SELECT a FROM Account a", Account.class);
		   
		 return query.getResultList();
	}

	public void save(Account account) throws SQLException {
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		entityManager.persist(account);
		transaction.commit();
	}

	public void update(Account account) throws SQLException {
		Account acc = entityManager.find(Account.class, account.getAccountNumber());
		
		if(acc!=null) {
			EntityTransaction transaction = entityManager.getTransaction();
			
			transaction.begin();
			acc.setCity(account.getCity());
			acc.setCountry(account.getCountry());
			acc.setBalance(account.getBalance());
			acc.setName(account.getName());
			acc.setEmailAddress(account.getEmailAddress());
			acc.setActive(account.isActive());
			transaction.commit();
		}
	}

	public void delete(Account account) throws SQLException {

		Account acc = entityManager.find(Account.class, account.getAccountNumber());
		
		if(acc!=null) {
			//begin the transaction
			EntityTransaction transaction = entityManager.getTransaction();
			
			transaction.begin();
			entityManager.remove(acc);
			//commit the transaction
			transaction.commit();
		}
	
	}

}
	