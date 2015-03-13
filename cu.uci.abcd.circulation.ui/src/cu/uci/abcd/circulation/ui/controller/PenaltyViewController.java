package cu.uci.abcd.circulation.ui.controller;

import java.util.Collection;
import java.util.List;

import cu.uci.abcd.circulation.ILoanUserService;
import cu.uci.abcd.domain.circulation.Penalty;
import cu.uci.abcd.domain.management.library.Coin;
import cu.uci.abos.ui.api.IViewController;

public class PenaltyViewController implements IViewController{
	
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
      
  
	/* Penalty */
	public Penalty addPenalty(Penalty penalty) {
		return allManagementLoanUserViewController.getManagePenalty().addPenalty(penalty);
	}
	
	public Collection<Penalty> findPenalty() {
		return allManagementLoanUserViewController.getManagePenalty().findAllPenalty();
	}
	
	public void deletePenalty(Long idPenalty){
		allManagementLoanUserViewController.getManagePenalty().deletePenalty(idPenalty);		
	}
	
	
	public Collection<Penalty> findPenaltybyLoanUser(Long idLoanUser) {
		return allManagementLoanUserViewController.getManagePenalty().findPenaltybyLoanUser(idLoanUser);
	}
	
	
	/* Coin */
	public  List<Coin> findAllCoin() {
		return allManagementLoanUserViewController.getManagePenalty().findAllCoin();
	}	
	
	
}
