package cu.uci.abcd.administration.library;

import java.util.Collection;
import cu.uci.abcd.domain.common.PostalAddress;

/**
 * 
 * @author Yaksel Duran Rivas
 * 
 */
public interface IPostalAddressService {

	public Collection<PostalAddress> findByLibrary(Long idLibrary);
	
	public void deletePostalAddress(PostalAddress postalAddress);
	
}
