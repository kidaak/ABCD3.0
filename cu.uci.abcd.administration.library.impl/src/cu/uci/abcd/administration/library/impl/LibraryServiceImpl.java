package cu.uci.abcd.administration.library.impl;

import java.util.Collection;
import java.util.Map;

import cu.uci.abcd.administration.library.IFormationCourseService;
import cu.uci.abcd.administration.library.ILibraryService;
import cu.uci.abcd.dao.common.PersonDAO;
import cu.uci.abcd.dao.management.library.LibraryDAO;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.management.library.Library;

/**
 * 
 * @author Yaksel Duran Rivas
 * 
 */
public class LibraryServiceImpl implements ILibraryService{
	
	private LibraryDAO libraryDAO;

	public void bind(LibraryDAO libraryDAO, Map<?, ?> properties) {
		this.libraryDAO = libraryDAO;
	}
	
	@Override
	public Library AddLibrary(Library library) {
		return libraryDAO.save(library);
	}

	@Override
	public Library ReadLibrary(Long idLibrary) {
		return libraryDAO.findOne(idLibrary);
	}

	@Override
	public void DeleteLibrary(Long idLibrary) {
		libraryDAO.delete(idLibrary);
		
	}

	@Override
	public Collection<Library> findAll() {
		return (Collection<Library>) libraryDAO.findAll();
	}

	@Override
	public Collection<Library> findByLibraryName(String libraryName) {
		return (Collection<Library>) libraryDAO.findDistinctLibraryByLibraryName(libraryName);
	}
	
}
