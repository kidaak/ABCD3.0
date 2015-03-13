package cu.uci.abcd.circulation;

import java.util.Collection;
import java.util.List;

import cu.uci.abcd.domain.circulation.LoanUser;
import cu.uci.abcd.domain.circulation.LoanUserType;

public interface ILoanUserService {
	
	/**
	 * RF_CI1_Loan user register
	 * @param loanUser
	 * @return
	 */
	
	public LoanUser addLoanUser(LoanUser loanUser);
	
	/**
	 * RF_CI3_Loan user view
	 * @param idLoanUser
	 * @return
	 */
	
	public LoanUser viewLoanUser(Long idLoanUser);
	
	/**
	 * RF_CI2_Loan user edit
	 * @param idLoanUser
	 * @return
	 */
		
	public LoanUser editLoanUser(Long idLoanUser);
	
	/**
	 * RF_CI4_Loan user delete
	 * @param idLoanUser
	 */
		
	public void deleteLoanUser(Long idLoanUser);
	
	/**
	 * Loan user list
	 * @return
	 */
	
	public Collection<LoanUser> findAll();
	
	/**
	 * Loan user one
	 * @return
	 */
	
	public LoanUser findOneLoanUser(Long idLoanUser);
	
	/**
	 * Loan user type list
	 * @return
	 */
	
	public List<LoanUserType> findAllLoanUserType();
	
	
	public Collection<LoanUser> findByLoanUserName(String loanUserName);
	
	public LoanUser findByLoanUserCode(String loanUserCode);
	
	

}
