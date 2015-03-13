package cu.uci.abcd.circulation.ui.controller;

import java.util.Collection;
import java.util.List;

import cu.uci.abcd.circulation.ILoanUserService;
import cu.uci.abcd.domain.circulation.Reservation;
import cu.uci.abos.ui.api.IViewController;

public class ReservationViewController implements IViewController 
{
	 private AllManagementLoanUserViewController allManagementLoanUserViewController;


	   public AllManagementLoanUserViewController getAllManagementLoanUserViewController() {
			return allManagementLoanUserViewController;
		}

		public void setAllManagementLoanUserViewController(
				AllManagementLoanUserViewController allManagementLoanUserViewController) {
			this.allManagementLoanUserViewController = allManagementLoanUserViewController;
		}
	      
	  
		/*reservation*/
		public Reservation addReservation(Reservation reservation) {
			return allManagementLoanUserViewController.getManageReservation().addReservation(reservation);
		}
		
		public Collection<Reservation> findReservation() {
			return allManagementLoanUserViewController.getManageReservation().findAllReservation();
		}
		
		public void deletePenalty(Long idReservation){
			allManagementLoanUserViewController.getManageReservation().deleteReservation(idReservation);		
		}
		
}
