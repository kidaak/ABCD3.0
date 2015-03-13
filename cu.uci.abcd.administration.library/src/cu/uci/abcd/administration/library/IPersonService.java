package cu.uci.abcd.administration.library;

import java.util.Collection;

import cu.uci.abcd.domain.common.Person;

/**
 * 
 * @author Yaksel Duran Rivas
 * 
 */
public interface IPersonService {

	public Person ReadPerson(Long idPerson);
	
	public Collection<Person> findAll();
}
