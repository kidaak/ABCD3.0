package cu.uci.abcd.administration.library;

import java.util.Collection;
import cu.uci.abcd.domain.management.library.Library;

/**
 * 
 * @author Yaksel Duran Rivas
 * 
 */
public interface ILibraryService {

	public Library AddLibrary(Library library);

	public Library ReadLibrary(Long idLibrary);

	public void DeleteLibrary(Long idLibrary);

	public Collection<Library> findAll();
	
	public Collection<Library> findByLibraryName(String libraryName);
	
}
