package com.bumbalbee.service;

import java.sql.SQLException;
import java.util.List;

import com.bumbalbee.dao.LoanManager;
import com.bumbalbee.model.Loan;

public class LoanService {

	private static LoanService loanServiceObj;

	public LoanService() {

	}
	
	public static synchronized LoanService getLoanServiceInstance() {
		if(loanServiceObj == null) {
			loanServiceObj = new LoanService();
		}
		return loanServiceObj;
	}
	
	private LoanManager getLoanManager() {
		return new LoanManager();
	}
	
	public boolean registerLoan(Loan loan) throws ClassNotFoundException, SQLException {
		return getLoanManager().addLoan(loan);
	}
	
	public Loan getSpecificLoan(int loanId) throws ClassNotFoundException, SQLException {
		return getLoanManager().getSpecificLoan(loanId);
	}
	
	public List<Loan> getAllLoans() throws ClassNotFoundException, SQLException{
		return getLoanManager().getAllLoans();
	}
	
	public boolean editLoan(Loan loan) throws ClassNotFoundException, SQLException {
		return getLoanManager().updateLoan(loan);
	}
	
	public boolean deleteLoan(int loanId) throws ClassNotFoundException, SQLException {
		return getLoanManager().deleteLoan(loanId);
	}
	
}
