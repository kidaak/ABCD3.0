package cu.uci.abcd.circulation.ui.controller;

import java.util.Collection;
import java.util.List;

import cu.uci.abcd.circulation.ILoanUserService;
import cu.uci.abcd.domain.circulation.Transaction;
import cu.uci.abos.ui.api.IViewController;

public class TransactionViewController implements IViewController 
{
	 private AllManagementLoanUserViewController allManagementLoanUserViewController;


	   public AllManagementLoanUserViewController getAllManagementLoanUserViewController() {
			return allManagementLoanUserViewController;
		}

		public void setAllManagementLoanUserViewController(
				AllManagementLoanUserViewController allManagementLoanUserViewController) {
			this.allManagementLoanUserViewController = allManagementLoanUserViewController;
		}
	      
	  
		/*transaction*/
		public Transaction addTransaction(Transaction transaction) {
			return allManagementLoanUserViewController.getManageTransaction().addTransaction(transaction);
		}
		
		public Collection<Transaction> findTransaction() {
			return allManagementLoanUserViewController.getManageTransaction().findAllTransaction();
		}
		
		public void deletePenalty(Long idTransaction){
			allManagementLoanUserViewController.getManageTransaction().deleteTransaction(idTransaction);		
		}
		
}
