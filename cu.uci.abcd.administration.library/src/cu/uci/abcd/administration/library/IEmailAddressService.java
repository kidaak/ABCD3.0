package cu.uci.abcd.administration.library;

import java.util.Collection;

import cu.uci.abcd.domain.common.EmailAddress;
import cu.uci.abcd.domain.common.PostalAddress;

/**
 * 
 * @author Yaksel Duran Rivas
 * 
 */
public interface IEmailAddressService {

	public Collection<EmailAddress> findByLibrary(Long idLibrary);
	
	public void deleteEmailAddress(EmailAddress emailAddress);
	
}
