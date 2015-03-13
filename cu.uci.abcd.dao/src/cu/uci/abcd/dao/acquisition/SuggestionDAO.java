package cu.uci.abcd.dao.acquisition;

import org.springframework.data.repository.PagingAndSortingRepository;

import cu.uci.abcd.domain.acquisition.Suggestion;

public interface SuggestionDAO extends
		PagingAndSortingRepository<Suggestion, Long> {

}
