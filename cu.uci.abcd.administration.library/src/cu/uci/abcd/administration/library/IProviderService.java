package cu.uci.abcd.administration.library;

import java.util.Collection;
import cu.uci.abcd.domain.management.library.Provider;

/**
 * 
 * @author Yaksel Duran Rivas
 * 
 */
public interface IProviderService {
	
    public Provider AddProvider(Provider provider);
	
	public Provider ReadProvider(Long idProvider);
	
	public Provider UpdateProvider(Long idProvider);
	
	public void DeleteProvider(Long idProvider);
	
	public Collection<Provider> findAll();
}
