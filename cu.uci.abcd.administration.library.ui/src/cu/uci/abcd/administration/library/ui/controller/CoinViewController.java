package cu.uci.abcd.administration.library.ui.controller;

import java.util.Collection;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.management.library.Coin;
import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Provider;
import cu.uci.abos.ui.api.IViewController;

public class CoinViewController implements IViewController {
	
	private AllManagementLibraryViewController allManagementLibraryViewController;
	
	public AllManagementLibraryViewController getAllManagementLibraryViewController() {
		return allManagementLibraryViewController;
	}

	public void setAllManagementLibraryViewController(
			AllManagementLibraryViewController allManagementLibraryViewController) {
		this.allManagementLibraryViewController = allManagementLibraryViewController;
	}
	
	public Coin SaveCoin(Coin coin) {
		return allManagementLibraryViewController.getCoinService().AddCoin(coin);
	}
	
	public Collection<Coin> findAllCoins() {
		return allManagementLibraryViewController.getCoinService().findAll();
	}
	
}
