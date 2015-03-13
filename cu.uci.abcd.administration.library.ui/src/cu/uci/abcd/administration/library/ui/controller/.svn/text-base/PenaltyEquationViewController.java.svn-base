package cu.uci.abcd.administration.library.ui.controller;

import java.util.Collection;

import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.PenaltyEquation;
import cu.uci.abcd.domain.management.library.Provider;
import cu.uci.abos.ui.api.IViewController;

public class PenaltyEquationViewController implements IViewController {
	
	private AllManagementLibraryViewController allManagementLibraryViewController;
	
	public AllManagementLibraryViewController getAllManagementLibraryViewController() {
		return allManagementLibraryViewController;
	}

	public void setAllManagementLibraryViewController(
			AllManagementLibraryViewController allManagementLibraryViewController) {
		this.allManagementLibraryViewController = allManagementLibraryViewController;
	}
	
	public PenaltyEquation SavePenaltyEquation(PenaltyEquation penaltyEquation) {
		return allManagementLibraryViewController.getPenaltyEquationService().AddPenaltyEquation(penaltyEquation);
	}
	
	public PenaltyEquation findPenaltyEquationByLibrary(Long idLibrary) {
		return allManagementLibraryViewController.getPenaltyEquationService().ReadPenaltyEquation(idLibrary);
	}

	public Library getLibraryById(Long idLibrary) {
		return allManagementLibraryViewController.getLibraryService().ReadLibrary(idLibrary);
	}

}
