package cu.uci.abcd.dao.common;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.common.Person;

public interface PersonDAO extends PagingAndSortingRepository<Person, Long> {

}
