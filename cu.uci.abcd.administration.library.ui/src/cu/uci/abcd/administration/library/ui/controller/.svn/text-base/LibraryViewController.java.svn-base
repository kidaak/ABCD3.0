package cu.uci.abcd.administration.library.ui.controller;

import java.util.Collection;

import cu.uci.abcd.domain.common.EmailAddress;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.common.PostalAddress;
import cu.uci.abcd.domain.common.WorkerType;
import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abcd.domain.management.library.Library;
import cu.uci.abcd.domain.management.library.Worker;
import cu.uci.abos.ui.api.IViewController;

public class LibraryViewController implements IViewController {
	
	private AllManagementLibraryViewController allManagementLibraryViewController;
	
	public AllManagementLibraryViewController getAllManagementLibraryViewController() {
		return allManagementLibraryViewController;
	}

	public void setAllManagementLibraryViewController(
			AllManagementLibraryViewController allManagementLibraryViewController) {
		this.allManagementLibraryViewController = allManagementLibraryViewController;
	}
	
	
	/* LIBRARY */
	public Library SaveLibrary(Library library) {
		return allManagementLibraryViewController.getLibraryService().AddLibrary(library);
	}
	
	public Collection<Library> findAllLibraries() {
		return allManagementLibraryViewController.getLibraryService().findAll();
	}
	
	public void deleteLibraryById(Long idLibrary) {
		allManagementLibraryViewController.getLibraryService().DeleteLibrary(idLibrary);
	}
	
	public Library getLibraryById(Long idLibrary) {
		return allManagementLibraryViewController.getLibraryService().ReadLibrary(idLibrary);
	}
	
	public Collection<Library> findByLibraryName(String libraryName) {
		return allManagementLibraryViewController.getLibraryService().findByLibraryName(libraryName);
	}

	/* FORMATION COURSE */
	public FormationCourse SaveFormationCourse(FormationCourse formationCourse) {
		return allManagementLibraryViewController.getFormationCourseService().AddFormationCourse(formationCourse);
	}
	
	public Collection<FormationCourse> findAllFormationCourse() {
		return allManagementLibraryViewController.getFormationCourseService().findAll();
	}
	
	public Collection<FormationCourse> findFormationCourseByLibrary(Long idLibrary) {
		return allManagementLibraryViewController.getFormationCourseService().findByLibrary(idLibrary);
	}
	
	public void deleteFormationCourseById(Long idFormationCourse) {
		allManagementLibraryViewController.getFormationCourseService().DeleteFormationCourse(idFormationCourse);
	}
	
	/* PERSON */
	public Person getPersonById(Long idPerson) {
		return allManagementLibraryViewController.getPersonService().ReadPerson(idPerson);
	}
	
	public Collection<Person> findAllPerson() {
		return allManagementLibraryViewController.getPersonService().findAll();
	}
	
	/* WORKERTYPE */
	public Collection<WorkerType> findAllWorkerType() {
		return allManagementLibraryViewController.getWorkerTypeService().findAll();
	}
	
	/* WORKER */
	public Worker SaveWorker(Worker worker) {
		return allManagementLibraryViewController.getWorkerService().AddWorker(worker);
	}
	
	public Collection<Worker> findWorkerByLibrary(Long idLibrary) {
		return allManagementLibraryViewController.getWorkerService().findByLibrary(idLibrary);
	}
	
	public void deleteWorkerById(Long idWorker) {
		allManagementLibraryViewController.getWorkerService().DeleteWorker(idWorker);
	}
	
	/* POSTALADDRESS */
	public Collection<PostalAddress> findPostalAddresByLibrary(Long idLibrary) {
		return allManagementLibraryViewController.getPostalAddressService().findByLibrary(idLibrary);
	}
	
	public void deletePostalAddres(PostalAddress postalAddress) {
		allManagementLibraryViewController.getPostalAddressService().deletePostalAddress(postalAddress);
	}
	
	/* EMAILADDRESS */
	public Collection<EmailAddress> findEmailAddresByLibrary(Long idLibrary) {
		return allManagementLibraryViewController.getEmailAddressService().findByLibrary(idLibrary);
	}
	
	public void deleteEmaillAddres(EmailAddress emailAddress) {
		allManagementLibraryViewController.getEmailAddressService().deleteEmailAddress(emailAddress);
	}
	
	
	
}
