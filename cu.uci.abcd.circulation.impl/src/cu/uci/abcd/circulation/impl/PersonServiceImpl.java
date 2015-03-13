package cu.uci.abcd.circulation.impl;

import java.util.Collection;
import java.util.Map;

import cu.uci.abcd.circulation.IPersonService;
import cu.uci.abcd.dao.common.PersonDAO;
import cu.uci.abcd.domain.common.Person;

/**
 * 
 * @author Yanet Crespo Diaz
 * 
 */
public class PersonServiceImpl implements IPersonService{
	
	private PersonDAO personDAO;

	@Override
	public Person addPerson(Person person) {
		return personDAO.save(person);
	}

	@Override
	public Person readPerson(Long idPerson) {
	   return personDAO.findOne(idPerson);
	}

	@Override
	public Person updatePerson(int idPerson) {
		return null;
	}

	@Override
	public void deletePerson(Long idPerson) {
		personDAO.delete(idPerson);
	}

	@Override
	public Collection<Person> findAllPerson() {
		return (Collection<Person>) personDAO.findAll();
	}
	
	@Override
	public Person findOnePerson(Long idPerson) {
		return personDAO.findOne(idPerson);
	}
	
	public void bind(PersonDAO personDAO, Map<?, ?> properties) {
		this.personDAO = personDAO;
	}



}
