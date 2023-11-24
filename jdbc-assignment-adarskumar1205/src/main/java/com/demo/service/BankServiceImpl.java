package com.demo.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.demo.model.Account;
import com.demo.model.TransactionDetail;
import com.demo.model.TransactionType;
import com.demo.repository.AccountRepository;
import com.demo.repository.RewardRepository;
import com.demo.repository.TransactionRepository;


public class BankServiceImpl implements BankService {
	
	private AccountRepository accountRepository;
	private TransactionRepository transactionRepository;
	private RewardRepository rewardRepository;	
	private EmailService emailService;
	
	//constructor to initialize the repositories 
	public BankServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		super();
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;
	}


	public Long transfer(Long fromAccountNumber, Long toAccountNumber, int amount) throws SQLException {
		
//		debit()
		Long transactionId = debit(amount,fromAccountNumber);
		
//		credit()
		Long transactionId2=credit(amount,toAccountNumber);
		
		return transactionId;  //return transactionId
	}

	

	public Long debit(int amount, Long accountNumber) throws SQLException {
		
		//find the account by the "findAccountByNumber"
		Account account =  accountRepository.findAccountByNumber(accountNumber);
		
		//account.debit(amount)
		account.debit(amount);
		//update the account in the db
		accountRepository.update(account);
		
		
		//create a new object TransactionDetails 
		TransactionDetail transaction = new TransactionDetail(accountNumber,new Date(),amount,TransactionType.DEBIT);
		
			//add the transactiondetail record into the db
		Long transactionId = transactionRepository.addTransaction(transaction);
		
		 //return transactionId
		return transactionId;

	}

	public Long credit(int amount, Long accountNumber) throws SQLException {

		Account account =  accountRepository.findAccountByNumber(accountNumber);
		
		//account.credit(amount)
		account.credit(amount);
		//update the account in the db
		accountRepository.update(account);
		
		
		//create a new object TransactionDetails 
		TransactionDetail transaction = new TransactionDetail(accountNumber,new Date(),amount,TransactionType.CREDIT);
		
			//add the transactiondetail record into the db
		Long transactionId = transactionRepository.addTransaction(transaction);
		

		
		return transactionId; //transactionid

		
	}

	public void createNewAccount(Account account) throws SQLException {
		accountRepository.save(account);
		
	}

	public void deActivateAccount(Long accountNumber) throws SQLException {
		Account account=accountRepository.findAccountByNumber(accountNumber);		
		account.setActive(false);		
		accountRepository.update(account);
		
	}

	public void activateAccount(Long accountNumber) throws SQLException {
		Account account=accountRepository.findAccountByNumber(accountNumber);		
		account.setActive(true);		
		accountRepository.update(account);
		
	}

	public List<Account> getAllAccounts() throws SQLException {
		System.out.println("BankServiceImpl.getAllAccounts()");
		return accountRepository.findAllAccounts();
	}


	public AccountRepository getAccountRepository() {
		return accountRepository;
	}


	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}


	public TransactionRepository getTransactionRepository() {
		return transactionRepository;
	}


	public void setTransactionRepository(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}


	public RewardRepository getRewardRepository() {
		return rewardRepository;
	}


	public void setRewardRepository(RewardRepository rewardRepository) {
		this.rewardRepository = rewardRepository;
	}


	public EmailService getEmailService() {
		return emailService;
	}


	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	

}
