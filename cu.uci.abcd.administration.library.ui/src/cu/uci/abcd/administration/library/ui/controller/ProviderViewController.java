package cu.uci.abcd.administration.library.ui.controller;

import java.util.Collection;

import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Provider;
import cu.uci.abos.ui.api.IViewController;

public class ProviderViewController implements IViewController {
	
	private AllManagementLibraryViewController allManagementLibraryViewController;
	
	public AllManagementLibraryViewController getAllManagementLibraryViewController() {
		return allManagementLibraryViewController;
	}

	public void setAllManagementLibraryViewController(
			AllManagementLibraryViewController allManagementLibraryViewController) {
		this.allManagementLibraryViewController = allManagementLibraryViewController;
	}
	
	/* PROVIDER */
	public Provider SaveProvider(Provider provider) {
		return allManagementLibraryViewController.getProviderService().AddProvider(provider);
	}
	
	public Collection<Provider> findAllProviders() {
		return allManagementLibraryViewController.getProviderService().findAll();
	}
	
	public Provider getProviderById(Long idProvider) {
		return allManagementLibraryViewController.getProviderService().ReadProvider(idProvider);
	}
	
	/* PERSON */
	public Collection<Person> findAllPerson() {
		return allManagementLibraryViewController.getPersonService().findAll();
	}
	
	public Person getPersonById(Long idPerson) {
		return allManagementLibraryViewController.getPersonService().ReadPerson(idPerson);
	}

}
