package cu.uci.abcd.circulation.ui.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import cu.uci.abcd.circulation.ILoanUserService;
import cu.uci.abcd.dao.circulation.LoanUserDAO;
import cu.uci.abcd.domain.circulation.LoanUser;
import cu.uci.abcd.domain.circulation.LoanUserType;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abos.ui.api.IViewController;

public class LoanUserViewController implements IViewController{
	
    /**
     * @see ILoanUserService
     */
	
   private AllManagementLoanUserViewController allManagementLoanUserViewController;


   public AllManagementLoanUserViewController getAllManagementLoanUserViewController() {
		return allManagementLoanUserViewController;
	}

	public void setAllManagementLoanUserViewController(
			AllManagementLoanUserViewController allManagementLoanUserViewController) {
		this.allManagementLoanUserViewController = allManagementLoanUserViewController;
	}
      
  
	/* Loan User */
	public LoanUser addLoanUser(LoanUser loanUser) {
		return allManagementLoanUserViewController.getManageLoanUser().addLoanUser(loanUser);
	}
	
	public Collection<LoanUser> findLoanUser() {
		return allManagementLoanUserViewController.getManageLoanUser().findAll();
	}
	
	public void deleteLoanUser(Long idLoanUser){
		allManagementLoanUserViewController.getManageLoanUser().deleteLoanUser(idLoanUser);		
	}
	
	public LoanUser findOneLoanUser(Long idLoanUser) {
		return allManagementLoanUserViewController.getManageLoanUser().findOneLoanUser(idLoanUser);
	}
	
	public Collection<LoanUser> findByLoanUserName(String loanUserName) {
		return allManagementLoanUserViewController.getManageLoanUser().findByLoanUserName(loanUserName);
	}
	
	public LoanUser findByLoanUserCode(String loanUserCode) {
		return allManagementLoanUserViewController.getManageLoanUser().findByLoanUserCode(loanUserCode);
	}
	
	/* Loan User Type */
	public  List<LoanUserType> findAllLoanUserType() {
		return allManagementLoanUserViewController.getManageLoanUser().findAllLoanUserType();
	}	
	
	/* PERSON */
	public Collection<Person> findAllPerson() {
		return allManagementLoanUserViewController.getPersonService().findAllPerson();
	}
	
	public Person findOnePerson(Long idPerson) {
		return allManagementLoanUserViewController.getPersonService().findOnePerson(idPerson);
	}
	
}
