package cu.uci.abcd.administration.library.impl;

import java.util.Collection;
import java.util.Map;

import cu.uci.abcd.administration.library.IFormationCourseService;
import cu.uci.abcd.administration.library.ILibraryService;
import cu.uci.abcd.administration.library.IPersonService;
import cu.uci.abcd.administration.library.IPostalAddressService;
import cu.uci.abcd.dao.common.PersonDAO;
import cu.uci.abcd.dao.common.PostalAddressDAO;
import cu.uci.abcd.dao.management.library.LibraryDAO;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.common.PostalAddress;
import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abcd.domain.management.library.Library;

/**
 * 
 * @author Yaksel Duran Rivas
 * 
 */
public class PostalAddressServiceImpl implements IPostalAddressService{
	
	private PostalAddressDAO postalAddressDAO;

	public void bind(PostalAddressDAO postalAddressDAO, Map<?, ?> properties) {
		this.postalAddressDAO = postalAddressDAO;
	}

	public void deletePostalAddress(PostalAddress postalAddress) {
		postalAddressDAO.delete(postalAddress);
		
	}

	@Override
	public Collection<PostalAddress> findByLibrary(Long idLibrary) {
		return (Collection<PostalAddress>) (postalAddressDAO).findDistinctPostalAddressByOwner_ActorID(idLibrary);
		
		//return null;
	}

	


}
