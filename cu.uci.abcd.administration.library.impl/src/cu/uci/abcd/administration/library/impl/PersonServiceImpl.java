package cu.uci.abcd.administration.library.impl;

import java.util.Collection;
import java.util.Map;

import cu.uci.abcd.administration.library.IFormationCourseService;
import cu.uci.abcd.administration.library.ILibraryService;
import cu.uci.abcd.administration.library.IPersonService;
import cu.uci.abcd.dao.common.PersonDAO;
import cu.uci.abcd.dao.management.library.LibraryDAO;
import cu.uci.abcd.domain.common.Person;
import cu.uci.abcd.domain.management.library.Library;

/**
 * 
 * @author Yaksel Duran Rivas
 * 
 */
public class PersonServiceImpl implements IPersonService{
	
	private PersonDAO personDAO;

	public void bind(PersonDAO personDAO, Map<?, ?> properties) {
		this.personDAO = personDAO;
	}

	/**
	 * Requisito funcional Mostrar Personas
	 * @see IFormationCourseService
	 */
	@Override
	public Collection<Person> findAll() {
		return (Collection<Person>) personDAO.findAll();
	}

	@Override
	public Person ReadPerson(Long idPerson) {
		return personDAO.findOne(idPerson);
	}
}
