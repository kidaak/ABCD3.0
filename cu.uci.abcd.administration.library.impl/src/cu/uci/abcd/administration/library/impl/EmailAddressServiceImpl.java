package cu.uci.abcd.administration.library.impl;

import java.util.Collection;
import java.util.Map;

import cu.uci.abcd.administration.library.IEmailAddressService;
import cu.uci.abcd.administration.library.IFormationCourseService;
import cu.uci.abcd.administration.library.ILibraryService;
import cu.uci.abcd.administration.library.IPersonService;
import cu.uci.abcd.administration.library.IPostalAddressService;
import cu.uci.abcd.dao.common.EmailAddressDAO;
import cu.uci.abcd.dao.common.PersonDAO;
import cu.uci.abcd.dao.common.PostalAddressDAO;
import cu.uci.abcd.dao.management.library.LibraryDAO;
import cu.uci.abcd.domain.common.EmailAddress;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.common.PostalAddress;
import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abcd.domain.management.library.Library;

/**
 * 
 * @author Yaksel Duran Rivas
 * 
 */
public class EmailAddressServiceImpl implements IEmailAddressService{
	
	private EmailAddressDAO emailAddressDAO;

	public void bind(EmailAddressDAO emailAddressDAO, Map<?, ?> properties) {
		this.emailAddressDAO = emailAddressDAO;
	}

	public void deleteEmailAddress(EmailAddress emailAddress) {
		emailAddressDAO.delete(emailAddress);
		
	}

	@Override
	public Collection<EmailAddress> findByLibrary(Long idLibrary) {
		return (Collection<EmailAddress>) (emailAddressDAO).findDistinctEmailAddressByOwner_ActorID(idLibrary);
	}

}
